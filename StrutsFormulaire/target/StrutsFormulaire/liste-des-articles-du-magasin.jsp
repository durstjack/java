<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>liste des articles</title>
</head>
<body>
<h2>liste des articles </h2>
<table>
<tr><td>libelle</td><td>poids</td><td>prix</td></tr>
<s:iterator value="articles" var="article" >
	<tr>
		<td><s:property value="#article.libelle" /></td>
		<td><s:property value="#article.poids" /></td>
		<td><s:property value="#article.prix" /></td>
	</tr>

</s:iterator>
</table>

<br/>
<br/>
<s:select list="articles" name="articleID" listKey="id" listValue="libelle"></s:select>
<br/>
<br/>
<s:checkboxlist list="articles" name="articleID" listValue="libelle" listValueKey="id"></s:checkboxlist>
<br/>
<br/>


</body>
</html>