<%@page import="java.util.List"%>
<%@page import="com.loconto.webfirstjdbc.beans.Clients"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifier le client</title>
</head>
<body>

<table>
<tr><th>ID</th><th>Nom</th><th>email</th><th>Actions</th></tr>


<%
	Clients c = (Clients)request.getAttribute("client");
	

		
		out.println("<tr><td>ID : <input type='text' name='id' value='" + c.getId() +"' /></td>" +
				"<tr><td>Nom : <input type='text' name='id' value='" + c.getNom() +"' /></td>"+
				"</form></td></tr>");
		

%>

</table>

</body>
</html>