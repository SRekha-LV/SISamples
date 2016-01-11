package com.rules.mvc.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rules.mvc.model.mongo.ConditionDetails;
import com.rules.mvc.repositories.ConditionDetailsRepository;

@Service
public class ConditionDetailsServiceImpl implements ConditionDetailsService {
	
	@Autowired
	ConditionDetailsRepository condDetRepository;

	@Override
	public List<ConditionDetails> getAllConditions () {
		return condDetRepository.findAll();
	}
	
	@Override
	public List<ConditionDetails> getAllConditionsByIdSet (Set<Long> conditionIdSet) {
		List<ConditionDetails> conditionsList = new ArrayList<ConditionDetails> ();
		if (conditionIdSet != null) {
			Iterator<Long> conditionIter = conditionIdSet.iterator();
			while (conditionIter.hasNext()) {
				conditionsList.add(condDetRepository.findById(conditionIter.next()));
			}//while
		}//if
		
		return conditionsList;
	}
	
	@Override
	public ConditionDetails getConditionDetailsById (Long conditionId) {
		return condDetRepository.findById(conditionId);
	}
}
