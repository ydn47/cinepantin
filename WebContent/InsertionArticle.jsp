<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insertion d'un ${fn:toLowerCase(nomCateg)}</title>
<meta name="description" content="">
<meta name="author" content="">
<c:url var="normalize" value="/_css/normalize.css" />
<c:url var="boots" value="/_css/bootstrap.min.css" />
<!--<c:url var="bootsrap" value="/css/boostrap.css" /> bleu-->
<c:url var="bootsrap" value="/css/boostrapOrange.css" />
<c:url var="bootsrap1" value="/css/screen_preview.css" />
<c:url var="imgDir" value="/css/images/" scope="request" />
<c:url var="jqueryrating" value="/css/jquery.rating.css" />


<link rel="stylesheet" href="${normalize}" />
<%-- <link rel="stylesheet" href="${boots}" />  --%>
<link rel="stylesheet" href="${bootsrap}">
<link rel="stylesheet" href="${main}">
<link rel="stylesheet" href="${jqueryrating}">
<link rel="stylesheet" href="${multiselect}" />
</head>
<body>
	<div class="container">
		<div class="row">
			<!-- start header -->
			<div class="span4 logo">
				<a href="${boutique}">
					<h1>CinePantin</h1>
				</a>
			</div>
		</div>
		<!-- end header -->
	</div>
	<div class="container">
		<div class="row">
			<h2>Insertion d'un article de la catégorie
				${fn:toUpperCase(nomCateg)}</h2>
		</div>
		<form action="SerialController" method="post">
			<input type="hidden" name="idCategorie" value="${idCategorie}" />
			<div class="row">
				<div class="span3">Titre</div>
				<div class="span3">
					<input type="text" name="nomArticle" placeholder="Entrer un titre"
						required="required" />
				</div>
			</div>
			<div class="row">
				<div class="span3">Description courte</div>
				<div class="span3">
					<input type="text" name="descCourte"
						placeholder="Entrer une description" required="required" />
				</div>
			</div>
			<div class="row">
				<div class="span3">Description longue</div>
				<div class="span3">
					<input type="text" name="descLongue"
						placeholder="Entrer une description" required="required" />
				</div>
			</div>
			<div class="row">
				<div class="span3">Prix</div>
				<div class="span3">
					<input type="number" step="0.01" min="0" name="prix"
						required="required" />
				</div>
			</div>
			<div class="row">
				<div class="span3">Quantité</div>
				<div class="span3">
					<input type="number" min="0" name="quantite" required="required" />
				</div>
			</div>
			<c:forEach items="${proprietes}" var="prop">
				<div class="row">
					<div class="span3">${prop}</div>
					<div class="span3">
						<input type="text" name="${prop}" value="" required="required" />
					</div>
				</div>
			</c:forEach>
			<input type="submit" value="Inserer" name="insert" />
		</form>
		<a href="SerialController">Retour au choix des catégories</a>
	</div>
</body>
</html>