<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenue chez CinePantin</title>
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
				<p><a class="btn btn-default" href="${articleCont}${article.getIdArticle()}" role="button">Afficher détails »</a></p>
				</div>
			</c:forEach>
		</div>

	</div>
	<hr>

	<%@include file="Footer.jsp"%>
</body>
</html>