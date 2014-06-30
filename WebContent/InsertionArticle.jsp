<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insertion d'un ${fn:toLowerCase(nomCateg)}</title>
</head>
<body>
<form action="SerialController" method="post">
<input type="hidden" name="idCategorie" value="${idCategorie}" />
<c:forEach items="${proprietes}" var="prop">
	${prop}: <input type="text" name="${prop}" value="" required="required" /><br/>
</c:forEach>
<c:set var="proprietes" value="${proprietes}" ></c:set>
<input type="submit" value="Inserer" name="insert" />
</form>
<a href="SerialController">Retour au choix des catégories</a>
</body>
</html>