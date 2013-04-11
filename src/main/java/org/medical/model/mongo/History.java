package org.medical.model.mongo;

import java.util.HashMap;
import java.util.Map;

public class History {
	
	private Map<String, String> attributes = new HashMap<String, String>();

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void addAttributes(String key, String value) {
		this.attributes.put(key, value);
	}

}
