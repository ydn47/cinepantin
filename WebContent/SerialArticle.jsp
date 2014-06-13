<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insertion d'un article</title>
</head>
<body>
	<form action="/CinePantin/SerialController" method="post">
		<input type="hidden" name="categorie" value="${categorie}" />
		Nom de l'article <input type="text" id="nomArticle" name="nomArticle"
			maxlength="100" /><br /> Description courte <input type="text"
			id="shortDesc" name="shortDesc" maxlength="100" /><br />
		Description longue <input type="text" id="longDesc" name="longDesc"
			maxlength="255" /><br /> Prix unitaire <input type="text"
			id="prixUnit" name="prixUnit" /><br /> Quantité en stock <input
			type="text" id="qteStock" name="qteStock" /><br /> TVA <select>
			<option value="REDUIT">REDUIT</option>
			<option value="NORMAL">NORMAL</option>
			<option value="LUXE">LUXE</option>
		</select><br /> Image <input type="file" id="imageArticle" name="imageArticle" /><br />
		<c:if test="${not urlCategorie}">
		Catégorie <select name="listeCateg">
				<option value="default" selected="selected">Choisissez une
					catégorie</option>
				<c:if test="${not empty lstCategories}">
					<c:forEach var="categ" items="${lstCategories}">
						<option value="${categ.getIdCategorie()}">${categ.getNomCategorie()}</option>
					</c:forEach>
				</c:if>
			</select>
		</c:if>
		<!-- Plage de prix -->
		<c:choose>
		<c:when test="${categorie == 'DVD'}">
			Titre : <input type="text" name="titre" value="" /><br/>
			Réalisateurs : <input type="text" name="realisateurs" value="" /><br/>
		</c:when>
		<c:when test="${categorie == 'LIVRES'}">
			Auteur : <input type="text" name="auteur" value="" /><br/>
			Genre : <input type="text" name="genre" value="" /><br/>
		</c:when>
		<c:otherwise>
			Description: <input type="text" name="description" value="" /><br />
		</c:otherwise>
		</c:choose>

		<input type="submit" name="valider" value="valider" />

	</form>
</body>
</html>