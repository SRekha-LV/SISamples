package com.rules.mvc.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rules.mvc.model.SupportingRulesInfo;
import com.rules.mvc.model.RecipientType;
import com.rules.mvc.model.SelectedRulesInfo;
import com.rules.mvc.model.mongo.ActionDetails;
import com.rules.mvc.model.mongo.CommunicationTypeInfo;
import com.rules.mvc.model.mongo.ConditionDetails;
import com.rules.mvc.model.mongo.RecipientDetails;
import com.rules.mvc.model.mongo.RuleTypeInfo;
import com.rules.mvc.services.ActionDetailsService;
import com.rules.mvc.services.CommTypeInfoService;
import com.rules.mvc.services.ConditionDetailsService;
import com.rules.mvc.services.RecipientDetailsService;
import com.rules.mvc.services.RuleTypeInfoService;
import com.rules.mvc.services.RuleTypeService;

@Controller
@RequestMapping ("/rules")
public class RulesController {
	
	@Autowired
	RuleTypeService ruleTypeService; 
	
	@Autowired
	StaticDataHelper staticDataHelper;
	

	@RequestMapping (method = RequestMethod.GET)
	public String setupForm (Model model) {
		model.addAttribute("rulesInfo", getStartupRuleDetails ());
		model.addAttribute ("selectedRuleInfo", new SelectedRulesInfo());
		return "createRulesData";
	}
	
	@RequestMapping (method = RequestMethod.POST)
	public String saveRule (@ModelAttribute("selectedRuleInfo") SelectedRulesInfo selRulesInfo, Model model) {
		ruleTypeService.saveRuleDetails(selRulesInfo);
		
		model.addAttribute ("message", staticDataHelper.getCreatedRuleData(selRulesInfo));
		model.addAttribute("rulesInfo", getStartupRuleDetails ());
		model.addAttribute ("selectedRuleInfo", new SelectedRulesInfo());
		return "createRulesData";
	}
	
	private SupportingRulesInfo getStartupRuleDetails () {
		SupportingRulesInfo rulesInfo = new SupportingRulesInfo ();
		rulesInfo.setRuleTypeLst(staticDataHelper.getRuleTypeList ());
		rulesInfo.setFieldTypeList(staticDataHelper.getFieldTypeMap ());
		rulesInfo.setRecipientTypeList(staticDataHelper.getRecipientDetails());
		rulesInfo.setCommTypeList(staticDataHelper.getCommunicationTypeList ());
		return rulesInfo;
	}
	
}
