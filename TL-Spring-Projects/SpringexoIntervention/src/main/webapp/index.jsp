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
<p><s:a action="liste-interventions">voir les interventions</s:a></p>
<p><s:a action="liste-intervenants">voir les intervenants</s:a></p>
<p><s:a action="liste-intervenants">voir les materiels</s:a></p>
<br/><br/><br/>
<p><s:a action="creer-intervention">créer une intervention</s:a></p>
<p><s:a action="creer-intervenant">créer une intervenant</s:a></p>
<p><s:a action="creer-intervenant">créer une materiel</s:a></p>
</body>
</html>