<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <%@ include file="charge-style-header.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello</title>
</head>
<body>

<div class="row">

	<div class="col-xs-6">

		 	 <div class="jumbotron">
				<h1>Bienvenue sur notre site internet</h1>
				<p>Vous pouvez charger aléatoirement un proverbe grtace a la technologie ajax</p>	
				<p><button id="ajaxTTcmd" class="btn btn-success"> charger tt les proverbes</button><button id="ajaxUNcmd" class="btn btn-success"> charger 1 proverbe</button></p>
			</div>

	</div>
	<div class="col-xs-6">
		<div id="zoneProverbe">
		</div>	
	</div>

</div>
<div class="row">

	<div class="col-xs-2"></div>
	<div class="col-xs-8"><div id="zoneAllProverbes"></div>	
	<div class="col-xs-2"></div>

</div>

 <%@ include file="charge-style-footer.jsp" %>
</body>
</html>