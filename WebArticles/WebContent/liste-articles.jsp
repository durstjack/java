<%@page import="java.util.List"%>
<%@page import="com.loconto.WebArticles.beans.Article"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link href="css/style.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des articles</title>
</head>
<body style="width: 90%; margin: 20px auto;">

<h2>Bienvenue sur notre catalogue de produit</h2>

<table class="CSSTableGenerator">
<tr><th>ID</th><th>libellé</th><th>prix</th><th>poids</th><th colspan=2>action</th></tr>


<%
	List<Article> articles = (List<Article>)request.getAttribute("articles");
	
	for(Article a : articles){
%>

		<tr>
		<td> <%= a.getId() %></td>
		<td> <%= a.getLibelle() %></td>
		<td> <%= a.getPrix() %></td>
		<td> <%= a.getPoids() %> </td>
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