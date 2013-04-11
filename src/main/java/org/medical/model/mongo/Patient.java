package org.medical.model.mongo;

import java.io.Serializable;
import java.util.*;

import javax.sound.midi.Track;
import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * An {@link org.medical.model.mongo.Patient} represents a collection of {@link javax.sound.midi.Track}s.
 * 
 */
@Document
@XmlRootElement
public class Patient  implements Serializable {

	@Id
	private ObjectId id;
	private String code;
	private String firstname;
	private String lastname;
	private Date dateOfBirth;
	private String sex;
	private String occupation;
	private Long mobile;
	private String address;

  /*  private Map<String, String> history = new HashMap<String, String>();
    private String chiefComplaint;
    private String associatedComplaint;
    private Map<String, String> examination = new HashMap<String, String>();
    private Map<String, String> investigation = new HashMap<String, String>();
    private Map<String, String> test = new HashMap<String, String>();
    private Map<String, String> diagnosis = new HashMap<String, String>();*/

	private List<Followup> followups = new ArrayList<Followup>();
	
	public Patient() {	}

	public Patient(String firstname, String lastname) {
		Assert.isTrue(StringUtils.hasText(firstname), "firstname must be given!");
		Assert.isTrue(StringUtils.hasText(lastname), "lastname must be given!");

		this.id = new ObjectId();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Patient(String code) {
		this.code = code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ObjectId getId() {
		return id;
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

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public List<Followup> getFollowups() {
		return followups;
	}

	public void addFollowups(Followup followup) {
		this.followups.add(followup);
	}
	
	public String getCode() {
		return code;
	}


    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }


    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", sex='" + sex + '\'' +
                ", occupation='" + occupation + '\'' +
                ", mobile=" + mobile +
                ", address='" + address + '\'' +
                ", followups=" + followups +
                '}';
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}
	
}
