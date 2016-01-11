package com.rules.mvc.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.rules.mvc.model.mongo.RuleTypeInfo;

@Component
public interface RuleTypeInfoRepository extends MongoRepository<RuleTypeInfo, Long>{
	
	public RuleTypeInfo findByRuleTypeIgnoreCase (String ruleType);
	public List<RuleTypeInfo> findByIdIn (List<Long> ids);

}
