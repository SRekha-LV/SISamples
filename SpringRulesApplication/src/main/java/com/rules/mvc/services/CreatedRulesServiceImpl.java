package com.rules.mvc.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rules.mvc.dao.util.SequenceCounter;
import com.rules.mvc.model.mongo.CreatedRulesInfo;
import com.rules.mvc.repositories.CreatedRulesInfoRepository;

@Service
public class CreatedRulesServiceImpl implements ICreatedRulesService {
	
	@Autowired
	CreatedRulesInfoRepository createdRuleRepo;
	
	@Autowired
	SequenceCounter seqCounter;
	
	@Override
	public CreatedRulesInfo saveCreatedRuleDetails (CreatedRulesInfo createdRule) {
		List<CreatedRulesInfo> existingCRLst = createdRuleRepo.findAllByRuleAccessLevelAndEntityIDAndCategoryAndRuleTypeInfoId(createdRule.getRuleAccessLevel(),
				createdRule.getEntityID(), createdRule.getCategory(), createdRule.getRuleTypeInfoId ());
		
		if (existingCRLst != null && existingCRLst.size () > 0) {
			Iterator<CreatedRulesInfo> crIter = existingCRLst.iterator();
			while (crIter.hasNext()) {
				CreatedRulesInfo crInfo = crIter.next();
				if (crInfo.getActionId_1() == createdRule.getActionId_1() && 
						crInfo.getActionId_2() == createdRule.getActionId_2() &&
						crInfo.getConditionId_1() == createdRule.getConditionId_1() &&
						crInfo.getConditionId_2() == createdRule.getConditionId_2() && 
						crInfo.getConditionId_3() == createdRule.getConditionId_3() && 
						crInfo.getCommTypeId() == createdRule.getCommTypeId() && 
						crInfo.getRecipientId_1() == createdRule.getRecipientId_1() &&
						crInfo.getRecipientId_2() == createdRule.getRecipientId_2()) {
					return crInfo;
				}
			}
		}
		
		createdRule.setId(seqCounter.getNextSequence(SequenceCounter.CREATED_RULES_KEY, SequenceCounter.CREATED_RULES_COUNTER));
		createdRule = createdRuleRepo.save(createdRule);
		return createdRule;
	}
	
	
	@Override
	public List<CreatedRulesInfo> getAllCreatedRules () {
		return createdRuleRepo.findAll();
	}

}
