<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
	function fnDisplayFieldValues (selectedObj, objId, newSelectId) {
		var selectedValue = selectedObj.value;
		var tdObj = document.getElementById (objId);
		
		var optionValue = null;
		var strSel = null;
		
		<c:forEach items="${rulesInfo.fieldTypeList}" var="fieldType">
		if (selectedValue == "<c:out value='${fieldType.key}'/>") {
			<c:if test="${not empty fieldType.value}">
			strSel = "Field Value: <select id=\"" + newSelectId + "\" name=\"" + newSelectId + "\">";
			<c:forEach items ="${fieldType.value}" var="fieldValue">
				optionValue = "<c:out value='${fieldValue}'/>";				
				strSel += "<option value='" + optionValue + "'>" + optionValue + "</option>";
			</c:forEach>	
			strSel += "</select>";
			tdObj.innerHTML = strSel;
			</c:if>
		}		
		</c:forEach>
		if (strSel == null || strSel.trim () == "") {
			tdObj.innerHTML = "";
			return;
		}
		
	}
	
	function fnDisplayRecptValues (selectedObj, objId, newSelectId) {
		var selectedValue = selectedObj.value;
		var tdObj = document.getElementById (objId);
		var optionValue = null;
		var strSel = "";
		<c:forEach items="${rulesInfo.recipientTypeList}" var="recptType">
		if (selectedValue == "Role" && selectedValue == "<c:out value='${recptType.recipientType}'/>") {
			strSel = "<select id=\"" + newSelectId + "\" name=\"" + newSelectId + "\">";
			<c:forEach items ="${recptType.roleList}" var="fieldValue">
				optionValue = "<c:out value='${fieldValue}'/>";
				strSel += "<option value='" + optionValue + "'>" + optionValue + "</option>";				
			</c:forEach>
			strSel += "</select>";
			tdObj.innerHTML = strSel;				 
			} 
		</c:forEach>
		
		if (strSel == null || strSel.trim () == "") {
			tdObj.innerHTML = "";
			return;
		}
		
	}
	
	function fnSubmit () {
		if (fnValidate ()) {
			document.forms[0].submit ();
		}
	}
	
	function fnValidate () {
		var condvalsEntered = true;
		var actionValsEntered = true;
		
		//conditionValue1.displayName
		if (!fnValidateConditionAction ("conditionValue1.displayName", "conditionValue1.fieldName", "conditionValue1.fieldValue")) {
			alert ("There should be atleast one condition to continue.");
			return false;
		}
		
		if (!fnValidateFieldType ("conditionValue1.fieldName")) {
			alert ("Please select the Field Type");
			return false;
		}
		
		
		
		//conditionValue2.displayName
		condvalsEntered = fnValidateConditionAction ("conditionValue2.displayName", "conditionValue2.fieldName", "conditionValue2.fieldValue");
		
		if (condvalsEntered && !fnValidateFieldType ("conditionValue2.fieldName")) {
			alert ("Please select the Field Type");
			return false;
		}
		
		//conditionValue3.displayName
		condvalsEntered = fnValidateConditionAction ("conditionValue3.displayName", "conditionValue3.fieldName", "conditionValue3.fieldValue");
		if (condvalsEntered && !fnValidateFieldType ("conditionValue3.fieldName")) {
			alert ("Please select the Field Type");
			return false;
		}
		
		//actionValue1.displayName
		actionValsEntered = fnValidateConditionAction ("actionValue1.displayName", "actionValue1.fieldName", "actionValue1.fieldValue")
		
		if (actionValsEntered && !fnValidateFieldType ("actionValue1.fieldName")) {
			alert ("Please select the Field Type");
			return false;
		}
		
		//actionValue2.displayName
		actionValsEntered = fnValidateConditionAction ("actionValue2.displayName", "actionValue2.fieldName", "actionValue2.fieldValue");
		if (actionValsEntered && !fnValidateFieldType ("actionValue2.fieldName")) {
			alert ("Please select the Field Type");
			return false;
		}
		
		//check communication type
		var commTypeSel = document.getElementById ("communicationType");
		if (commTypeSel.value == "") {
			alert ("Please enter communication type to continue");
			commTypeSel.focus ();
			return false;
		}
		
		//check the recipient1 selected
		var recpt1Sel = document.getElementById("recipientType1");
		if (recpt1Sel.value == "") {
			alert ("Please select the Recipient1");
			recpt1Sel.focus ();
			return false;
		}
		
		return true;
	} 
	
	function fnValidateConditionAction (displayName, fieldName, fieldValue) {
		var displayNameObj = document.getElementById (displayName);
		var fieldTypeObj = document.getElementById (fieldName);
		var fieldValueObj = document.getElementById (fieldValue);
		if (displayNameObj.value.trim ().length == 0) {
			fieldTypeObj.selectedIndex = 0;
			if (fieldValueObj != null) {
				fnClearSelect (fieldValueObj);
			}
			displayNameObj.focus ();
			return false;
		} 
		return true;
	}
	
	function fnValidateFieldType ( fieldName) {
		var fieldTypeObj = document.getElementById (fieldName);
		 if (fieldTypeObj.selectedIndex == 0) {
				//check for the field object
				fieldTypeObj.focus ();
				return false;
			} 
		 return true;
	}
	
	function fnClearSelect (selObj) {
		return selObj.parentNode.innerHTML = "";
	}
	
</script>
</head>
<body>
	<form:form method="POST" action="rules" modelAttribute="selectedRuleInfo">
	<c:if test="${not empty message}">
	<div style="margin:15px">${message}</div>
	</c:if>
	<div style="margin-left:20px;border:0;width:60%">
	<table style="margin-left:25px" cellspacing="2" cellpadding="0">
		<tr height="40px">			
			<td colspan="3" align="left">If <span style="padding:10px"><form:select path="ruleType" items="${rulesInfo.ruleTypeLst}"/></span></td>			
		</tr>
		<tr height="40px">
			<td>Condition Value1 <form:input path="conditionValue1.displayName" /></td>
			<td> Field Type: 
				<form:select path="conditionValue1.fieldName" onchange="fnDisplayFieldValues (this,'condVal1Field', 'conditionValue1.fieldValue');">
					<option value="">--- select ---</option>
					<c:forEach items="${rulesInfo.fieldTypeList}" var="fieldType" >
						<option value="${fieldType.key}"> ${fieldType.key}</option>  
					</c:forEach>
				</form:select>	
			</td>
			<td id="condVal1Field" colspan="3">
				
			</td>
		</tr>
		<tr height="40px">
			<td>Condition Value2 <form:input path="conditionValue2.displayName" /></td>
			<td>Field Type
				<form:select path="conditionValue2.fieldName" onchange="fnDisplayFieldValues (this,'condVal2Field','conditionValue2.fieldValue');">
					<option value="">--- select ---</option>
					<c:forEach items="${rulesInfo.fieldTypeList}" var="fieldType" >
						<option value="${fieldType.key}"> ${fieldType.key}</option>  
					</c:forEach>
				</form:select>	
			</td>
			<td id="condVal2Field" colspan="3">
				
			</td>
		</tr>
		<tr height="40px">
			<td>Condition Value3 <form:input path="conditionValue3.displayName" /></td>
			<td>Field Type
				<form:select path="conditionValue3.fieldName" onchange="fnDisplayFieldValues (this,'condVal3Field', 'conditionValue3.fieldValue');">
					<option value="">--- select ---</option>
					<c:forEach items="${rulesInfo.fieldTypeList}" var="fieldType" >
						<option value="${fieldType.key}"> ${fieldType.key}</option>  
					</c:forEach>
				</form:select>	
			</td>
			<td id="condVal3Field">
				
			</td>
		</tr>
		<tr height="40px">
			<td colspan="3" align="center"> Then </td>
		</tr>
		<tr height="40px">
			<td>Action Value1 <form:input path="actionValue1.displayName" /></td>
			<td>Field Type
				<form:select path="actionValue1.fieldName" onchange="fnDisplayFieldValues (this,'actVal1Field','actionValue1.fieldValue');">
					<option value="">--- select ---</option>
					<c:forEach items="${rulesInfo.fieldTypeList}" var="fieldType" >
						<option value="${fieldType.key}"> ${fieldType.key}</option>  
					</c:forEach>
				</form:select>	
			</td>
			<td id="actVal1Field">
				
			</td>
		</tr>
		<tr height="40px">
			<td>Action Value2 <form:input path="actionValue2.displayName" /></td>
			<td>Field Type
				<form:select path="actionValue2.fieldName" onchange="fnDisplayFieldValues (this,'actVal2Field', 'actionValue2.fieldValue');">
					<option value="">--- select ---</option>
					<c:forEach items="${rulesInfo.fieldTypeList}" var="fieldType" >
						<option value="${fieldType.key}"> ${fieldType.key}</option>  
					</c:forEach>
				</form:select>	
			</td>
			<td id="actVal2Field">
				
			</td>
		</tr>
		<tr height="40px">
			<td colspan="3" align="center">And Send </td>
		</tr>
		<tr height="40px">
			<td>Communication Type: </td>
			<td colspan="2">
				<form:select path="communicationType">
					<option value="">--- select ---</option>
					<form:options items="${rulesInfo.commTypeList}"/>
				</form:select>	
			</td>
			
		</tr>
		<tr height="40px">
			<td colspan="3" align="center"> To </td>
		</tr>
		<tr height="40px">
			<td>Recipient1:  </td>
			<td>
				<form:select path="recipientType1" onchange="fnDisplayRecptValues (this,'recipt1Value','roleType1');">
					<option value="">---Select---</option>
					<form:options items="${rulesInfo.recipientTypeList}" itemValue="recipientType" itemLabel="recipientType"/>
				</form:select>	
			</td>
			<td id="recipt1Value">
			</td>
		</tr>
		<tr height="40px">
			<td  colspan="3" align="center"> And </td>
		</tr>	
		<tr height="40px">
			<td>Recipient2:  </td>
			<td>
				<form:select path="recipientType2" onchange="fnDisplayRecptValues (this,'recipt2Value','roleType2');">
					<option value="">---Select---</option>
					<form:options items="${rulesInfo.recipientTypeList}" itemValue="recipientType" itemLabel="recipientType"/>
				</form:select>	
			</td>
			<td id="recipt2Value">
				
			</td>
		</tr>
		<tr>	
		
			<td colspan="3"><input type="button" value="Save" onclick="fnSubmit ();"/></td>
		</tr>
	</table>
	</div>
			
	</form:form>
</body>
</html>