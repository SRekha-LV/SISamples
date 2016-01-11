package com.rules.mvc.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.rules.mvc.model.RecipientType;
import com.rules.mvc.model.SelectedRulesInfo;

@Component
public class StaticDataHelper {
	
	public String getCreatedRuleData (SelectedRulesInfo selRulesInfo) {
		StringBuilder strB = new StringBuilder ();
		strB.append("If ").append(selRulesInfo.getRuleType());
		strB.append(" ").append(selRulesInfo.getConditionValue1().getDisplayName());
		strB.append(" ").append(selRulesInfo.getConditionValue2().getDisplayName ());
		strB.append(" ").append(selRulesInfo.getConditionValue3().getDisplayName()).append("\n");
		strB.append(" Then ");
		strB.append(selRulesInfo.getActionValue1().getDisplayName());
		strB.append(" ").append(selRulesInfo.getActionValue2().getDisplayName());
		strB.append(" And Send ");
		strB.append (selRulesInfo.getCommunicationType());
		strB.append(" To ");
		if (selRulesInfo.getRoleType1() != null) {
			strB.append(selRulesInfo.getRoleType1());
		} else {
			strB.append(selRulesInfo.getRecipientType1());
		}
		strB.append(" And ");
		if (selRulesInfo.getRoleType2() != null) {
			strB.append(selRulesInfo.getRoleType2());
		} else {
			strB.append(selRulesInfo.getRecipientType2());
		}
		
		return strB.toString();
	}
	
	
	public Map<String, String> getRuleTypeList () {
		Map<String, String> ruleTypeList = new HashMap<String, String> ();
		ruleTypeList.put ("User", "User");
		ruleTypeList.put("Group", "Group");
		ruleTypeList.put ("Application", "Application");
		return ruleTypeList;
	}
	
	public Map<String, List<String>> getFieldTypeMap () {
		Map<String, List<String>> fieldTypeMap = new HashMap<String, List<String>> ();
		
		//Event
		List<String> eventValueList = new ArrayList <String> (2);
		eventValueList.add("Failure");
		eventValueList.add ("Success");
		fieldTypeMap.put("Event", eventValueList);
		
		//Status
		List<String> statusValueList = new ArrayList <String> (3);
		statusValueList.add("Active");
		statusValueList.add ("InActive");
		statusValueList.add ("Delete");
		fieldTypeMap.put("Status", statusValueList);
		
		//Criticality
		List<String> criticalValueList = new ArrayList <String> (1);
		criticalValueList.add("Criticality");
		fieldTypeMap.put("Criticality", criticalValueList);
		
		//Expression
		List<String> expValueList = new ArrayList <String> (1);
		expValueList.add("EqualTo");
		fieldTypeMap.put("Expression", expValueList);
		
		//Values
		List<String> valueList = new ArrayList <String> (1);
		valueList.add("1");
		valueList.add("2");
		valueList.add("3");
		valueList.add("4");
		valueList.add("5");
		valueList.add("6");
		valueList.add("15");
		valueList.add("30");
		valueList.add("45");
		valueList.add("60");
		valueList.add("90");
		valueList.add("Level1 (Low)");
		valueList.add("Level2 (Medium)");
		valueList.add("Level3 (High)");
		
		fieldTypeMap.put("Value", valueList);
		
		//Access To Types - for Action like  - User Access
		//for user - This can be extended as - when user is selected, a dropdown with the 
		//values  - LoggedInUser, Roles could appear
		List<String> AccessTypeList = new ArrayList<String> (3);
		AccessTypeList.add("User");
		AccessTypeList.add ("Group");
		AccessTypeList.add ("Application");
		
		fieldTypeMap.put("Access", AccessTypeList);
		
		//Define workflow for Periodic Access review
		fieldTypeMap.put("Workflow", null);
		
		return fieldTypeMap;
	}
	
	public List<String> getCommunicationTypeList () {
		//CommunicationType
		List<String> commTypeList = new ArrayList<String> (3);
		commTypeList.add("Mail");
		commTypeList.add ("Text Message");
		commTypeList.add ("Notification Message");
		
		return commTypeList;
	}
	
	public List<RecipientType> getRecipientDetails () {
		//Recipients
		List<RecipientType> recipientTypeDet = new ArrayList<RecipientType> (2);
		
		RecipientType recpType = new RecipientType();
		recpType.setId("1");
		recpType.setRecipientType("LoggedInUser");
		recipientTypeDet.add(recpType);
		
		recpType = new RecipientType();
		recpType.setId("2");
		recpType.setRecipientType("Supervisor");
		recipientTypeDet.add(recpType);
		
		recpType = new RecipientType();
		recpType.setId("3");
		recpType.setRecipientType("Role");
		List<String> roleTypeList = new ArrayList<String> (4);
		roleTypeList.add ("Account User");
		roleTypeList.add ("Account Admin");
		roleTypeList.add ("Super Admin");
		roleTypeList.add ("Application Admin");
		roleTypeList.add ("Compliance User");
		
		recpType.setRoleList(roleTypeList);
		recipientTypeDet.add(recpType);
		
		return recipientTypeDet;
	}

}
