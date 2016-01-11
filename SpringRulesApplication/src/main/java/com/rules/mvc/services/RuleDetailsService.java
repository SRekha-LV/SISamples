package com.rules.mvc.services;

import java.util.List;

import com.rules.mvc.model.mongo.RuleDetails;

public interface RuleDetailsService {

	public RuleDetails getRuleDetailsByRuleType(String ruleType);

	public List<RuleDetails> getAllRuleDetails();

}
