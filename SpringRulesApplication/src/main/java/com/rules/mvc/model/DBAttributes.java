package com.rules.mvc.model;

public class DBAttributes {
	
	String displayName;
	String fieldName;
	String fieldValue;
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	@Override
	public String toString() {
		return "DBAttributes [displayName=" + displayName + ", fieldName="
				+ fieldName + ", fieldValue=" + fieldValue + "]";
	}
	
}
