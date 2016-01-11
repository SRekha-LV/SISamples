package com.rules.mvc.model;

import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.rules.mvc.model.mongo.ActionDetails;
import com.rules.mvc.model.mongo.CommunicationTypeInfo;
import com.rules.mvc.model.mongo.ConditionDetails;
import com.rules.mvc.model.mongo.RecipientDetails;

@Document
public class RuleDetailsDisplay {
	
	@Id
	long id;
	long ruleTypeId;
	List<ConditionDetails> conditionDetList1;
	List<ConditionDetails> conditionDetList2;
	List<ConditionDetails> conditionDetList3;
	List<ActionDetails> actionDetList1;
	List<ActionDetails> actionDetList2;
	//Communication Type List
	List<CommunicationTypeInfo> commTypeList;
	List<RecipientDetails> recipientDetList1;
	List<RecipientDetails> recipientDetList2;
	
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
	public List<ConditionDetails> getConditionDetList1() {
		return conditionDetList1;
	}
	public void setConditionDetList1(List<ConditionDetails> conditionDetList1) {
		this.conditionDetList1 = conditionDetList1;
	}
	public List<ConditionDetails> getConditionDetList2() {
		return conditionDetList2;
	}
	public void setConditionDetList2(List<ConditionDetails> conditionDetList2) {
		this.conditionDetList2 = conditionDetList2;
	}
	public List<ConditionDetails> getConditionDetList3() {
		return conditionDetList3;
	}
	public void setConditionDetList3(List<ConditionDetails> conditionDetList3) {
		this.conditionDetList3 = conditionDetList3;
	}
	public List<ActionDetails> getActionDetList1() {
		return actionDetList1;
	}
	public void setActionDetList1(List<ActionDetails> actionDetList1) {
		this.actionDetList1 = actionDetList1;
	}
	public List<ActionDetails> getActionDetList2() {
		return actionDetList2;
	}
	public void setActionDetList2(List<ActionDetails> actionDetList2) {
		this.actionDetList2 = actionDetList2;
	}
	public List<CommunicationTypeInfo> getCommTypeList() {
		return commTypeList;
	}
	public void setCommTypeList(List<CommunicationTypeInfo> commTypeList) {
		this.commTypeList = commTypeList;
	}
	public List<RecipientDetails> getRecipientDetList1() {
		return recipientDetList1;
	}
	public void setRecipientDetList1(List<RecipientDetails> recipientDetList1) {
		this.recipientDetList1 = recipientDetList1;
	}
	public List<RecipientDetails> getRecipientDetList2() {
		return recipientDetList2;
	}
	public void setRecipientDetList2(List<RecipientDetails> recipientDetList2) {
		this.recipientDetList2 = recipientDetList2;
	}
	
}