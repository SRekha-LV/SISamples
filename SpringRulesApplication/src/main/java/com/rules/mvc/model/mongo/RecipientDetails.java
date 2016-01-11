package com.rules.mvc.model.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class RecipientDetails {
	
	@Id
	long id;
	String recipientType;
	String recipientValue;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRecipientType() {
		return recipientType;
	}
	public void setRecipientType(String recipientType) {
		this.recipientType = recipientType;
	}
	public String getRecipientValue() {
		return recipientValue;
	}
	public void setRecipientValue(String recipientValue) {
		this.recipientValue = recipientValue;
	}

}
