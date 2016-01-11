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
	<c:if test="${not empty recipientDetList}">
	<table id="ruleDtTbl" width="80%" style="margin-left:20px;border-collapse:collapse;" border="1" cellspacing="2" cellpadding="2">
	<tr>
		<th>Id</th>
 		<th>Display Name</th>
 		<th>Field Type</th>
	</tr>
	<c:forEach items="${recipientDetList}" var="recipientDet">
	 	<tr>
	 		<td>${recipientDet.id}</td>
	 		<td style="text-align: left; padding-left:5px;">${recipientDet.recipientType}</td>
	 		<td style="text-align: left;padding-left:5px;">${recipientDet.recipientValue}</td>
	 	</tr>
	</c:forEach>
	 </table>
	</c:if>
	
</body>
</html>