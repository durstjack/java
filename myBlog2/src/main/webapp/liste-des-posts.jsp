<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <%@ include file="charge-style.jsp" %>
<title>liste des posts</title>
</head>
<body>
<div class="page">
	<div class="jumbotron">
	   <h1>Liste des Posts</h1>
	   <p>Bonjour et bienvenue,<br/>
	   Vous trouverez ci dessus la liste des posts de notre site, bonne lecture.</p>
	 </div>
	<table class="CSSTableGenerator">
	<tr><td>id</td><td>titre</td><td>corps</td><td>date</td><td colspan=2>actions</td></tr>
	<s:iterator value="posts" >
	<tr>
	<td><s:property value="id"/></td>
	<td><s:property value="titre"/></td>
	<td><s:property value="corps"/></td>
	<td><s:property value="date"/></td>
	<td class="cases-actions"><s:a href="edit/%{id}"><span class="glyphicon glyphicon-edit icones"></span></s:a> </td>
	<td class="cases-actions"><s:a href="delete-article-id-%{id}"><span class="glyphicon glyphicon-remove icones"></span></s:a> </td>
	</tr>
	</s:iterator>
	</table>
	<br/>
	<br/>
	<p><a href="#"><span class="glyphicon glyphicon-refresh GrandeIcones"></span></a></p>
	<p style="text-align: center;"><s:a href="create" class="btn btn-lg btn-success auCentre">créér un article</s:a></p>
</div>
</body>
</html>