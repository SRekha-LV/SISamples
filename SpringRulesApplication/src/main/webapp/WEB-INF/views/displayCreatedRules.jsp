<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
#ruleDtTbl td {
	white-space: nowrap;
	text-align: center;
}
th {
	padding: 2px;
	background:#DCDCDC;
	white-space: nowrap;
}
#ruleTbl td {
	white-space: normal;
}

fontBold {
	font-weight: bold;
}

</style>
</head>
<body>
	<c:if test="${not empty definedcreatedRuleList}">
	<table id="ruleDtTbl" width="80%" style="margin-left:20px;border-collapse:collapse;" border="1" cellspacing="2" cellpadding="2">
	<tr>
		<th>Id</th>
 		<th>Rule Title</th>
 		<th>Category</th>
 		<th>Status</th>
 		<th>Criticality</th>
 		<th>Description</th>
 		<th>Rule</th>
	</tr>
	<c:forEach items="${definedcreatedRuleList}" var="createdRulesDisplay">
	 	<tr>
	 		<td>${createdRulesDisplay.id}</td>
	 		<td width="20px" style="white-space: normal;">${createdRulesDisplay.ruleTitle}</td>
	 		<td>${createdRulesDisplay.category}</td>
	 		<td>${createdRulesDisplay.status}</td>
	 		<td>${createdRulesDisplay.criticality}</td>
	 		<td width="60px" style="white-space: normal;">${createdRulesDisplay.description}</td>
	 		<td><table id="ruleTbl">
	 			<tr>
	 				<td colspan="2">
	 				<table>
	 				<tr>
	 					<td>If</td>
		 				<td class="fontBold">${createdRulesDisplay.ruleTypeInfo}</td>
		 				<td style="background-color: #F2F2F4">${createdRulesDisplay.condition_1}</td>
		 				<td style="background-color: #F2F2F6">${createdRulesDisplay.condition_2}</td>
		 				<td style="background-color: #F2F2F8">${createdRulesDisplay.condition_3}</td>
	 				</tr>
	 				</table>
	 				</td>
 				</tr>
 				<tr>
	 				<td align="center" colspan="2">Then</td>
 				</tr>
 				<tr>
 					<td>
 					<table align="center">
 						<tr>
 							<td style="background-color: #F2F2F6">${createdRulesDisplay.action_1}</td>
	 						<td style="background-color: #F2F2F8">${createdRulesDisplay.action_2}</td>
 						</tr>
 					</table>
 					</td>
	 			</tr>
	 			<tr>
	 				<td colspan="2"><table>
	 				<tr>
	 					<td>And Send</td>
		 				<td style="background-color: #FBEFF2">${createdRulesDisplay.commType}</td>
		 				<td>To</td>
		 				<td style="background-color: #F2F2F6">${createdRulesDisplay.recipient_1}</td>		 				
		 				<td><c:if test="${not empty createdRulesDisplay.recipient_2}">And</c:if></td>	
		 	 			<td style="background-color: #F2F2F8">${createdRulesDisplay.recipient_2}</td> 
	 				</tr>
	 				</table>
	 				</td>				
	 			</tr>
	 		</table>	 		
	 		</td>
	 	</tr>
	</c:forEach>
	 </table>
	</c:if>
	
</body>
</html>