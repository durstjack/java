<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Triangle</title>
 <link href="style/<%= request.getAttribute("style") %>" rel="stylesheet" type="text/css" />
</head>
<body>
<h2> triangle de taille <span style="color: red;"><%= request.getAttribute("dimension") %></span></h2>
<table style='width: 600px; margin: 0 auto;' >
<%
int dimension = (int)request.getAttribute("dimension");

for (int ligne = 0; ligne < dimension; ligne++)
{
	out.println("<tr>");
	for(int colonne = 0; colonne < dimension - ligne; colonne++) {

			out.print("<td class='cellule'>X</td>");

	}
	// passage a la ligne suivante
	out.println("</tr>");
}

%>
</table>
<br/>
<br/>

<a href="index.html">retour au formulaire</a>
</body>
</html>