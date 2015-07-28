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
	   	 <p style="text-align: right;"><a href="flux-RSS" target="_blank" title="ouvrir le flux RSS"><img src="data:image/jpeg;base64,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" /></a></p>
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
	<p style="text-align: center;"><s:a href="create" class="btn btn-lg btn-success auCentre">créér un article</s:a>  <s:a href="flux-RSS">Voir le flux RSS</s:a></p>
</div>
</body>
</html>