package com.rules.mvc.model;

import com.rules.mvc.dao.util.RuleAccessLevel;

public class CreatedRulesDisplay {
	
	private long id;
	private String ruleTitle;	
	//event or scheduled
	private String category;
	//active/inactive/delete
	private String status;
	private String criticality;
	private String description;
	//user/group/appication
	private String ruleTypeInfo;
	private String condition_1;
	private String condition_2;
	private String condition_3;
	private String action_1;
	private String action_2;
	private String commType;
	private String recipient_1;
	private String recipient_2;
	
	//Global/Group/Application - this gives 
	//information on whether the rule defined
	//is a global rule /group rule or appication rule
	private RuleAccessLevel ruleAccessLevel;
	
	//groupID, applicationID, this would be blank for the Global rules
	private String entityID;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRuleTitle() {
		return ruleTitle;
	}

	public void setRuleTitle(String ruleTitle) {
		this.ruleTitle = ruleTitle;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCriticality() {
		return criticality;
	}

	public void setCriticality(String criticality) {
		this.criticality = criticality;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRuleTypeInfo() {
		return ruleTypeInfo;
	}

	public void setRuleTypeInfo(String ruleTypeInfo) {
		this.ruleTypeInfo = ruleTypeInfo;
	}

	public String getCondition_1() {
		return condition_1;
	}

	public void setCondition_1(String condition_1) {
		this.condition_1 = condition_1;
	}

	public String getCondition_2() {
		return condition_2;
	}

	public void setCondition_2(String condition_2) {
		this.condition_2 = condition_2;
	}

	public String getCondition_3() {
		return condition_3;
	}

	public void setCondition_3(String condition_3) {
		this.condition_3 = condition_3;
	}

	public String getAction_1() {
		return action_1;
	}

	public void setAction_1(String action_1) {
		this.action_1 = action_1;
	}

	public String getAction_2() {
		return action_2;
	}

	public void setAction_2(String action_2) {
		this.action_2 = action_2;
	}

	public String getCommType() {
		return commType;
	}

	public void setCommType(String commType) {
		this.commType = commType;
	}

	public String getRecipient_1() {
		return recipient_1;
	}

	public void setRecipient_1(String recipient_1) {
		this.recipient_1 = recipient_1;
	}

	public String getRecipient_2() {
		return recipient_2;
	}

	public void setRecipient_2(String recipient_2) {
		this.recipient_2 = recipient_2;
	}

	public RuleAccessLevel getRuleAccessLevel() {
		return ruleAccessLevel;
	}

	public void setRuleAccessLevel(RuleAccessLevel ruleAccessLevel) {
		this.ruleAccessLevel = ruleAccessLevel;
	}

	public String getEntityID() {
		return entityID;
	}

	public void setEntityID(String entityID) {
		this.entityID = entityID;
	}

	@Override
	public String toString() {
		return "CreatedRulesDisplay [id=" + id + ", ruleTitle=" + ruleTitle
				+ ", category=" + category + ", status=" + status
				+ ", criticality=" + criticality + ", description="
				+ description + ", ruleTypeInfo=" + ruleTypeInfo
				+ ", condition_1=" + condition_1 + ", condition_2="
				+ condition_2 + ", condition_3=" + condition_3 + ", action_1="
				+ action_1 + ", action_2=" + action_2 + ", commType="
				+ commType + ", recipient_1=" + recipient_1 + ", recipient_2="
				+ recipient_2 + ", ruleAccessLevel=" + ruleAccessLevel
				+ ", entityID=" + entityID + "]";
	}
	

}
