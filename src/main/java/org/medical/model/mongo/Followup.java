package org.medical.model.mongo;

import java.util.Date;

public class Followup {
	
	private Date date;
	private String complaint;
	private String comment;

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}
