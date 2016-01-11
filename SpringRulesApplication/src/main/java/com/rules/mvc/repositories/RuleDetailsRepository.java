package com.rules.mvc.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.rules.mvc.model.mongo.RuleDetails;

@Component
public interface RuleDetailsRepository extends MongoRepository<RuleDetails, String> {
	public RuleDetails findByRuleTypeId (long ruleTypeId);
}
