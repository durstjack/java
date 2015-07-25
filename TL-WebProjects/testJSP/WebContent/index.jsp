<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Introduction a JSP</title>
</head>
<body>
<!--  declaration pas une variable locale, c'est un attribut de la classe -->
<!--  on peut aussi definir des méthodes, mettre des getters, des setters -->
<%! 
	int compteur = 0;
	
	//fonction inverse() - inverse un mot
	private String inverse(String message){
	StringBuilder sb = new StringBuilder();
	for(int i = message.length() - 1; i>=0; i--){
		sb.append(message.charAt(i));
	}
	return sb.toString();
	}


	String paragraphe = "Aliquam erat volutpat. Vestibulum non massa fermentum, faucibus turpis vel, placerat metus. Sed finibus lorem id nisi vestibulum pretium. Pellentesque porta, risus a dignissim venenatis, lacus risus scelerisque tellus, id pretium lacus massa sed augue. Fusce in cursus elit. Aenean sed quam velit. Phasellus commodo id justo quis tincidunt. Duis nec sollicitudin enim. Nam eu nisi luctus, pulvinar nisi at, dapibus odio. Praesent aliquam augue eu sem pulvinar efficitur. Donec a nisl ac mi fermentum eleifend. Curabitur varius, enim non dictum scelerisque, arcu eros tempor nulla, non vehicula ipsum eros at tellus. Nulla quis euismod mauris, eget iaculis lectus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.";

%>

<h2>Introduction a JSP</h2>
<h2><%= config.getInitParameter("titre") %></h2>
<p>
<%= new Date() %>
</p>
<p>
<%
/* Use SimpleDateFormat#parse() to parse a String in a certain pattern into a Date.

String oldstring = "2011-01-18 00:00:00.0";
Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(oldstring);
Use SimpleDateFormat#format() to format a Date into a String in a certain pattern.

String newstring = new SimpleDateFormat("yyyy-MM-dd").format(date);
System.out.println(newstring); // 2011-01-18 */

Date date = new Date();
String dateString = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(date);
out.println(dateString +"s");
%>
</p>
<p>

<%
	out.print("<ul>");
	for(int i=0; i<10; i++){
		out.print("<li>" + i + "</li>");
	}
	out.print("</ul>");
%>
</p>

<p>
<%
compteur++;
out.println("Compteur = " + compteur);
%>
</p>
<h3>Paragraphe normal</h3>
<p>
<%= paragraphe %>
</p>
<h3>Paragraphe inversé</h3>
<p>
<%= inverse(paragraphe) %>
</p>

</body>
</html>