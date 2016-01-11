<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<table style="vertical-align: top" width="100%">
	<tr>
		<td><spring:url value="/rules" var="rulesUrl"
			htmlEscape="true" /> <a href="${rulesUrl}">Rules Data Creation</a></td>
	</tr>
	<tr>
		<td style="white-space: nowrap;"><spring:url value="/defSampleRules" var="defSampleRulesUrl"
			htmlEscape="true" /> <a href="${defSampleRulesUrl}">Define Sample Rules</a></td>
	</tr>
	<tr>
		<td style="white-space: nowrap;"><spring:url value="/defSampleRules/allRules" var="allRulesUrl"
			htmlEscape="true" /> <a href="${allRulesUrl}">Display All Sample Rules</a></td>
	</tr>
	<tr>
		<td style="white-space: nowrap;"><spring:url value="/getRulesjsp/conditions" var="ruleConditionUrl"
			htmlEscape="true" /> <a href="${ruleConditionUrl}">Display All Rule Conditions</a></td>
	</tr>
	<tr>
		<td style="white-space: nowrap;"><spring:url value="/getRulesjsp/actions" var="ruleActionUrl"
			htmlEscape="true" /> <a href="${ruleActionUrl}">Display All Rule Actions</a></td>
	</tr>
	<tr>
		<td style="white-space: nowrap;"><spring:url value="/getRulesjsp/recipients" var="ruleRecipientUrl"
			htmlEscape="true" /> <a href="${ruleRecipientUrl}">Display All Rule Recipients</a></td>
	</tr>
	<tr>
		<td style="white-space: nowrap;"><spring:url value="/getRulesjsp/communicationTypes" var="ruleCommTypeUrl"
			htmlEscape="true" /> <a href="${ruleCommTypeUrl}">Display All Communication Types</a></td>
	</tr>
	<tr>
		<td style="white-space: nowrap;"><spring:url value="/getRulesjsp/ruleTypes" var="ruleTypeUrl"
			htmlEscape="true" /> <a href="${ruleTypeUrl}">Display All Rule Types</a></td>
	</tr>
	<tr>
		<td style="white-space: nowrap;"><spring:url value="/getRulesjsp/definedRules" var="definedRulesUrl"
			htmlEscape="true" /> <a href="${definedRulesUrl}">Display All Defined Rules</a></td>
	</tr>
</table>

