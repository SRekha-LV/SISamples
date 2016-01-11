<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

</style>
</head>
<body>
	<table  style="margin-left:25px;border-collapse:collapse;" height="90%" width="95%" border="1" cellpadding="10px" cellspacing="5px" align="center">
    <tr>
        <td colspan="2" style="text-align: center;font-weight:bold; "><tiles:insertAttribute name="header" />
        </td>
    </tr>
    <tr height="700" style="vertical-align: top;margin:20px;">
        <td width="100"><tiles:insertAttribute name="menu" /></td>
        <td width="750"><tiles:insertAttribute name="body" /></td>
    </tr>
    <tr>
        <td height="30" colspan="2"><tiles:insertAttribute name="footer" />
        </td>
    </tr>
</table>
</body>
</html>
