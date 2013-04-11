package org.medical.model.mongo;

import org.springframework.util.StringUtils;

public class PatientSearch {
	
	private String code = org.apache.commons.lang.StringUtils.EMPTY;
	private String firstname = org.apache.commons.lang.StringUtils.EMPTY;
	private String lastname = org.apache.commons.lang.StringUtils.EMPTY;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public void checkValidSearchCriteria() {
		if (!StringUtils.hasText(code) && !StringUtils.hasText(firstname) && !StringUtils.hasText(lastname)) {
			throw new IllegalArgumentException("Invalid search criteria");
		}
	}
	public boolean firstnameHasText() {
		return StringUtils.hasText(firstname);
	}
	public boolean lastnameHasText() {
		return StringUtils.hasText(lastname);
	}
}
