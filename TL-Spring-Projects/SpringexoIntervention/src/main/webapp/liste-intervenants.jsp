<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des interventions</title>
</head>
<body>
<h2>voici la liste des intervenants</h2>

<table>
	<tr>
		<td>id</td>
		<td>nom</td>
		<td>email</td>				
		<td>actions</td>
	</tr>

<s:iterator value="intervenants">
	<tr>
		<td><s:property value="id"/> </td>
		<td><s:property value="nom"/></td>
		<td><s:property value="email"/> </td>
		<td><s:a href="#edit/%{id}">editer</s:a></td>
	</tr>
</s:iterator>


</table>

</body>
</html>