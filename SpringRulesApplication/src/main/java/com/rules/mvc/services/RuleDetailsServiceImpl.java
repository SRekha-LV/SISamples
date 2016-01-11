package com.rules.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rules.mvc.model.mongo.RuleDetails;
import com.rules.mvc.model.mongo.RuleTypeInfo;
import com.rules.mvc.repositories.RuleDetailsRepository;
import com.rules.mvc.repositories.RuleTypeInfoRepository;

@Service
public class RuleDetailsServiceImpl implements RuleDetailsService {

	@Autowired
	RuleDetailsRepository ruleDetailsRepo;
	
	@Autowired
	RuleTypeInfoRepository ruleTypeInfoRepo;
	
	@Override
	public RuleDetails getRuleDetailsByRuleType (String ruleType) {
		RuleDetails ruleDetails = null;
		RuleTypeInfo ruleTypeInfo = ruleTypeInfoRepo.findByRuleTypeIgnoreCase(ruleType);
		return ruleDetailsRepo.findByRuleTypeId(ruleTypeInfo.getId());
	}
	
	@Override
	public List<RuleDetails> getAllRuleDetails () {
		List<RuleDetails> ruleDetailsList = ruleDetailsRepo.findAll();
		return ruleDetailsList;
	}
}
