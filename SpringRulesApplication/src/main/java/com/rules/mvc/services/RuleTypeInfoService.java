package com.rules.mvc.services;

import java.util.List;

import com.rules.mvc.model.mongo.RuleTypeInfo;

public interface RuleTypeInfoService {

	public List<RuleTypeInfo> getAllRuleTypes();

	public RuleTypeInfo getRuleTypeInfoById(Long ruleTypeInfoId);

	public List<RuleTypeInfo> getRuleTypesByIdList(List<Long> ruleTypeIdList);

}
