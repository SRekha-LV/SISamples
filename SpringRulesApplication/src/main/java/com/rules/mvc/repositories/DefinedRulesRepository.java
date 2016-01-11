package com.rules.mvc.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rules.mvc.model.mongo.DefinedRulesInfo;

public interface DefinedRulesRepository extends MongoRepository<DefinedRulesInfo, Long> {
	public List<DefinedRulesInfo> findByRuleTypeInfoIdAndConditionId1AndConditionId2AndConditionId3 (
			Long ruleTypeInfoId, Long conditionId1, Long conditionId2,
			 Long conditionId3);
}
