package com.rules.mvc.services;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rules.mvc.dao.util.SequenceCounter;
import com.rules.mvc.model.DBAttributes;
import com.rules.mvc.model.SelectedRulesInfo;
import com.rules.mvc.model.mongo.ActionDetails;
import com.rules.mvc.model.mongo.CommunicationTypeInfo;
import com.rules.mvc.model.mongo.ConditionDetails;
import com.rules.mvc.model.mongo.DefinedRulesInfo;
import com.rules.mvc.model.mongo.RecipientDetails;
import com.rules.mvc.model.mongo.RuleDetails;
import com.rules.mvc.model.mongo.RuleTypeInfo;
import com.rules.mvc.repositories.ActionDetailsRepository;
import com.rules.mvc.repositories.CommTypeInfoRepository;
import com.rules.mvc.repositories.ConditionDetailsRepository;
import com.rules.mvc.repositories.DefinedRulesRepository;
import com.rules.mvc.repositories.MailFormatRepository;
import com.rules.mvc.repositories.RecipientDetailsRepository;
import com.rules.mvc.repositories.RuleDetailsRepository;
import com.rules.mvc.repositories.RuleTypeInfoRepository;

@Service
public class RuleTypeServiceImpl implements RuleTypeService{

	@Autowired
	RuleTypeInfoRepository ruleTypeInfoRepo;
	
	@Autowired
	RuleDetailsRepository ruleDetailsRepo;
	
	@Autowired
	ActionDetailsRepository actiondetRepo;
	
	@Autowired
	CommTypeInfoRepository commTypeRepo;
	
	@Autowired
	ConditionDetailsRepository condDetailsRepo;
	
	@Autowired
	MailFormatRepository mailFormatRepo;
	
	@Autowired
	RecipientDetailsRepository recptDetailsRepo;
	
	@Autowired
	SequenceCounter seqCounter;
	
	@Autowired
	DefinedRulesRepository defRulesInfoRepo;
	
	@Override
	public void getAllRuleTypes () {
		List<RuleTypeInfo> ruleTypeInfoList =  ruleTypeInfoRepo.findAll();
		System.out.println(".....ruleTypeInfoList: " + ruleTypeInfoList);
	}

	@Override
	public void saveRuleDetails(SelectedRulesInfo selRulesInfo) {
		DefinedRulesInfo definedRulesInfo = new DefinedRulesInfo ();
		RuleDetails ruleDetails = new RuleDetails ();
		long ruleTypeId = updateRuleTypeInfo (selRulesInfo);
		ruleDetails.setRuleTypeId(ruleTypeId);
		definedRulesInfo.setRuleTypeInfoId(ruleTypeId);
		
		updateConditionDetails (selRulesInfo, ruleDetails, definedRulesInfo);
		
		//set Action Details
		updateActionDetails (selRulesInfo, ruleDetails, definedRulesInfo); 
		
		//Set communication Details
		updateCommunicationDetails (selRulesInfo, ruleDetails, definedRulesInfo);
		//TODO: set mail format details
		updateMailFormatDetails (selRulesInfo);
		//set RecipientDetails
		updateRecipientDetails (selRulesInfo, ruleDetails, definedRulesInfo);
				
		updateRuleDetails (ruleDetails);
		updateDefinedRulesInfo (definedRulesInfo);
	}
	
	private long updateRuleTypeInfo (SelectedRulesInfo selRulesInfo) {
		String ruleTypeSelected = selRulesInfo.getRuleType();
		//update rule type info if not already exists
		RuleTypeInfo ruleTypeInfo = ruleTypeInfoRepo.findByRuleTypeIgnoreCase(ruleTypeSelected);
		if (ruleTypeInfo == null) {
			ruleTypeInfo = new RuleTypeInfo ();
			ruleTypeInfo.setId(seqCounter.getNextSequence(SequenceCounter.RULE_TYPE_SEQUENCE_KEY, SequenceCounter.RULE_TYPE_COUNTER));
			ruleTypeInfo.setRuleType(ruleTypeSelected);
			ruleTypeInfoRepo.save(ruleTypeInfo);
		}
		
		return ruleTypeInfo.getId();
	}
	
	private void updateConditionDetails (SelectedRulesInfo selRulesInfo, RuleDetails ruleDetails,
			DefinedRulesInfo definedRulesInfo) {
		
		
		//update condition value1 if not exists
		DBAttributes  selCondtValue1 = selRulesInfo.getConditionValue1();
		String displayName = selCondtValue1.getDisplayName();
		String fieldName = selCondtValue1.getFieldName();
		String fieldValue = selCondtValue1.getFieldValue();
		if (displayName != null && displayName.trim().length() > 0) {
			ConditionDetails conditionDetails1 = condDetailsRepo.findByDisplayNameAndFieldTypeAndFieldValue(displayName, fieldName, fieldValue);
			if (conditionDetails1 == null) {
				conditionDetails1 = new ConditionDetails();
				conditionDetails1.setId(seqCounter.getNextSequence(SequenceCounter.CONDITION_DETAILS_SEQ_KEY, SequenceCounter.CONDITION_DETAILS_COUNTER));
				conditionDetails1.setDisplayName(selCondtValue1.getDisplayName());
				conditionDetails1.setFieldType(selCondtValue1.getFieldName());
				conditionDetails1.setFieldValue(selCondtValue1.getFieldValue());
				
				condDetailsRepo.save(conditionDetails1);
			}
			Set<Long> conditionDet1Set = new HashSet<Long> (1);
			conditionDet1Set.add(conditionDetails1.getId());
			ruleDetails.setConditionDet1IdSet(conditionDet1Set);
			definedRulesInfo.setConditionId1(conditionDetails1.getId());
		}
		
		//update condition value2 if not exists
		DBAttributes  selCondtValue2 = selRulesInfo.getConditionValue2();
		displayName = selCondtValue2.getDisplayName();
		fieldName = selCondtValue2.getFieldName();
		fieldValue = selCondtValue2.getFieldValue();
		if (displayName != null && displayName.trim().length() > 0) {
			ConditionDetails conditionDetails2 = condDetailsRepo.findByDisplayNameAndFieldTypeAndFieldValue(displayName, fieldName, fieldValue);
			if (conditionDetails2 == null) {
				conditionDetails2 = new ConditionDetails();
				conditionDetails2.setId(seqCounter.getNextSequence(SequenceCounter.CONDITION_DETAILS_SEQ_KEY, SequenceCounter.CONDITION_DETAILS_COUNTER));
				conditionDetails2.setDisplayName(selCondtValue2.getDisplayName());
				conditionDetails2.setFieldType(selCondtValue2.getFieldName());
				conditionDetails2.setFieldValue(selCondtValue2.getFieldValue());
				
				condDetailsRepo.save(conditionDetails2);
			}
			Set<Long> conditionDet2Set = new HashSet<Long> (1);			
			conditionDet2Set.add( conditionDetails2.getId());
			ruleDetails.setConditionDet2IdSet(conditionDet2Set);
			definedRulesInfo.setConditionId2(conditionDetails2.getId());
		}
		
		//update condition value3 if not exists
		DBAttributes  selCondtValue3 = selRulesInfo.getConditionValue3();
		displayName = selCondtValue3.getDisplayName();
		fieldName = selCondtValue3.getFieldName();
		fieldValue = selCondtValue3.getFieldValue();
		if (displayName != null && displayName.trim().length() > 0) {
			ConditionDetails conditionDetails3 = condDetailsRepo.findByDisplayNameAndFieldTypeAndFieldValue(displayName, fieldName, fieldValue);
			if (conditionDetails3 == null) {
				conditionDetails3 = new ConditionDetails();
				conditionDetails3.setId(seqCounter.getNextSequence(SequenceCounter.CONDITION_DETAILS_SEQ_KEY, SequenceCounter.CONDITION_DETAILS_COUNTER));
				conditionDetails3.setDisplayName(selCondtValue3.getDisplayName());
				conditionDetails3.setFieldType(selCondtValue3.getFieldName());
				conditionDetails3.setFieldValue(selCondtValue3.getFieldValue());
				
				condDetailsRepo.save(conditionDetails3);
			}
			Set<Long> conditionDet3Set = new HashSet<Long> (1);
			conditionDet3Set.add( conditionDetails3.getId());
			ruleDetails.setConditionDet3IdSet(conditionDet3Set);
			definedRulesInfo.setConditionId3(conditionDetails3.getId());
		}
		
		
	}
	
	private void updateActionDetails (SelectedRulesInfo selRulesInfo,RuleDetails ruleDetails,
			DefinedRulesInfo definedRulesInfo) {

		//update action details 1 if not already exists
		DBAttributes selActionDetails1 = selRulesInfo.getActionValue1();
		String displayName = selActionDetails1.getDisplayName();
		String fieldName = selActionDetails1.getFieldName();
		String fieldValue = selActionDetails1.getFieldValue();
		if (displayName != null && displayName.trim().length() > 0) {
			ActionDetails actionDetails1 = actiondetRepo.findByDisplayNameAndFieldTypeAndFieldValue (displayName, fieldName, fieldValue);
			if (actionDetails1 == null) {
				actionDetails1 = new ActionDetails();
				actionDetails1.setId(seqCounter.getNextSequence(SequenceCounter.ACTION_DETAILS_SEQ_KEY, SequenceCounter.ACTION_DETAILS_COUNTER));
				actionDetails1.setDisplayName(selActionDetails1.getDisplayName());
				actionDetails1.setFieldType(selActionDetails1.getFieldName());
				actionDetails1.setFieldValue(selActionDetails1.getFieldValue());
				actiondetRepo.save(actionDetails1);
			}//if
			
			Set<Long> actionDetails1Set = new HashSet<Long> (1);			
			actionDetails1Set.add(actionDetails1.getId());
			ruleDetails.setActionDet1IdSet(actionDetails1Set);
			definedRulesInfo.setActionId1(actionDetails1.getId());
		}//if
		
		//update action details2 if not already exists
		DBAttributes selActionDetails2 = selRulesInfo.getActionValue2();
		if (displayName != null && displayName.trim().length() > 0) {
			displayName = selActionDetails2.getDisplayName();
			fieldName = selActionDetails2.getFieldName();
			fieldValue = selActionDetails2.getFieldValue();
			ActionDetails actionDetails2 = actiondetRepo.findByDisplayNameAndFieldTypeAndFieldValue (displayName, fieldName, fieldValue);
			if (actionDetails2 == null) {
				actionDetails2 = new ActionDetails();
				actionDetails2.setId(seqCounter.getNextSequence(SequenceCounter.ACTION_DETAILS_SEQ_KEY, SequenceCounter.ACTION_DETAILS_COUNTER));
				actionDetails2.setDisplayName(selActionDetails2.getDisplayName());
				actionDetails2.setFieldType(selActionDetails2.getFieldName());
				actionDetails2.setFieldValue(selActionDetails2.getFieldValue());
				actiondetRepo.save(actionDetails2);
			}//if
			
			Set<Long> actionDetails2Set = new HashSet<Long> (1);
			actionDetails2Set.add(actionDetails2.getId());
			ruleDetails.setActionDet2IdSet(actionDetails2Set);
			definedRulesInfo.setActionId2(actionDetails2.getId());
		}//if
	}
	
	private long updateCommunicationDetails (SelectedRulesInfo selRulesInfo, 
			RuleDetails ruleDetails, DefinedRulesInfo definedRulesInfo) {
		Set<Long> commTypeIdSet = new HashSet<Long>(1);
		
		//update communication details if not already exists
		String selCommType = selRulesInfo.getCommunicationType();
		CommunicationTypeInfo commInfoDet = commTypeRepo.findByCommunicationType(selCommType);
		if (commInfoDet == null) {
			commInfoDet = new CommunicationTypeInfo();
			commInfoDet.setId(seqCounter.getNextSequence(SequenceCounter.COMMUNICATION_DETAILS_KEY, SequenceCounter.COMMUNICATION_DETAILS_COUNTER));
			commInfoDet.setCommunicationType(selCommType);
			
			commTypeRepo.save(commInfoDet);
		}//if
		commTypeIdSet.add(commInfoDet.getId());
		ruleDetails.setCommTypeIdSet(commTypeIdSet);
		definedRulesInfo.setCommunicationTypeId(commInfoDet.getId());
		return commInfoDet.getId();
	}
	
	private void updateMailFormatDetails (SelectedRulesInfo selRulesInfo) {
		
	}
	
	private void updateRecipientDetails (SelectedRulesInfo selRulesInfo, RuleDetails ruleDetails,
			DefinedRulesInfo definedRulesInfo) {
		
		Set<Long> recptDetails1Set = new HashSet<Long> (1);
		Set<Long> recptDetails2Set = new HashSet<Long> (1);
		
		//update Recipient 1 Details if not already exists
		String selRecpt1 = selRulesInfo.getRecipientType1();
		String selRecptRole1 = selRulesInfo.getRoleType1();
		if (selRecpt1 != null && selRecpt1.trim().length() > 0) {
			if (selRecptRole1 == null || (selRecptRole1 != null &&  selRecptRole1.trim().length() == 0)) {
				selRecptRole1 = selRecpt1;
			}
			RecipientDetails recipientDet1 = recptDetailsRepo.findByRecipientTypeAndRecipientValue(selRecptRole1, selRecpt1);
			if (recipientDet1 == null) {
				recipientDet1 = new RecipientDetails ();
				recipientDet1.setId(seqCounter.getNextSequence(SequenceCounter.RECIPIENT_DETAILS_KEY, SequenceCounter.RECIPIENT_DETAILS_COUNTER));
				recipientDet1.setRecipientType(selRecpt1);
				recipientDet1.setRecipientValue(selRecptRole1);
				
				recptDetailsRepo.save(recipientDet1);
			}//if
			recptDetails1Set.add(recipientDet1.getId());
			ruleDetails.setRecipientDet1IdSet(recptDetails1Set);
			definedRulesInfo.setRecipientId1(recipientDet1.getId());
		}
		
		//update Recipient 2 Details if not already exists
		String selRecpt2 = selRulesInfo.getRecipientType2();
		String selRecptRole2 = selRulesInfo.getRoleType2();
		if (selRecpt2 != null && selRecpt2.trim ().length() > 0) {
			if (selRecptRole2 == null || (selRecptRole2 != null &&  selRecptRole2.trim().length() == 0)) {
				selRecptRole2 = selRecpt2;
			}
			RecipientDetails recipientDet2 = recptDetailsRepo.findByRecipientTypeAndRecipientValue(selRecptRole2, selRecpt2);
			if (recipientDet2 == null) {
				recipientDet2 = new RecipientDetails ();
				recipientDet2.setId(seqCounter.getNextSequence(SequenceCounter.RECIPIENT_DETAILS_KEY, SequenceCounter.RECIPIENT_DETAILS_COUNTER));
				recipientDet2.setRecipientType(selRecpt2);
				recipientDet2.setRecipientValue(selRecptRole2);
				
				recptDetailsRepo.save(recipientDet2);
			}//if
			recptDetails2Set.add(recipientDet2.getId());
			ruleDetails.setRecipientDet2IdSet(recptDetails2Set);
			definedRulesInfo.setRecipientId2(recipientDet2.getId());
		}//if
		
	}
	
	private void updateRuleDetails (RuleDetails ruleDetails) {
		
		//Save/Update rule Details for non-existing values
		
		//retrieve existing rule details based on the ruleTypeId
		RuleDetails ruleDetsExisting = ruleDetailsRepo.findByRuleTypeId(ruleDetails.getRuleTypeId());
		if (ruleDetsExisting == null) {
			ruleDetails.setId(seqCounter.getNextSequence(SequenceCounter.RULE_DETAILS_KEY, SequenceCounter.RULE_DETAILS_COUNTER));
			ruleDetailsRepo.save(ruleDetails);			
		} else {
			//check the conditionDetails1 List for updates
			Set<Long> existingcond1Set = ruleDetsExisting.getConditionDet1IdSet();
			boolean isCondDet1Changed = false;
			Set<Long> condDetId1Set  = ruleDetails.getConditionDet1IdSet();
			if (existingcond1Set != null && existingcond1Set.size() > 0) {
				if (condDetId1Set == null) {
					condDetId1Set = new HashSet<Long> ();
				}
				isCondDet1Changed = condDetId1Set.addAll(existingcond1Set);
			} else if (condDetId1Set != null) {
				isCondDet1Changed = true;
			}
				
			Set<Long> existingcond2Set = ruleDetsExisting.getConditionDet2IdSet();
			boolean isCondDet2Changed  = false;
			Set<Long> condDetId2Set  = ruleDetails.getConditionDet2IdSet();
			if (existingcond2Set != null && existingcond2Set.size() > 0) {
				if (condDetId2Set == null) {
					condDetId2Set = new HashSet<Long> ();
				}
				isCondDet2Changed = condDetId2Set.addAll(existingcond2Set);
			} else if (condDetId2Set == null) {
				isCondDet2Changed = true;
			}
			Set<Long> existingcond3Set = ruleDetsExisting.getConditionDet3IdSet();
			boolean isCondDet3Changed  = false;
			Set<Long> condDetId3Set  = ruleDetails.getConditionDet3IdSet();
			if (existingcond3Set != null && existingcond3Set.size() > 0) {
				if (condDetId3Set == null) {
					condDetId3Set = new HashSet<Long> ();
				}
				isCondDet3Changed = condDetId3Set.addAll(existingcond3Set);
			} else if (condDetId3Set == null) {
				isCondDet3Changed = true;
				
			}
			
			//check the Action details list for updates
			Set<Long> existingAction1List = ruleDetsExisting.getActionDet1IdSet();
			boolean isActionList1Changed = false;
			Set<Long> actionDetId1Set = ruleDetails.getActionDet1IdSet();			
			if (existingAction1List != null && existingAction1List.size() > 0) {	
				if (actionDetId1Set == null) {
					actionDetId1Set = new HashSet<Long> ();
				}
				isActionList1Changed = actionDetId1Set.addAll(existingAction1List);
			} else if (actionDetId1Set != null) {
					isActionList1Changed = true;
			}
			Set<Long> existingAction2List = ruleDetsExisting.getActionDet2IdSet();
			boolean isActionList2Changed = false;
			Set<Long> actionDetId2Set = ruleDetails.getActionDet2IdSet();
			if (existingAction2List != null && existingAction2List.size() > 0) {				
				if (actionDetId2Set == null) {
					actionDetId2Set = new HashSet<Long> ();
				}
				isActionList2Changed = actionDetId2Set.addAll(existingAction2List);
			} else if (actionDetId2Set != null) {
				isActionList2Changed = true;
			}
			
			//check the communication type for updates
			Set<Long> existingCommIdSet = ruleDetsExisting.getCommTypeIdSet();
			boolean isCommDetIdUpdated = ruleDetails.getCommTypeIdSet().addAll(existingCommIdSet);			
			
			//check the recipient list for updates
			Set<Long> existingRecpDet1 = ruleDetsExisting.getRecipientDet1IdSet();
			boolean isRecptDet1Updated = false;
			if (existingRecpDet1 != null && existingRecpDet1.size() > 0) {
				isRecptDet1Updated = ruleDetails.getRecipientDet1IdSet().addAll(existingRecpDet1);
			}
			Set<Long> existingRecpDet2 = ruleDetsExisting.getRecipientDet2IdSet();
			boolean isRecptDet2Updated = false;
			if (existingRecpDet2 != null && existingRecpDet2.size() > 0) {
				isRecptDet2Updated = ruleDetails.getRecipientDet2IdSet().addAll(existingRecpDet2);
			}
			
			if (isCondDet1Changed || isCondDet2Changed || isCondDet3Changed || 
					isActionList1Changed || isActionList2Changed ||
					isCommDetIdUpdated ||
					isRecptDet1Updated || isRecptDet2Updated) {
				ruleDetails.setId(ruleDetsExisting.getId());
				ruleDetailsRepo.save(ruleDetails);
			}
			
		}//if
		
		System.out.println("Details updated");
	}
	
	private void updateDefinedRulesInfo (DefinedRulesInfo definedRulesInfo) {
		List<DefinedRulesInfo> existingDefRuleList = defRulesInfoRepo.findByRuleTypeInfoIdAndConditionId1AndConditionId2AndConditionId3 (
				definedRulesInfo.getRuleTypeInfoId(), definedRulesInfo.getConditionId1(),
				definedRulesInfo.getConditionId2(),
				definedRulesInfo.getConditionId3());
		
		boolean isDefRuleNew = false;
		if (existingDefRuleList != null && existingDefRuleList.size() > 0) {
			Iterator<DefinedRulesInfo> defRuleIter = existingDefRuleList.iterator();
			while (defRuleIter.hasNext()) {
				DefinedRulesInfo existingDefRuleInfo = defRuleIter.next();
				if (existingDefRuleInfo.getActionId1() != definedRulesInfo.getActionId1()) {
					isDefRuleNew = true;
					break;
				}
				if (existingDefRuleInfo.getActionId2() == definedRulesInfo.getActionId2()) {
					isDefRuleNew = true;
					break;
				}
				if (existingDefRuleInfo.getCommunicationTypeId() == definedRulesInfo.getCommunicationTypeId()) {
					isDefRuleNew = true;
					break;
				}
				if (existingDefRuleInfo.getRecipientId1() == definedRulesInfo.getRecipientId1()) {
					isDefRuleNew = true;
					break;
				}
				
				if (existingDefRuleInfo.getRecipientId2() == definedRulesInfo.getRecipientId2()) {
					isDefRuleNew = true;
					break;
				}
				
			}//while
		} 
		if (existingDefRuleList == null|| (existingDefRuleList != null && existingDefRuleList.size() == 0) || isDefRuleNew) {
			definedRulesInfo.setId(seqCounter.getNextSequence(SequenceCounter.DEFINED_RULES_KEY, SequenceCounter.DEFINED_RULES_COUNTER));
			defRulesInfoRepo.save(definedRulesInfo);			
		}//if 
	}
}
