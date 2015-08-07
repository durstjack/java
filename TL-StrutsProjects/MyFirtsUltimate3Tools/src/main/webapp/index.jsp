<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello</title>
</head>
<body>
<h2>Listes des messages </h2>

<table>
	<tr><td>titre</td><td>titre</td><td>actions</td></tr>
	
	<s:iterator value="messages">
		<tr><td><s:property value="titre"/> </td><td><s:property value="corps"/></td><td><s:a href="edit/%{id}">editer</s:a></tr>
	</s:iterator>
</table>

</body>
</html>