package com.rules.mvc.services;

import java.util.List;
import java.util.Set;

import com.rules.mvc.model.mongo.ConditionDetails;

public interface ConditionDetailsService {

	public List<ConditionDetails> getAllConditions();

	public List<ConditionDetails> getAllConditionsByIdSet(Set<Long> conditionIdSet);

	public ConditionDetails getConditionDetailsById(Long conditionId);

}
