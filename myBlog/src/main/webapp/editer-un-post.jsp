<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <%@ include file="charge-style.jsp" %>
  
<title>Edition d'un post | myBlog</title>
</head>
<body>
<div class="page">
	<div class="jumbotron">
	   <h1>Edition d'un Post</h1>
	   <p>Sur cet espace, vous pouvez modifier directement un post. Ce post sera sauvegardé dans la Base de Données.<br/>
	   Soyez vigilant, bon courage à vous ;)</p>
	 </div>
	
	<s:actionerror class="alert alert-danger" />
	<div class="row">
	
		<s:form action="save" method="post">
		<s:hidden name="postID" />
		
		<div class="col-xs-12 col-md-8">
			<div class="input-group input-group-lg row">
				<s:textfield name="postTitre" label="titre du post" class="form-control"/>
			</div>
			<br/>
			<br/>
			<div class="input-group input-group-lg row">
				<s:textarea name="postCorps"  cols="90" rows="16">
				</s:textarea>	
			</div>		
			<br/>
			<s:hidden name="postDate" />
		</div>
		
		<div class="col-xs-12 col-md-4">
			<p><span class="glyphicon glyphicon-inbox"></span>Enregistrer l'article</p>
			<p><s:submit value="Enregistrer l'article" class="btn btn-success btn-lg" /></p>	
		</div>

		</s:form>
	
	</div>
	
	
	<!-- Button trigger modal -->
	<p style="text-align: center; margin-top: 20px;"><button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal"> Besoin d'aide ?</button></p>

	
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Comment insérer un article ?</h4>
      </div>
      <div class="modal-body">
       <h5>Pour insérer un article:</h5>
       	
       	<div class="panel panel-info">
            <div class="panel-heading"><h3 class="panel-title">Choisir un titre</h3></div>
            <div class="panel-body">Choisissez un titre qui résumme l'article, évitez les caractères spéciaux etc..</div>
          </div>
          
          <div class="panel panel-info">
            <div class="panel-heading"><h3 class="panel-title">Editer le contenu de votre post</h3></div>
            <div class="panel-body">Après avoir donné un titre à votre post, editer le contenu de votre post.<br/>
            	Vous pouvez utilisez au maximum 900 caractères.</div>
          </div>
       	
       	<div class="alert alert-success" role="alert">Pour valider et enregistrer votre article <strong>cliquez sur ok</strong></div>
       	
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">OK j'ai compris</button>
      </div>
    </div>
  </div>
</div>
	
	
	
	
	
</div>
</body>
</html>