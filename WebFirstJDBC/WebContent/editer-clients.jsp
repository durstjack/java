<%@page import="java.util.List"%>
<%@page import="com.loconto.webfirstjdbc.beans.Clients"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modifier le client</title>
</head>
<body style="width: 90%; margin: 20px auto;">

<table>
<tr><th>ID</th><th>Nom</th><th>email</th><th>Actions</th></tr>

<%
	Clients c = (Clients)request.getAttribute("client");

		
		out.println("<form action='ClientsServlet' method='post'><tr><td>ID : <input type='text' name='id' value='" + c.getId() +"' /></td>" +
				"<td>Nom : <input type='text' name='id' value='" + c.getNom() +"' /></td>"+
				"<td>Email : <input type='text' name='id' value='" + c.getEmail() +"' /></td>"+
				"<td>Solde : <input type='text' name='id' value='" + c.getSolde() +"€' /></td>"+
				"<input type='hidden' name='id' value='" + c.getId() +"' />" +
				"<input type='submit' name='action' value='enregistrer' />" +
				"</td></tr></form>");		

%>

</table>

</body>
</html>