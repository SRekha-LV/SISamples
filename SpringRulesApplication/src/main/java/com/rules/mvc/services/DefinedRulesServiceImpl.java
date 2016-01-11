package com.rules.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rules.mvc.model.mongo.DefinedRulesInfo;
import com.rules.mvc.repositories.DefinedRulesRepository;

@Service
public class DefinedRulesServiceImpl implements DefinedRulesService {
	
	
	@Autowired
	DefinedRulesRepository defRulesInfoRepo;
	
	@Override
	public List<DefinedRulesInfo> getAllDefinedRules () {
		return defRulesInfoRepo.findAll();
	}

}
