package com.rules.mvc.model.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.rules.mvc.dao.util.RuleAccessLevel;

@Document
public class CreatedRulesInfo {

	@Id
	private long id;
	private String ruleTitle;	
	//event or scheduled
	private String category;
	//active/inactive/delete
	private String status;
	private String criticality;
	private String description;
	//user/group/appication
	private long ruleTypeInfoId;
	private long conditionId_1;
	private long conditionId_2;
	private long conditionId_3;
	private long actionId_1;
	private long actionId_2;
	private long commTypeId;
	private long recipientId_1;
	private long recipientId_2;
	
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
	
	public String getRuleTitle() {
		return ruleTitle;
	}
	public void setRuleTitle(String ruleTitle) {
		this.ruleTitle = ruleTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getRuleTypeInfoId() {
		return ruleTypeInfoId;
	}
	public void setRuleTypeInfoId(long ruleTypeInfoId) {
		this.ruleTypeInfoId = ruleTypeInfoId;
	}
	public long getConditionId_1() {
		return conditionId_1;
	}
	public void setConditionId_1(long conditionId_1) {
		this.conditionId_1 = conditionId_1;
	}
	public long getConditionId_2() {
		return conditionId_2;
	}
	public void setConditionId_2(long conditionId_2) {
		this.conditionId_2 = conditionId_2;
	}
	public long getConditionId_3() {
		return conditionId_3;
	}
	public void setConditionId_3(long conditionId_3) {
		this.conditionId_3 = conditionId_3;
	}
	public long getActionId_1() {
		return actionId_1;
	}
	public void setActionId_1(long actionId_1) {
		this.actionId_1 = actionId_1;
	}
	public long getActionId_2() {
		return actionId_2;
	}
	public void setActionId_2(long actionId_2) {
		this.actionId_2 = actionId_2;
	}
	public long getCommTypeId() {
		return commTypeId;
	}
	public void setCommTypeId(long commTypeId) {
		this.commTypeId = commTypeId;
	}
	public long getRecipientId_1() {
		return recipientId_1;
	}
	public void setRecipientId_1(long recipientId_1) {
		this.recipientId_1 = recipientId_1;
	}
	public long getRecipientId_2() {
		return recipientId_2;
	}
	public void setRecipientId_2(long recipientId_2) {
		this.recipientId_2 = recipientId_2;
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
		return "CreatedRulesInfo [id=" + id + ", ruleTitle=" + ruleTitle
				+ ", category=" + category + ", status=" + status
				+ ", criticality=" + criticality + ", description="
				+ description + ", ruleTypeInfoId=" + ruleTypeInfoId
				+ ", conditionId_1=" + conditionId_1 + ", conditionId_2="
				+ conditionId_2 + ", conditionId_3=" + conditionId_3
				+ ", actionId_1=" + actionId_1 + ", actionId_2=" + actionId_2
				+ ", commTypeId=" + commTypeId + ", recipientId_1="
				+ recipientId_1 + ", recipientId_2=" + recipientId_2
				+ ", ruleAccessLevel=" + ruleAccessLevel + ", entityID="
				+ entityID + "]";
	}
	
}
