package org.medical.service;

import org.medical.model.mongo.Complaint;
import org.medical.model.mongo.Followup;
import org.medical.model.mongo.History;
import org.medical.model.mongo.Patient;

public interface PatientManager {
	public void add(Patient patient);
	public void remove(Patient patient);
	public Iterable<Patient> findAll(String search);
	public void updatePersonalInfo(Patient patient);
	public void addHistory(History history);
	public void addComplaint(Complaint complaint);
	public void addFollowup(Followup followup);
	public Patient find(String code);
}
