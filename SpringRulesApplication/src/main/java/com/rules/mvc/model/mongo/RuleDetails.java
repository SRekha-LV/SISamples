package com.rules.mvc.model.mongo;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class RuleDetails {
	
	@Id
	long id;
	long ruleTypeId;
	Set<Long> conditionDet1IdSet;
	Set<Long> conditionDet2IdSet;
	Set<Long> conditionDet3IdSet;
	Set<Long> actionDet1IdSet;
	Set<Long> actionDet2IdSet;
	//Communication Type Id set
	Set<Long> commTypeIdSet;
	Set<Long> recipientDet1IdSet;
	Set<Long> recipientDet2IdSet;
	
	//TODO: mailformatId
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getRuleTypeId() {
		return ruleTypeId;
	}
	public void setRuleTypeId(long ruleTypeId) {
		this.ruleTypeId = ruleTypeId;
	}
	public Set<Long> getConditionDet1IdSet() {
		return conditionDet1IdSet;
	}
	public void setConditionDet1IdSet(Set<Long> conditionDet1IdSet) {
		this.conditionDet1IdSet = conditionDet1IdSet;
	}
	public Set<Long> getConditionDet2IdSet() {
		return conditionDet2IdSet;
	}
	public void setConditionDet2IdSet(Set<Long> conditionDet2IdSet) {
		this.conditionDet2IdSet = conditionDet2IdSet;
	}
	public Set<Long> getConditionDet3IdSet() {
		return conditionDet3IdSet;
	}
	public void setConditionDet3IdSet(Set<Long> conditionDet3IdSet) {
		this.conditionDet3IdSet = conditionDet3IdSet;
	}
	public Set<Long> getActionDet1IdSet() {
		return actionDet1IdSet;
	}
	public void setActionDet1IdSet(Set<Long> actionDet1IdSet) {
		this.actionDet1IdSet = actionDet1IdSet;
	}
	public Set<Long> getActionDet2IdSet() {
		return actionDet2IdSet;
	}
	public void setActionDet2IdSet(Set<Long> actionDet2IdSet) {
		this.actionDet2IdSet = actionDet2IdSet;
	}
	public Set<Long> getCommTypeIdSet() {
		return commTypeIdSet;
	}
	public void setCommTypeIdSet(Set<Long> commTypeIdSet) {
		this.commTypeIdSet = commTypeIdSet;
	}
	public Set<Long> getRecipientDet1IdSet() {
		return recipientDet1IdSet;
	}
	public void setRecipientDet1IdSet(Set<Long> recipientDet1IdSet) {
		this.recipientDet1IdSet = recipientDet1IdSet;
	}
	public Set<Long> getRecipientDet2IdSet() {
		return recipientDet2IdSet;
	}
	public void setRecipientDet2IdSet(Set<Long> recipientDet2IdSet) {
		this.recipientDet2IdSet = recipientDet2IdSet;
	}
	
}
