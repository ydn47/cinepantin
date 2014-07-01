<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Choix d'une catégorie</title>
<meta name="description" content="">
<meta name="author" content="">
<c:url var="normalize" value="/_css/normalize.css" />
<c:url var="boots" value="/_css/bootstrap.min.css" />
<!--<c:url var="bootsrap" value="/css/boostrap.css" /> bleu-->
<c:url var="bootsrap" value="/css/boostrapOrange.css" />
<c:url var="bootsrap1" value="/css/screen_preview.css" />
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
	<form action="/CinePantin/SerialController" method="post">
		<div class="row"><h2>Choisissez une catégorie d'articles</h2></div>
		<c:forEach items="${lstCategories}" var="typeCat">
			 <div class="row"><input type="radio" name="categories"
				value="${typeCat.getIdCategorie()}" required />${typeCat.getNomCategorie()}</div>
		</c:forEach>
			<div class="row"><input type="radio" name="categories" value="${fn:length(lstCategories)+1}" />Nouvelle catégorie</div>
		<br />
		<div class="row"><input type="submit" name="valider" value="Valider" /></div>
	</form>
	</div>
</body>
</html>