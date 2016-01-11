package com.rules.mvc.model;

import java.util.List;

import com.rules.mvc.dao.util.RuleAccessLevel;
import com.rules.mvc.model.mongo.RuleDetails;
import com.rules.mvc.model.mongo.RuleTypeInfo;

public class PopulateRulesDataUI {
	
	List<String> categoryList;
	List<String> statusList;
	List<String> criticalityList;
	List<RuleTypeInfo> ruleTypeList;
	//user type ruleDetails/GroupType rule details/application type
	List<RuleDetailsDisplay> ruleDetailsDispList;
	List<RuleAccessLevel> ruleAccessLvlList;
	
	
	public List<String> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
	}
	public List<String> getStatusList() {
		return statusList;
	}
	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}
	public List<String> getCriticalityList() {
		return criticalityList;
	}
	public void setCriticalityList(List<String> criticalityList) {
		this.criticalityList = criticalityList;
	}
	public List<RuleTypeInfo> getRuleTypeList() {
		return ruleTypeList;
	}
	public void setRuleTypeList(List<RuleTypeInfo> ruleTypeList) {
		this.ruleTypeList = ruleTypeList;
	}
	public List<RuleDetailsDisplay> getRuleDetailsDispList() {
		return ruleDetailsDispList;
	}
	public void setRuleDetailsDispList(List<RuleDetailsDisplay> ruleDetailsDispList) {
		this.ruleDetailsDispList = ruleDetailsDispList;
	}
	public List<RuleAccessLevel> getRuleAccessLvlList() {
		return ruleAccessLvlList;
	}
	public void setRuleAcessLvlList(List<RuleAccessLevel> ruleAccessLvlList) {
		this.ruleAccessLvlList = ruleAccessLvlList;
	}	
	
	
}
