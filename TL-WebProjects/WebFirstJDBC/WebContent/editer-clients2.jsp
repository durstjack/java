<%@page import="java.util.List"%>
<%@page import="com.loconto.webfirstjdbc.beans.Clients"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modifier le client</title>
</head>
<body style="width: 90%; margin: 20px auto;">
<h2>edition client</h2>

<!--  tag lib librairie de base de JSP \ nous permet ici de selectionner un client grace a son bean (sa classe) -->
<jsp:useBean id="client" type="com.loconto.webfirstjdbc.beans.Clients" scope="request"></jsp:useBean>

<form action="ClientsServlet" method="post">
<p>ID : <input type="text" name="id" value='<jsp:getProperty property="id" name="client"/>' size=50 /><p>
<p>Nom : <input type="text" name="nom" value='<jsp:getProperty property="nom" name="client"/>' size=50 /><p>
<p>Email : <input type="text" name="email" value='<jsp:getProperty property="email" name="client"/>' size=50 /><p>
<p>Solde : <input type="text" name="solde" value='<jsp:getProperty property="solde" name="client"/>' size=50 /><p>
<p><input type="hidden" name="action" value="enregistrer" /><p>
<p><br/><br/><input type="submit" value='Enregistrer' /><p>
</form>

<a href="ClientsServlet">Revenir à l'accueil - ClientsServlet</a>
<br/>
<a href="Accueil">Revenir à l'accueil - Accueil</a>

</body>
</html>