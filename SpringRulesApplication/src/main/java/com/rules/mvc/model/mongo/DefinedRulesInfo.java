package com.rules.mvc.model.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DefinedRulesInfo {
	@Id
	private long id;
	private long ruleTypeInfoId;
	private long conditionId1;
	private long conditionId2;
	private long conditionId3;
	private long actionId1;
	private long actionId2;
	private long communicationTypeId;
	private long recipientId1;
	private long recipientId2;
	private long commFormatId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getRuleTypeInfoId() {
		return ruleTypeInfoId;
	}
	public void setRuleTypeInfoId(long ruleTypeInfoId) {
		this.ruleTypeInfoId = ruleTypeInfoId;
	}
	public long getConditionId1() {
		return conditionId1;
	}
	public void setConditionId1(long conditionId1) {
		this.conditionId1 = conditionId1;
	}
	public long getConditionId2() {
		return conditionId2;
	}
	public void setConditionId2(long conditionId2) {
		this.conditionId2 = conditionId2;
	}
	public long getConditionId3() {
		return conditionId3;
	}
	public void setConditionId3(long conditionId3) {
		this.conditionId3 = conditionId3;
	}
	public long getActionId1() {
		return actionId1;
	}
	public void setActionId1(long actionId1) {
		this.actionId1 = actionId1;
	}
	public long getActionId2() {
		return actionId2;
	}
	public void setActionId2(long actionId2) {
		this.actionId2 = actionId2;
	}
	public long getCommunicationTypeId() {
		return communicationTypeId;
	}
	public void setCommunicationTypeId(long communicationTypeId) {
		this.communicationTypeId = communicationTypeId;
	}
	public long getRecipientId1() {
		return recipientId1;
	}
	public void setRecipientId1(long recipientId1) {
		this.recipientId1 = recipientId1;
	}
	public long getRecipientId2() {
		return recipientId2;
	}
	public void setRecipientId2(long recipientId2) {
		this.recipientId2 = recipientId2;
	}
	public long getCommFormatId() {
		return commFormatId;
	}
	public void setCommFormatId(long commFormatId) {
		this.commFormatId = commFormatId;
	} 
	
}
