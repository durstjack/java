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
<h2>Editer une intervention</h2>

<s:form action="save" method="post">
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

	<tr>
		<td><s:hidden name="idIntervention" value="%{idIntervention}" /></td>
		<td><s:textfield name="datePlanification" value="%{datePlanification}"  /></td>
		<td><s:textfield name="memo" value="%{memo}"  /></td>
		<td><s:textfield name="statuts" value="%{statuts}"  /></td>
		<td><s:textfield name="intervenant.nom" value="%{intervenant.nom}"  /></td>
		<td><s:textfield name="materiel.nom" value="%{materiel.nom}"  /></td>	
		<td><s:textfield name="materiel.noSerie" value="%{materiel.noSerie}"  /></td>				

		<td><s:a href="#edit/%{id}">editer</s:a></td>
	</tr>





<s:textfield name="messageTitre" value="%{messageTitre}" label="titre message" />
<s:textfield name="messageCorps" value="%{messageCorps}" label="corps du message" />


</table>
<s:submit />
</s:form>


</body>
</html>