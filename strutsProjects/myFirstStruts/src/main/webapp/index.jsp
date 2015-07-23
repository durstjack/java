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
<!--  property est une valuestack ou struts met ttes les valeurs -->
<!--  il examine notre classe pour trouver le getter -->
<!--  de l'action a la jsp c'est le get | de la jsp à l'action c'est le set -->
<h2><s:property value="message" /> </h2>
</body>
</html>