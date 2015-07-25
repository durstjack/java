<%@page import="java.util.List"%>
<%@page import="com.loconto.WebArticles.beans.Article"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link href="http://localhost:8080/WebArticles/css/style.css" rel="stylesheet" type="text/css" />
 <!--  la même mais cette fois base est generéee d'une facon plus  pro (deploiement facilité -->
 <!--  <base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/"/> -->
 
 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- base url pour eviter les probleme de lien  -->
<base href="http://localhost:8080/WebArticles/">
<title>Liste des articles</title>
</head>

<body style="width: 90%; margin: 20px auto;">

<h2>Edition d'un produit</h2>

<table class="CSSTableGenerator">
<tr><th>ID</th>
<th><a href="IndexServlet/libelle">libellé</a></th>
<th><a href="IndexServlet/prix">prix</a></th>
<th><a href="IndexServlet/poids">poids</a></th>
<th colspan=2>action</th></tr>
<%
	Article a = (Article)request.getAttribute("article");	
%>

		<tr>
		<form action="IndexServlet" method="post">
		<td><input type="text" value="<%= a.getId() %>" disabled /></td>
		<td> <input type="text" name="libelle" value="<%= a.getLibelle() %>" /></td>
		<td><input type="text" name="prix" value="<%= a.getPrix() %>" /> € </td>
		<td><input type="text" name="poids" value="<%= a.getPoids() %>" /> Kg </td>
		<td>
			<input type="hidden" name="action" value="sauver" />
			<input type="hidden" name="id" value="<%= a.getId() %>" />
			<input type="submit" value="sauver" style="cursor: pointer;"/>
		</td>
		</form>
		<td>
		<form action="IndexServlet" method="post">
			<input type="hidden" name="action" value="supprimer" />
			<input type="hidden" name="id" value="<%= a.getId() %>" />
			<input type="submit" value="supprimer" style="cursor: pointer;" />
		</form>
		</td>
		</tr>	
		

</table>

</body>
</html>