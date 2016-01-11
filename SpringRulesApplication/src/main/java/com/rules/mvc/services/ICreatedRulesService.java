package com.rules.mvc.services;

import java.util.List;

import com.rules.mvc.model.mongo.CreatedRulesInfo;

public interface ICreatedRulesService {

	public CreatedRulesInfo saveCreatedRuleDetails(CreatedRulesInfo createdRule);

	public List<CreatedRulesInfo> getAllCreatedRules();

}
