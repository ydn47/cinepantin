<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>

<head>
	
	<meta charset="utf-8">
	<title>CinePantin - E-commerce plateform</title>

	<meta name="description" content="">
	<meta name="generator" content="CinePantin">
	<meta name="robots" content="index,follow">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">

	<!-- StyleSheet -->
	<c:url var="normalize" value="/_css/normalize.css" />
	<c:url var="boots" value="/_css/bootstrap.min.css" />
	<c:url var="bootsiconlarge" value="/_css/bootstrap.icon-large.min.css" />
	<c:url var="bootscloudfront" value="/_css/screen.css" />
	<c:url var="jumbotron" value="/_css/jumbotron.css" />
	<c:url var="dashboard" value="/_css/dashboard.css" />
	<c:url var="multiselcss" value="/_css/bootstrap-multiselect.css" />
	<c:url var="img" value="/_img" />
	
	<link rel="stylesheet" href="${normalize}" />
	<link rel="stylesheet" href="${boots}" />
	<link rel="stylesheet" href="${bootsiconlarge}">
	<link rel="stylesheet" href="${bootscloudfront}">
	<link rel="stylesheet" href="${jumbotron}">
	
	<!-- Script -->
	<c:url var="jQuery" value="/_js/jquery-1.11.0.min.js" />
	<c:url var="bootstjs" value="/_js/bootstrap.min.js" />
	<c:url var="multiseljs" value="/_js/bootstrap_multiselect.js" />
	<c:url var="valider" value="/_js/valider.js" />
	
	<script src="${jQuery}"></script>
	<script src="${bootstjs}"></script>
	<script src="${multiseljs}"></script>
	<script src="${valider}"></script>
	
	<!-- Urls -->
	<c:url var="articleCont" value="/article/" />
	<c:url var="boutique" value="/boutique" />
	<c:url var="signin" value="/sign/in" />
	<c:url var="signup" value="/sign/up" />
	<c:url var="disconnect" value="/sign/disconnect" />
	<c:url var="signmodif" value="/sign/editAccount" />
	<c:url var="paniercont" value="/panier"/>
</head>