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
	function fnDisplayRuleDetails (selObj) {
		//alert (selObj.value + "----" + selObj.options[selObj.value].text);
		var condObj_1 = document.getElementById ("conditionDet_1");
		var condObj_2 = document.getElementById ("conditionDet_2");
		var condObj_3 = document.getElementById ("conditionDet_3");
		var actionObj_1 = document.getElementById ("actionDet_1");
		var actionObj_2 = document.getElementById ("actionDet_2");
		var commTypeObj = document.getElementById ("commTypeDetId");
		var mailToObj_1 = document.getElementById ("mailTo_1");
		var mailToObj_2 = document.getElementById ("mailTo_2");
		
		var optionValue = null;
		var optionName = null;
		var strSel = "";
		var dataList = new Array ();
		<c:forEach items="${populateRulesUI.ruleDetailsDispList}" var="ruleDetails" >
		if (selObj.value == "<c:out value='${ruleDetails.ruleTypeId}'/>") {
			//display condition1 details
			<c:forEach items ="${ruleDetails.conditionDetList1}" var="condition1Det">
				dataList.push ({id:"<c:out value='${condition1Det.id}'/>", 
				displayName:"<c:out value='${condition1Det.displayName}'/>"});
			</c:forEach>
			displayDetails (condObj_1, dataList, "conditionId_1");
			
			//display condition2 details
			dataList.clear ();
			<c:forEach items ="${ruleDetails.conditionDetList2}" var="condition2Det">
				dataList.push ({id:"<c:out value='${condition2Det.id}'/>", 
				displayName:"<c:out value='${condition2Det.displayName}'/>"});
			</c:forEach>
			displayDetails (condObj_2, dataList, "conditionId_2");
			
			//display condition3 details
			dataList.clear ();
			<c:forEach items ="${ruleDetails.conditionDetList3}" var="condition3Det">
				dataList.push ({id:"<c:out value='${condition3Det.id}'/>", 
				displayName:"<c:out value='${condition3Det.displayName}'/>"});
			</c:forEach>
			displayDetails (condObj_3, dataList, "conditionId_3");
			
			//display action1 details
			dataList.clear ();
			<c:forEach items ="${ruleDetails.actionDetList1}" var="action1Det">
				dataList.push ({id:"<c:out value='${action1Det.id}'/>", 
				displayName:"<c:out value='${action1Det.displayName}'/>"});
			</c:forEach>
			displayDetails (actionObj_1, dataList, "actionId_1");
			
			//display action2 details
			dataList.clear ();
			<c:forEach items ="${ruleDetails.actionDetList2}" var="action2Det">
				dataList.push ({id:"<c:out value='${action2Det.id}'/>", 
				displayName:"<c:out value='${action2Det.displayName}'/>"});
			</c:forEach>
			displayDetails (actionObj_2, dataList, "actionId_2");
			
			//display communicationType details
			dataList.clear ();
			<c:forEach items ="${ruleDetails.commTypeList}" var="commType">
				dataList.push ({id:"<c:out value='${commType.id}'/>", 
				communicationType:"<c:out value='${commType.communicationType}'/>"});
			</c:forEach>
			displayCommDetails (commTypeObj, dataList, "commTypeId");
			
			
			//display recipient_1 details
			dataList.clear ();
			<c:forEach items ="${ruleDetails.recipientDetList1}" var="recipt1">
				dataList.push ({id:"<c:out value='${recipt1.id}'/>", 
				recipientValue:"<c:out value='${recipt1.recipientValue}'/>"});
			</c:forEach>
			displayRecptDetails (mailToObj_1, dataList, "recipientId_1");
			
			//display recipient_2 details
			dataList.clear ();
			<c:forEach items ="${ruleDetails.recipientDetList2}" var="recipt2">
				dataList.push ({id:"<c:out value='${recipt2.id}'/>", 
				recipientValue:"<c:out value='${recipt2.recipientValue}'/>"});
			</c:forEach>
			displayRecptDetails (mailToObj_2, dataList, "recipientId_2");
			
			return;
		} else if (selObj.value == "") {
			if (strSel == null || strSel.trim () == "") {
				var strSelDefault = "<select><option value=\"\">Select RuleType</option></select>";
				condObj_1.innerHTML = strSelDefault;
				condObj_2.innerHTML = strSelDefault;
				condObj_3.innerHTML = strSelDefault;
				actionObj_1.innerHTML = strSelDefault;
				actionObj_2.innerHTML = strSelDefault;
				commTypeObj.innerHTML = strSelDefault;
				mailToObj_1.innerHTML = strSelDefault;
				mailToObj_2.innerHTML = strSelDefault;
				return;
			}
		}
		</c:forEach>
		
	}
	
	Array.prototype.clear = function() {
	    this.splice(0, this.length);
	};
	
	function displayDetails (condObj, conditionList, javaObjId) {
		
		//display condition1 details
		if (conditionList != undefined && conditionList.length > 0) {
			strSel = "<select id=\"" + javaObjId + "\" name=\""+ javaObjId+"\">";
			for (var  i = 0; i < conditionList.length; i ++) {
				strSel += "<option value='" + conditionList[i].id + "'>" + conditionList[i].displayName + "</option>";
			}
			strSel += "</select>";
			condObj.innerHTML = strSel;
		} 	
	}
	
	function displayCommDetails (commObj, commTypeList, javaObjId) {
		//display communication details
		if (commTypeList != undefined && commTypeList.length > 0) {
			strSel = "<select id=\"" + javaObjId + "\" name=\""+ javaObjId+"\">";
			for (var  i = 0; i < commTypeList.length; i ++) {
				strSel += "<option value='" + commTypeList[i].id + "'>" + commTypeList[i].communicationType + "</option>";
			}
			strSel += "</select>";
			commObj.innerHTML = strSel;
		} 	
	}
	
	
	function displayRecptDetails (recptObj, recptTypeList, javaObjId) {
		//display Recipient details
		if (recptTypeList != undefined && recptTypeList.length > 0) {
			strSel = "<select id=\"" + javaObjId + "\" name=\""+ javaObjId+"\">";
			for (var  i = 0; i < recptTypeList.length; i ++) {
				strSel += "<option value='" + recptTypeList[i].id + "'>" + recptTypeList[i].recipientValue + "</option>";
			}
			strSel += "</select>";
			recptObj.innerHTML = strSel;
		} 	
	}
	
	function fnSubmit () {
		document.forms [0].submit ();
	}
		
</script>
</head>
<body>
	<form:form method="POST" action="defSampleRules" modelAttribute="createdRulesInfo">
		
	<c:if test="${not empty populateRulesUI}" >
	<div style="margin-left:20px;">
	<table style="margin-left:25px" cellspacing="2" cellpadding="0">
		<tr height="40px">			
			<td colspan="4" align="left">
			<table>
			<tr>
				<td>Rule Title:<span style="padding:10px"><form:input path="ruleTitle"/></span></td>
				<td>RuleAccessLevel:<span style="padding:10px">
					<form:select path="ruleAccessLevel" items="${populateRulesUI.ruleAccessLvlList}"/>
					</span></td>
				<td>EntityType ID:<span style="padding:10px"><form:input path="entityID"/></span></td>
			</tr>
			</table>
			</td>			
		</tr>
		<tr>
			<td colspan="4" align="left">
			<table>
			<tr>
				<td align="left">Category:
				<span style="padding:10px">
					<form:select path="category">
						<option value="">--- select ---</option>
						<form:options items="${populateRulesUI.categoryList}"/>
					</form:select>
				</span>
			</td>
			<td align="left">Status:
				<span style="padding:10px">
					<form:select path="status">
						<option value="">--- select ---</option>
						<form:options items="${populateRulesUI.statusList}"/>
					</form:select>
				</span>
			</td>
		
			<td colspan="2" align="left">Criticality:
			<span style="padding:10px">
					<form:select path="criticality">
						<option value="">--- select ---</option>
						<form:options items="${populateRulesUI.criticalityList}"/>
					</form:select>
				</span>
			</td>
			</tr>
			</table>
			</td>
		</tr>	
		<tr>
			<td colspan="4" align="left">
			<table>
			 <tr>
			 	<td>Description:</td>			 	
			 </tr>
			 <tr><td><form:textarea path="description"/></td></tr>
			</table>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="left">Trigger</td>
		</tr>
		<tr>
			<td colspan="4">
			<table>
				<tr>
					<td align="left">If
					<span style="padding:10px">
							<form:select path="ruleTypeInfoId" onchange="fnDisplayRuleDetails (this);">
								<option value="">--- select ---</option>
								<c:forEach items="${populateRulesUI.ruleTypeList}" var="ruleTypeObj">
									<option value="${ruleTypeObj.id}">${ruleTypeObj.ruleType}</option>
								</c:forEach>
							</form:select>
					</span>
					</td>
					<td align="left">
						<span style="padding:10px" id="conditionDet_1">
							<select>
								<option value="">Select RuleType</option>
							</select>
						</span>
					</td>
					<td align="left">
						<span style="padding:10px" id="conditionDet_2">
							<select>
								<option value="">Select RuleType</option>
							</select>
						</span>
					</td>
					<td align="left">
						<span style="padding:10px" id="conditionDet_3">
							<select>
								<option value="">Select RuleType</option>
							</select>
						</span>
					</td>
				</tr>
			</table>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="left" style="font-weight: bold">Action</td>
		</tr>
		<tr>
			<td colspan="4">
				<table>
				<tr>
					<td>Then</td>
					<td align="left">
						<span style="padding:10px" id="actionDet_1">
							<select>
								<option value="">Select RuleType</option>
							</select>
						</span>
					</td>
					<td colspan="2" align="left">
						<span style="padding:10px" id="actionDet_2">
							<select>
								<option value="">Select RuleType</option>
							</select>
						</span>
					</td>
				</tr>
				</table>
			</td>
		</tr>		
		<tr>
			<td>
				<table>
				<tr>
					<td align="left">And</td>
					<td><span style="padding:10px"> Send </span></td>
					<td align="left">
						<span style="padding:10px" id="commTypeDetId">
							<select>
								<option value="">Select RuleType</option>
							</select>
						</span>
					</td>
					<td><span style="padding:10px"> To </span></td>
					<td align="left">
						<span style="padding:10px" id="mailTo_1">
							<select>
								<option value="">Select RuleType</option>
							</select>
						</span>
					</td>
					<td align="left">
						<span style="padding:10px" id="mailTo_2">
							<select>
								<option value="">Select RuleType</option>
							</select>
						</span>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		<tr>	
			<td colspan="3"><input type="button" value="Save" onclick="fnSubmit ();"/></td>
		</tr>		
	</table>
	</div>
	</c:if>
	</form:form>
</body>
</html>