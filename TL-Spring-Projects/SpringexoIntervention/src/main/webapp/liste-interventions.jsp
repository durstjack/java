<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-88w59-1">
<title>Liste des interventions</title>
</head>
<body>
<h2>voici la liste des interventions</h2>

<table>
	<tr>
		<td>id</td>
		<td>datePlanification</td>
		<td>memo</td>
		<td>statuts</td>
		<td>intervenant</td>
		<td>materiel</td>
		<td>nom</td>
		<td>moSerie</td>				
		<td>actions</td>
	</tr>

<s:iterator value="interventions">
	<tr>
		<td><s:property value="id"/> </td>
		<td><s:property value="datePlanification"/></td>
		<td><s:property value="memo"/> </td>
		<td><s:property value="statuts"/></td>
		<td><s:property value="intervenant.nom"/></td>
		<td><s:property value="materiel.nom"/></td>
		<td><s:property value="materiel.noSerie"/></td>	
		<td><s:a href="editer-intervention-*%{id}">editer</s:a></td>
	</tr>
</s:iterator>


</table>

</body>
</html>