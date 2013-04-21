package org.medical.service.impl;

import org.bson.types.ObjectId;
import org.medical.dao.mongo.PatientDao;
import org.medical.model.mongo.*;
import org.medical.service.PatientManager;
import org.medical.service.ReferenceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import javax.ws.rs.PathParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service("patientManager")
@WebService(serviceName = "PatientService", endpointInterface = "org.medical.service.PatientManager")
public class PatientManagerImpl implements PatientManager {
	
	@Autowired
    PatientDao repository;
    @Autowired
    ReferenceManager referenceManage;
	QPatient patient = QPatient.patient;

    @Override
    public Patient save(Patient patient) {
        if (patient.getCaseNumber() != null) {
            Patient inDB = repository.findOne(this.patient.caseNumber.eq(patient.getCaseNumber()));
            if (inDB != null) {
                //replace existing database record with new
                patient.setId(inDB.getId());
            }
        }
        addReferences(patient);
        return repository.save(patient);
    }

    private void addReferences(Patient patient) {
        referenceManage.add(ReferenceKey.HISTORY, patient.getHistory().keySet());
        referenceManage.add(ReferenceKey.DIAGNOSIS, patient.getDiagnosis().keySet());
        referenceManage.add(ReferenceKey.EXAMINATION, patient.getExamination().keySet());
        referenceManage.add(ReferenceKey.INVESTIGATION, patient.getInvestigation().keySet());
        referenceManage.add(ReferenceKey.TEST, patient.getTest().keySet());
    }

    @Override
    public void remove(String id) {
       repository.delete(new ObjectId(id));
    }

    @Override
    public Patient find(String searchString) {
        return repository.findOne(patient.firstname.equalsIgnoreCase(searchString));
    }

    @Override
    public List<Patient> findAll(String searchString) {
        Iterator<Patient> iter = repository.findAll(patient.firstname.containsIgnoreCase(searchString)).iterator();
        List<Patient> copy = new ArrayList<Patient>();
        while (iter.hasNext())
            copy.add(iter.next());
        return copy;
    }
}
