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

<h2>Bienvenue sur notre catalogue de produit</h2>

<table class="CSSTableGenerator">
<tr><th>ID</th>
<th><a href="IndexServlet/libelle">libellé</a></th>
<th><a href="IndexServlet/prix">prix</a></th>
<th><a href="IndexServlet/poids">poids</a></th>
<th colspan=2>action</th></tr>


<%
	List<Article> articles = (List<Article>)request.getAttribute("articles");
	
	for(Article a : articles){
%>

		<tr>
		<td> <%= a.getId() %></td>
		<td> <%= a.getLibelle() %></td>
		<td> <%= a.getPrix() %> €</td>
		<td> <%= a.getPoids() %> Kg </td>
		<td>
		<form action="IndexServlet" method="post">
			<input type="hidden" name="action" value="editer" />
			<input type="hidden" name="id" value="<%= a.getId() %>" />
			<input type="submit" value="editer" style="cursor: pointer;"/>
		</form>
		</td>
		<td>
		<form action="IndexServlet" method="post">
			<input type="hidden" name="action" value="supprimer" />
			<input type="hidden" name="id" value="<%= a.getId() %>" />
			<input type="submit" value="supprimer" style="cursor: pointer;" />
		</form>
		</td>
		</tr>


<%
	}

%>		

		
		

</table>

</body>
</html>