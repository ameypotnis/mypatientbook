package org.medical.service.impl;

import org.bson.types.ObjectId;
import org.medical.dao.mongo.PatientDao;
import org.medical.model.mongo.*;
import org.medical.service.PatientManager;
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
	QPatient patient = QPatient.patient;

    @Override
    public void add(Patient patient) {
        repository.save(patient);
    }

    @Override
    public void remove(@PathParam("id") String id) {
       repository.delete(new ObjectId(id));
    }

    @Override
    public void update(@PathParam("id") String id, Patient patient) {
        repository.save(patient);
    }

    @Override
    public Patient find(@PathParam("searchId") String searchString) {
        return repository.findOne(patient.firstname.equalsIgnoreCase(searchString));
    }

    @Override
    public List<Patient> findAll(@PathParam("searchId") String searchString) {
        Iterator<Patient> iter = repository.findAll(patient.firstname.containsIgnoreCase(searchString)).iterator();
        List<Patient> copy = new ArrayList<Patient>();
        while (iter.hasNext())
            copy.add(iter.next());
        return copy;
    }
}
