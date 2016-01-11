package com.rules.mvc.model;

import java.util.List;
import java.util.Map;

public class SupportingRulesInfo {
	Map<String, String> ruleTypeLst;
	Map<String, List<String>> fieldTypeList;
	List<RecipientType> recipientTypeList;
	List<String> commTypeList;
	
	
	public Map<String, String> getRuleTypeLst() {
		return ruleTypeLst;
	}
	public void setRuleTypeLst(Map<String, String> ruleTypeLst) {
		this.ruleTypeLst = ruleTypeLst;
	}
	public Map<String, List<String>> getFieldTypeList() {
		return fieldTypeList;
	}
	public void setFieldTypeList(Map<String, List<String>> fieldTypeList) {
		this.fieldTypeList = fieldTypeList;
	}
	public List<RecipientType> getRecipientTypeList() {
		return recipientTypeList;
	}
	public void setRecipientTypeList(List<RecipientType> recipientTypeList) {
		this.recipientTypeList = recipientTypeList;
	}
	public List<String> getCommTypeList() {
		return commTypeList;
	}
	public void setCommTypeList(List<String> commTypeList) {
		this.commTypeList = commTypeList;
	}
	
	
}
