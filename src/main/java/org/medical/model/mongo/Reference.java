package org.medical.model.mongo;

import javax.xml.bind.annotation.XmlRootElement;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@XmlRootElement
public class Reference {

	@Id
	private ObjectId id;
	private ReferenceKey key;
	private String value;
	
	public Reference(ReferenceKey key) {
		this.key = key;
	}

	public ObjectId getId() {
		return id;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ReferenceKey getKey() {
		return key;
	}

	@Override
	public String toString() {
		return "Reference [key=" + key + ", value=" + value + "]";
	}

}