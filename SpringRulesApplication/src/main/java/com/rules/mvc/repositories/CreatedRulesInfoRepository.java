package com.rules.mvc.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rules.mvc.dao.util.RuleAccessLevel;
import com.rules.mvc.model.mongo.CreatedRulesInfo;

public interface CreatedRulesInfoRepository extends MongoRepository<CreatedRulesInfo, Long>{
	
	List<CreatedRulesInfo> findAllByRuleAccessLevelAndEntityIDAndCategoryAndRuleTypeInfoId (RuleAccessLevel ruleAccessLevel,
			String entityID, String category,long ruleTypeInfoId);

}
