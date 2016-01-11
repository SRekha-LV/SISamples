package com.rules.mvc.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rules.mvc.model.mongo.ActionDetails;
import com.rules.mvc.model.mongo.CommunicationTypeInfo;
import com.rules.mvc.model.mongo.ConditionDetails;
import com.rules.mvc.model.mongo.DefinedRulesInfo;
import com.rules.mvc.model.mongo.RecipientDetails;
import com.rules.mvc.model.mongo.RuleDetails;
import com.rules.mvc.model.mongo.RuleTypeInfo;
import com.rules.mvc.services.ActionDetailsService;
import com.rules.mvc.services.CommTypeInfoService;
import com.rules.mvc.services.ConditionDetailsService;
import com.rules.mvc.services.DefinedRulesService;
import com.rules.mvc.services.RecipientDetailsService;
import com.rules.mvc.services.RuleDetailsService;
import com.rules.mvc.services.RuleTypeInfoService;
import com.rules.mvc.services.RuleTypeService;

@Controller
@RequestMapping ("/getRulesjsp")
public class RulesMVCServiceController {
	
	@Autowired
	RuleTypeService ruleTypeService;
	
	@Autowired
	ConditionDetailsService condtDetService;
	
	@Autowired
	ActionDetailsService actionDetService;
	
	@Autowired
	RecipientDetailsService recipientDetService;
	
	@Autowired
	CommTypeInfoService commTypeService;
	
	@Autowired
	RuleTypeInfoService ruleTypeInfoService;
	
	@Autowired
	RuleDetailsService ruleDetailsService;
	
	@Autowired
	DefinedRulesService defRulesService;
	
	@RequestMapping (value="/conditions", method=RequestMethod.GET)
	public String getAllConditions (Model model) {
		model.addAttribute("conditionDetList", condtDetService.getAllConditions());
		return "conditionDetails";
	}
	
	@RequestMapping (value="/actions", method=RequestMethod.GET)
	public String getAllActions (Model model) {
		model.addAttribute("actionDetList",actionDetService.getAllActions());
		return "actionDetails";
	}
	
	@RequestMapping (value="/recipients", method=RequestMethod.GET)
	public String getAllRecipients (Model model) {
		model.addAttribute("recipientDetList", recipientDetService.getAllRecipientDetails());
		return "recipientDetails";
	}
	
	@RequestMapping (value="/communicationTypes", method=RequestMethod.GET)
	public String getAllcommunicationTypes (Model model) {
		model.addAttribute("commTypeList", commTypeService.getAllCommunicationTypes());
		return "communicationTypeList";
	}
	
	@RequestMapping (value="/ruleTypes", method=RequestMethod.GET)
	public String getAllRuleTypes (Model model) {
		model.addAttribute("ruleTypeInfoList", ruleTypeInfoService.getAllRuleTypes());
		return "ruleTypeInfoDetails";
	}
	
	/*@RequestMapping (value="/definedRules/{ruleType}", method=RequestMethod.GET)
	public String getAllDefinedRulesByType (@PathVariable ("ruleType") String ruleType, Model model) {
		Map<String, Object> definedRulesMap = new LinkedHashMap<String, Object>();
		RuleDetails ruleDetails = ruleDetailsService.getRuleDetailsByRuleType(ruleType);
		
		//get all the condition1 values
		Set<Long> conditionDet1Set = ruleDetails.getConditionDet1IdSet();
		List<ConditionDetails> conditionDet1List = condtDetService.getAllConditionsByIdSet(conditionDet1Set);
		definedRulesMap.put("Condition_Details_1", conditionDet1List);
		
		
		//get All condition 2 values
		Set<Long> conditionDet2Set = ruleDetails.getConditionDet2IdSet();
		List<ConditionDetails> conditionDet2List = condtDetService.getAllConditionsByIdSet(conditionDet2Set);
		definedRulesMap.put("Condition_Details_2", conditionDet2List);
		
		//get all condition3 values
		Set<Long> conditionDet3Set = ruleDetails.getConditionDet3IdSet();
		List<ConditionDetails> conditionDet3List = condtDetService.getAllConditionsByIdSet(conditionDet3Set);
		definedRulesMap.put("Condition_Details_3", conditionDet3List);
		
		//get all action1 values
		Set<Long> actionDetailsIdSet_1 = ruleDetails.getActionDet1IdSet();
		List<ActionDetails> actionDetList_1 = actionDetService.getAllActionsByIdSet(actionDetailsIdSet_1);
		definedRulesMap.put("Action_Details_1", actionDetList_1);
		
		//get all action2 values
		Set<Long> actionDetailsIdSet_2 = ruleDetails.getActionDet2IdSet();
		List<ActionDetails> actionDetList_2 = actionDetService.getAllActionsByIdSet(actionDetailsIdSet_2);
		definedRulesMap.put("Action_Details_2", actionDetList_2);
		
		//get all communication type values
		Set<Long> commTypeSet = ruleDetails.getCommTypeIdSet();
		List<CommunicationTypeInfo> commTypeDetList = commTypeService.getAllCommunicationTypesById(commTypeSet);
		definedRulesMap.put("Communication_Type_Details", commTypeDetList);
		
		//get all recipeint1 values
		Set<Long> recptSet_1  = ruleDetails.getRecipientDet1IdSet();
		List<RecipientDetails> recptDetailsList1 = recipientDetService.getAllRecipientDetailsBySet(recptSet_1);
		definedRulesMap.put("MailTo_Details_1 ", recptDetailsList1);
		
		//get all recipient2 values
		Set<Long> recptSet_2  = ruleDetails.getRecipientDet2IdSet();
		List<RecipientDetails> recptDetailsList2 = recipientDetService.getAllRecipientDetailsBySet(recptSet_2);
		definedRulesMap.put("MailTo_Details_2 ", recptDetailsList2);
		
		model.addAttribute("definedRulesMap",definedRulesMap);
		
		return "definedRuleDetByType";
	}*/
	
	@RequestMapping (value="/definedRules", method=RequestMethod.GET)
	public String getAllDefinedRules (Model model) {
		List<String> definedRulesList = new ArrayList<String>();
		//get all the defined rules
		List<DefinedRulesInfo> defRulesInfoList = defRulesService.getAllDefinedRules();
		if (defRulesInfoList != null && defRulesInfoList.size() > 0) {
			Iterator<DefinedRulesInfo> defRulesIter = defRulesInfoList.iterator();
			StringBuilder strBuilder = new StringBuilder ();
			int counter = 0;
			while (defRulesIter.hasNext()) {
				strBuilder.setLength(0);
				counter++;
				DefinedRulesInfo defRulesInfo = defRulesIter.next();
				strBuilder.append(counter).append(". ");
				strBuilder.append("If ").append(ruleTypeInfoService.getRuleTypeInfoById (defRulesInfo.getRuleTypeInfoId()).getRuleType());
				strBuilder.append (" ").append(condtDetService.getConditionDetailsById(defRulesInfo.getConditionId1()).getDisplayName());
				if (defRulesInfo.getConditionId2() > 0) {
					strBuilder.append(" ").append(condtDetService.getConditionDetailsById(defRulesInfo.getConditionId2()).getDisplayName());
				}
				if (defRulesInfo.getConditionId3() > 0) {
					strBuilder.append(" ").append(condtDetService.getConditionDetailsById(defRulesInfo.getConditionId3()).getDisplayName());
				}
				
				strBuilder.append (" Then ");
				
				if (defRulesInfo.getActionId1() > 0 || defRulesInfo.getActionId2() > 0) {
					
					if (defRulesInfo.getActionId1() > 0) {
						strBuilder.append( actionDetService.getActionDetailsById(defRulesInfo.getActionId1()).getDisplayName());
					}
					if (defRulesInfo.getActionId2() > 0) {
						strBuilder.append(" ").append( actionDetService.getActionDetailsById(defRulesInfo.getActionId2()).getDisplayName());
						
					}
					
					strBuilder.append (" AND ");
				}//if action
				
				strBuilder.append (" Send ").append(commTypeService.getCommTypeInfoById(defRulesInfo.getCommunicationTypeId()).getCommunicationType());
				strBuilder.append (" To ");
				if (defRulesInfo.getRecipientId1() > 0) {
					strBuilder.append(" ");
					strBuilder.append (recipientDetService.getRecipientDetailsById(defRulesInfo.getRecipientId1()).getRecipientValue());
				}
				
				if (defRulesInfo.getRecipientId2() > 0) {
					strBuilder.append(" AND ");
					strBuilder.append (recipientDetService.getRecipientDetailsById(defRulesInfo.getRecipientId2()).getRecipientValue());
				}
				
				definedRulesList.add(strBuilder.toString());
			}//while
		}//if
		model.addAttribute("definedRulesList", definedRulesList);
		return "definedRuleDetails";
	}
}
