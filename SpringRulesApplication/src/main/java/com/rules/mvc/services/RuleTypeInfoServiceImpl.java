package com.rules.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rules.mvc.model.mongo.RuleTypeInfo;
import com.rules.mvc.repositories.RuleTypeInfoRepository;

@Service
public class RuleTypeInfoServiceImpl implements RuleTypeInfoService {

	@Autowired
	RuleTypeInfoRepository ruleTypeInfoRepo;
	
	@Override
	public List<RuleTypeInfo> getAllRuleTypes () {
		return ruleTypeInfoRepo.findAll();
	}
	
	@Override
	public RuleTypeInfo getRuleTypeInfoById (Long ruleTypeInfoId) {
		return ruleTypeInfoRepo.findOne(ruleTypeInfoId);
	}
	
	@Override
	public List<RuleTypeInfo> getRuleTypesByIdList (List<Long> ruleTypeIdList) {
		return ruleTypeInfoRepo.findByIdIn(ruleTypeIdList);
	}
}
