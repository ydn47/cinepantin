<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="description" content="">
<meta name="author" content="">
<title>Insertion d'une catégorie</title>
<link rel="stylesheet" href="${normalize}" />

<link rel="stylesheet" href="${bootsrap}">
<link rel="stylesheet" href="${main}">
<link rel="stylesheet" href="${jqueryrating}">
<link rel="stylesheet" href="${multiselect}" />

<c:url var="normalize" value="/_css/normalize.css" />
<c:url var="boots" value="/_css/bootstrap.min.css" />
<c:url var="bootsrap" value="/css/boostrapOrange.css" />
<c:url var="bootsrap1" value="/css/screen_preview.css" />
<c:url var="jqueryrating" value="/css/jquery.rating.css" />
<c:url var="jquery" value="/_js/jquery-1.11.0.min.js" />
<c:url var="jqueryCategorie" value="_js/categorie.js" />

<script src="${jquery}"></script>
<script src="${jqueryCategorie}"></script>

</head>
<body>
	<div class="row">
		<h2>Ajout d'une nouvelle catégorie</h2>
	</div>
	<div class="row">
	<input type="button" class="btn btn-info" id="ajoutProp"
		value="Ajouter une propriété" />
	</div>
	<form action="SerialController" method="post">
		<div class="row">
			Nom de la catégorie: <input type="text" name="nomCateg" value=""
				required="required" />
		</div>
		<div id="inputProprietes">
		<input type="hidden" value="" name="totalChamps" />
		</div>
			<div class="row">
				<input type="submit" name="ajoutCateg" value="Ajouter" />
			</div>
			
	</form>
	<a href="SerialController">Retour au choix des catégories</a>
</body>
</html>