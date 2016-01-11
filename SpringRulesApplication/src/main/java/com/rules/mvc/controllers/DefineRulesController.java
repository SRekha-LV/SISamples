package com.rules.mvc.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.activation.CommandInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rules.mvc.dao.util.RuleAccessLevel;
import com.rules.mvc.model.CreatedRulesDisplay;
import com.rules.mvc.model.PopulateRulesDataUI;
import com.rules.mvc.model.RuleDetailsDisplay;
import com.rules.mvc.model.mongo.ActionDetails;
import com.rules.mvc.model.mongo.CommunicationTypeInfo;
import com.rules.mvc.model.mongo.ConditionDetails;
import com.rules.mvc.model.mongo.CreatedRulesInfo;
import com.rules.mvc.model.mongo.RecipientDetails;
import com.rules.mvc.model.mongo.RuleDetails;
import com.rules.mvc.model.mongo.RuleTypeInfo;
import com.rules.mvc.services.ActionDetailsService;
import com.rules.mvc.services.CommTypeInfoService;
import com.rules.mvc.services.ConditionDetailsService;
import com.rules.mvc.services.ICreatedRulesService;
import com.rules.mvc.services.RecipientDetailsService;
import com.rules.mvc.services.RuleDetailsService;
import com.rules.mvc.services.RuleTypeInfoService;

@Controller
@RequestMapping ("/defSampleRules")
public class DefineRulesController {
	
	@Autowired	
	RuleDetailsService ruleDetailsService;
	
	@Autowired
	RuleTypeInfoService ruleTypeService;
	
	@Autowired
	ConditionDetailsService condDetService;
	
	@Autowired
	ActionDetailsService actionDetService;
	
	@Autowired
	CommTypeInfoService commTypeInfoService;
	
	@Autowired
	RecipientDetailsService recptDetService;
	
	@Autowired
	RuleTypeInfoService ruleTypeInfoServ;
	
	@Autowired
	ICreatedRulesService createdRuleService;
	
	@RequestMapping (method = RequestMethod.GET)
	public String setUpForm (Model model) {
		PopulateRulesDataUI populateRulesUI = getRulesDataForUI ();
		CreatedRulesInfo createdRulesInfo = new CreatedRulesInfo();
		
		model.addAttribute("populateRulesUI", populateRulesUI);
		model.addAttribute ("createdRulesInfo", createdRulesInfo);
		return "defSampleRules";
	}//setUpform
	
	@RequestMapping (method = RequestMethod.POST)
	public String displayCreatedRuleDetails (@ModelAttribute ("createdRulesInfo") CreatedRulesInfo newCreatedRulesInfo, Model model) {
		System.out.println("... createdRulesInfo: " + newCreatedRulesInfo);
		newCreatedRulesInfo = createdRuleService.saveCreatedRuleDetails(newCreatedRulesInfo);
		//TODO: return defined rules - detailed
		model.addAttribute ("definedSampleRule", getDefinedRulesFrCreatedRule(newCreatedRulesInfo));	
		
		model.addAttribute("populateRulesUI", getRulesDataForUI ());
		model.addAttribute ("createdRulesInfo", new CreatedRulesInfo());
		
		return "defSampleRules";
	}
	
	@RequestMapping (value="/allRules", method = RequestMethod.GET)
	public String displayAllCreatedRules (@ModelAttribute ("createdRulesInfo") CreatedRulesInfo newCreatedRulesInfo, Model model) {
		System.out.println("... createdRulesInfo: " + newCreatedRulesInfo);
		//TODO: return defined rules - detailed
		model.addAttribute ("definedcreatedRuleList", getAllCreatedRules (createdRuleService.getAllCreatedRules()));	
		return "displayCreatedRules";
	}
	
	private List<CreatedRulesDisplay> getAllCreatedRules (List<CreatedRulesInfo> crInfoList) {
		List<CreatedRulesDisplay> crDispList = new ArrayList<CreatedRulesDisplay> (crInfoList.size());
		if  (crInfoList != null && crInfoList.size() > 0) {
			Iterator<CreatedRulesInfo> crInfoIter = crInfoList.iterator();
			while (crInfoIter.hasNext()) {
				crDispList.add(getDefinedRulesFrCreatedRule(crInfoIter.next()));
			}
		}//if
		
		return crDispList;
	}
	
	private CreatedRulesDisplay getDefinedRulesFrCreatedRule (CreatedRulesInfo crInfo) {
		CreatedRulesDisplay crRulesInfo = new CreatedRulesDisplay ();
		crRulesInfo.setId(crInfo.getId());
		crRulesInfo.setRuleTitle(crInfo.getRuleTitle());	
		crRulesInfo.setCategory (crInfo.getCategory());
		crRulesInfo.setStatus (crInfo.getStatus());
		crRulesInfo.setCriticality(crInfo.getCriticality());
		crRulesInfo.setDescription(crInfo.getDescription());
		RuleTypeInfo ruleTypeInfo = ruleTypeInfoServ.getRuleTypeInfoById(crInfo.getRuleTypeInfoId());
		crRulesInfo.setRuleTypeInfo(ruleTypeInfo.getRuleType());
		ConditionDetails condDet_1 = condDetService.getConditionDetailsById(crInfo.getConditionId_1());
		crRulesInfo.setCondition_1(condDet_1.getDisplayName());
		ConditionDetails condDet_2 = condDetService.getConditionDetailsById(crInfo.getConditionId_2());
		crRulesInfo.setCondition_2(condDet_2.getDisplayName());
		ConditionDetails condDet_3 = condDetService.getConditionDetailsById(crInfo.getConditionId_3());
		crRulesInfo.setCondition_3(condDet_3.getDisplayName());
		ActionDetails actDet_1 = actionDetService.getActionDetailsById(crInfo.getActionId_1());
		if (actDet_1 != null) {
			crRulesInfo.setAction_1(actDet_1.getDisplayName());
		}
		ActionDetails actDet_2 = actionDetService.getActionDetailsById(crInfo.getActionId_2());
		if (actDet_2 != null) {
			crRulesInfo.setAction_2(actDet_2.getDisplayName());
		}
		CommunicationTypeInfo commTypeInfo = commTypeInfoService.getCommTypeInfoById(crInfo.getCommTypeId());
		if (commTypeInfo != null) {
			crRulesInfo.setCommType(commTypeInfo.getCommunicationType());
		}
		RecipientDetails recptDet_1 = recptDetService.getRecipientDetailsById(crInfo.getRecipientId_1());
		if (recptDet_1 != null) {
			crRulesInfo.setRecipient_1(recptDet_1.getRecipientType());
			if ("Role".equalsIgnoreCase(recptDet_1.getRecipientType())) {
				crRulesInfo.setRecipient_1 (recptDet_1.getRecipientValue());
			}
		}
		RecipientDetails recptDet_2 = recptDetService.getRecipientDetailsById(crInfo.getRecipientId_2());
		if (recptDet_2 != null) {
			crRulesInfo.setRecipient_2(recptDet_2.getRecipientType());
			if ("Role".equalsIgnoreCase(recptDet_2.getRecipientType())) {
				crRulesInfo.setRecipient_2 (recptDet_2.getRecipientValue());
			}
		}
		crRulesInfo.setRuleAccessLevel (crInfo.getRuleAccessLevel());
		crRulesInfo.setEntityID (crInfo.getEntityID());
		
		return crRulesInfo;
	}
	
	
	private PopulateRulesDataUI getRulesDataForUI () {
		PopulateRulesDataUI populateRulesUI = new PopulateRulesDataUI();
		
		/*List<String> categoryList;
		List<String> statusList;
		List<String> criticalityList;
		List<RuleTypeInfo> ruleTypeList;
		//user type ruleDetails/GroupType rule details/application type
		List<RuleDetails> ruleDetailsList;*/
		
		//set the rule Acess list
		List<RuleAccessLevel> ruleAccessLvlList = new ArrayList<RuleAccessLevel> (3);
		populateRulesUI.setRuleAcessLvlList(ruleAccessLvlList);
		ruleAccessLvlList.add(RuleAccessLevel.GLOBAL);
		ruleAccessLvlList.add(RuleAccessLevel.APPLICATION);
		ruleAccessLvlList.add(RuleAccessLevel.GROUP);
		
		//set the categoryList	
		List<String> categoryList = new ArrayList<String>(2);
		populateRulesUI.setCategoryList(categoryList);
		categoryList.add("Event");
		categoryList.add("Scheduled");
		
		List<String> statusList = new ArrayList<String> (3);
		populateRulesUI.setStatusList(statusList);
		statusList.add("Active");
		statusList.add("InActive");
		statusList.add("Delete");
		
		List<String> criticalityList = new ArrayList<String> ();
		populateRulesUI.setCriticalityList(criticalityList);
		criticalityList.add("Level1 (Low)");
		criticalityList.add("Level2 (Medium)");
		criticalityList.add("Level3 (High)");
		
		List<RuleDetails> ruleDetailsList = ruleDetailsService.getAllRuleDetails();
		List<RuleDetailsDisplay> ruleDetailsDispList = new ArrayList<RuleDetailsDisplay> ();
		populateRulesUI.setRuleDetailsDispList(ruleDetailsDispList);
		if (ruleDetailsList != null && ruleDetailsList.size() > 0) {
			
			//retrieve ruleTypeInfo from ruleDetails
			List<Long> ruleTypeIdList = new ArrayList<Long> (ruleDetailsList.size());
			Iterator<RuleDetails> ruleDetsIter = ruleDetailsList.iterator();
			
			while (ruleDetsIter.hasNext()) {
				RuleDetails ruleDetails = ruleDetsIter.next();
				RuleDetailsDisplay ruleDetsDisplay = new RuleDetailsDisplay();
				ruleTypeIdList.add(ruleDetails.getRuleTypeId());
				ruleDetsDisplay.setRuleTypeId(ruleDetails.getRuleTypeId());
				ruleDetsDisplay.setConditionDetList1(condDetService.getAllConditionsByIdSet(ruleDetails.getConditionDet1IdSet()));
				ruleDetsDisplay.setConditionDetList2(condDetService.getAllConditionsByIdSet(ruleDetails.getConditionDet2IdSet()));
				ruleDetsDisplay.setConditionDetList3(condDetService.getAllConditionsByIdSet(ruleDetails.getConditionDet3IdSet()));
				ruleDetsDisplay.setActionDetList1(actionDetService.getAllActionsByIdSet(ruleDetails.getActionDet1IdSet()));
				ruleDetsDisplay.setActionDetList2(actionDetService.getAllActionsByIdSet(ruleDetails.getActionDet2IdSet()));
				ruleDetsDisplay.setCommTypeList(commTypeInfoService.getAllCommunicationTypesById(ruleDetails.getCommTypeIdSet()));
				ruleDetsDisplay.setRecipientDetList1(recptDetService.getAllRecipientDetailsBySet(ruleDetails.getRecipientDet1IdSet()));
				ruleDetsDisplay.setRecipientDetList2 (recptDetService.getAllRecipientDetailsBySet(ruleDetails.getRecipientDet2IdSet()));
				ruleDetailsDispList.add(ruleDetsDisplay);
			}//while
			
			
			List<RuleTypeInfo> ruleTypeList = ruleTypeService.getRuleTypesByIdList(ruleTypeIdList);
			if (ruleTypeList != null && ruleTypeList.size() > 0	) {
				populateRulesUI.setRuleTypeList(ruleTypeList);
			}//if
		}
		
		return populateRulesUI;
	}

}
