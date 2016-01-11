package com.rules.mvc.dao.util;

public interface SequenceCounter {
	
	//Sequence number constants for RuleType
	public static final long RULE_TYPE_COUNTER = 0;
	public static final String RULE_TYPE_SEQUENCE_KEY = "ruleTypeSequence";
	
	
	//Sequence number constants for Condtion details
	public static final long CONDITION_DETAILS_COUNTER = 0;
	public static final String CONDITION_DETAILS_SEQ_KEY = "conditionDetails";
	
	
	//Sequence number constants for Action Details
	public static final long ACTION_DETAILS_COUNTER = 0;
	public static final String ACTION_DETAILS_SEQ_KEY = "actionDetails";
	
	//Sequence number constants for communication Details
	public static final long COMMUNICATION_DETAILS_COUNTER = 0;
	public static final String COMMUNICATION_DETAILS_KEY = "communicationDetails";
	
	
	//Sequence number constants for Recipient Details
	public static final long RECIPIENT_DETAILS_COUNTER = 0;
	public static final String RECIPIENT_DETAILS_KEY = "recipientDetails";
	
	//Sequence number for Rule Details
	public static final long RULE_DETAILS_COUNTER = 100;
	public static final String RULE_DETAILS_KEY = "ruleDetails";
	
	
	//Sequence number for DefinedRules 
	public static final long DEFINED_RULES_COUNTER = 0;
	public static final String DEFINED_RULES_KEY = "definedRuleInfo";
	
	//Sequence number for CreatedRulesInfo
	public static final long CREATED_RULES_COUNTER = 0;
	public static final String CREATED_RULES_KEY = "createdRulesInfo";
	
	
	long getNextSequence(String key, long seqNum);

}
