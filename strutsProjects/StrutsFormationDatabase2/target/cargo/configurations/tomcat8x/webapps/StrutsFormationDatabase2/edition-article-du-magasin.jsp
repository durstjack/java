<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello</title>
</head>
<body>
<h2><s:property value="message" /> </h2>
<s:form action="enregistrerForm" method="post">
<s:textfield name="libelle" label="nom de l'article"/>
<s:textfield name="prix" label="prix en €"/>
<s:textfield name="poids" label="poids"/>
<s:submit value="valider" />
</s:form>
</body>
</html>