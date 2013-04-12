package org.medical.model.mongo;

import org.springframework.util.StringUtils;

public class PatientSearch {
	
	private String caseNumber = org.apache.commons.lang.StringUtils.EMPTY;
	private String firstname = org.apache.commons.lang.StringUtils.EMPTY;
	private String lastname = org.apache.commons.lang.StringUtils.EMPTY;

    public PatientSearch() { }

    public String getCaseNumber() {
        return caseNumber;
    }

    public void setCaseNumber(String caseNumber) {
        this.caseNumber = caseNumber;
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
		if (!StringUtils.hasText(caseNumber) && !StringUtils.hasText(firstname) && !StringUtils.hasText(lastname)) {
			throw new IllegalArgumentException("Invalid search criteria");
		}
	}
}
