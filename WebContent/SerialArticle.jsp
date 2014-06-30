<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Choix d'une catégorie</title>
</head>
<body>
	<form action="/CinePantin/SerialController" method="post">
		<p>Choisissez une catégorie :</p>
		<c:forEach items="${lstCategories}" var="typeCat">
			<input type="radio" name="categories" value="${typeCat.getIdCategorie()}" required />${typeCat.getNomCategorie()}
		</c:forEach>
		<br /> <input type="submit" name="valider" value="Valider" />
	</form>
</body>
</html>