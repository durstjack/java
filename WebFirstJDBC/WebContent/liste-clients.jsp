<%@page import="java.util.List"%>
<%@page import="com.loconto.webfirstjdbc.beans.Clients"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenue voici la liste des clients</title>
</head>
<body style="width: 90%; margin: 20px auto;">

<table>
<tr><th>Nom</th><th>email</th><th>Actions</th></tr>


<%
	List<Clients> clients = (List<Clients>)request.getAttribute("clients");
	
	for(Clients c : clients){
		
		out.println("<tr><td>" + c.getNom() + "</td><td>" + c.getEmail() + "</td><td>" +
				"<form action='ClientsServlet' method='post'>" +
				"<input type='hidden' name='id' value='" + c.getId() +"' />" +
				"<input type='hidden' name='action' value='editer' />" +
				"<input type='submit' value='edition' style='cursor: pointer;' />" +
				"</form></td></tr>");
		
	}


%>

</table>

</body>
</html>