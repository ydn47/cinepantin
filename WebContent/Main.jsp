<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenue chez CinePantin</title>
<c:url var="jQuery" value="/_js/libs/jquery-1.10.2.min.js" />
<c:url var="bootstjs" value="/_js/bootstrap.min.js" />

<c:url var="normalize" value="/_css/normalize.css" />
<c:url var="boots" value="/_css/bootstrap.min.css" />
<c:url var="bord" value="/_css/dashboard.css" />
<c:url var="starter" value="/_css/starter-template.css" />
<c:url var="starter" value="/_css/jumbotron.css" />


<c:url var="urlAdd" value="/dvd/add" />
<link rel="stylesheet" href="${bord}">
<link rel="stylesheet" href="${normalize}" />
<link rel="stylesheet" href="${boots}" />
<%-- 	<link href="${starter}" rel="stylesheet"> --%>
<link href="${jumbotron}" rel="stylesheet">
<link rel="stylesheet" type="text/css" media="screen"
	href="//d85wutc1n854v.cloudfront.net/live/css/screen.css?buster-140319-2">
</head>
<body style="padding-top: 100px">
	<%@include file="Header.jsp"%>
	<div class="jumbotron">
		<div class="container">
			<h1>Hello, world!</h1>
			<p>This is a template for a simple marketing or informational
				website. It includes a large callout called a jumbotron and three
				supporting pieces of content. Use it as a starting point to create
				something more unique.</p>
			<p>
				<a class="btn btn-primary btn-lg" role="button">Learn more »</a>
			</p>
		</div>
	</div>
	<div class="container">
		<!-- Example row of columns -->

		<div class="row">
			<c:forEach var="article" items="${lstArticles}"
				varStatus="indexArticle">
				<div class="col-md-4">
				<h2>${article.getNomArticle()}</h2>
				<p>${article.getShortDescArticle()}</p>
				<p>${article.getLongDescArticle()}</p>
				<p><a class="btn btn-default" href="#" role="button">Afficher détails »</a></p>
				</div>
			</c:forEach>
			<c:forEach var="article" items="${lstArticles}"
				varStatus="indexArticle">
				<div class="col-md-4">
				<h2>${article.getNomArticle()}</h2>
				<p>${article.getShortDescArticle()}</p>
				<p>${article.getLongDescArticle()}</p>
				<p><a class="btn btn-default" href="#" role="button">Afficher détails »</a></p>
				</div>
			</c:forEach>
		</div>

	</div>
	<hr>

	<%@include file="Footer.jsp"%>
</body>
</html>