package com.rules.mvc.model;

public class SelectedRulesInfo {
	
	String ruleType;
	DBAttributes conditionValue1;
	DBAttributes conditionValue2;
	DBAttributes conditionValue3;
	DBAttributes actionValue1;
	DBAttributes actionValue2;
	String communicationType;
	String recipientType1;
	String roleType1;
	String roleType2;
	String recipientType2;

	public String getRuleType() {
		return ruleType;
	}

	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}

	public DBAttributes getConditionValue1() {
		return conditionValue1;
	}

	public void setConditionValue1(DBAttributes conditionValue1) {
		this.conditionValue1 = conditionValue1;
	}

	public DBAttributes getConditionValue2() {
		return conditionValue2;
	}

	public void setConditionValue2(DBAttributes conditionValue2) {
		this.conditionValue2 = conditionValue2;
	}

	public DBAttributes getConditionValue3() {
		return conditionValue3;
	}

	public void setConditionValue3(DBAttributes conditionValue3) {
		this.conditionValue3 = conditionValue3;
	}

	public DBAttributes getActionValue1() {
		return actionValue1;
	}

	public void setActionValue1(DBAttributes actionValue1) {
		this.actionValue1 = actionValue1;
	}

	public DBAttributes getActionValue2() {
		return actionValue2;
	}

	public void setActionValue2(DBAttributes actionValue2) {
		this.actionValue2 = actionValue2;
	}

	public String getCommunicationType() {
		return communicationType;
	}

	public void setCommunicationType(String communicationType) {
		this.communicationType = communicationType;
	}

	public String getRecipientType1() {
		return recipientType1;
	}

	public void setRecipientType1(String recipientType1) {
		this.recipientType1 = recipientType1;
	}

	public String getRecipientType2() {
		return recipientType2;
	}

	public void setRecipientType2(String recipientType2) {
		this.recipientType2 = recipientType2;
	}
	
	public String getRoleType1() {
		return roleType1;
	}

	public void setRoleType1(String roleType1) {
		this.roleType1 = roleType1;
	}

	public String getRoleType2() {
		return roleType2;
	}

	public void setRoleType2(String roleType2) {
		this.roleType2 = roleType2;
	}

}
