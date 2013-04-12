package org.medical.service.impl;

import org.medical.dao.mongo.PatientDao;
import org.medical.model.mongo.*;
import org.medical.service.PatientManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
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
	public void remove(Patient patient) {
		repository.delete(patient);
	}

	@Override
	public List<Patient> findAll(String search) {
        Iterator<Patient> iter = repository.findAll(patient.firstname.containsIgnoreCase(search)).iterator();
        List<Patient> copy = new ArrayList<Patient>();
        while (iter.hasNext())
            copy.add(iter.next());
        System.out.println("AP==== " + copy);
		return copy;
	}

	@Override
	public void updatePersonalInfo(Patient patient) {
		PatientSearch search = new PatientSearch();
		search.setFirstname(patient.getFirstname());
//		return repository.save(entities)		
	}

	@Override
	public Patient find(String code) {
		return repository.findOne(patient.caseNumber.eq(code));
	}

	@Override
	public void addFollowup(Followup followup) {
		// TODO Auto-generated method stub
		
	}

}
