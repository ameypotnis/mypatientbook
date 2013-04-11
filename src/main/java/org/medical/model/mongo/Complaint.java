package org.medical.model.mongo;

import java.util.HashMap;
import java.util.Map;

public class Complaint {
	
	private String chiefComplaint;
	private String associatedComplaint;
	private Map<String, String> examination = new HashMap<String, String>();
	private Map<String, String> investigation = new HashMap<String, String>();
	private Map<String, String> test = new HashMap<String, String>();
	private Map<String, String> diagnosis = new HashMap<String, String>();

	public String getChiefComplaint() {
		return chiefComplaint;
	}

	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}

	public String getAssociatedComplaint() {
		return associatedComplaint;
	}

	public void setAssociatedComplaint(String associatedComplaint) {
		this.associatedComplaint = associatedComplaint;
	}

	public Map<String, String> getExamination() {
		return examination;
	}

	public void addExamination(String key, String value) {
		this.examination.put(key, value);
	}

	public Map<String, String> getInvestigation() {
		return investigation;
	}

	public void addInvestigation(String key, String value) {
		this.investigation.put(key, value);
	}

	public Map<String, String> getDiagnosis() {
		return diagnosis;
	}

	public void addDiagnosis(String key, String value) {
		this.diagnosis.put(key, value);
	}

	public Map<String, String> getTest() {
		return test;
	}

	public void addTest(String key, String value) {
		this.test.put(key, value);
	}

}
