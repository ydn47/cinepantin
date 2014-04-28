<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>
<form action="SerialController" method="post">
Titre: <input id="titre" type="text" name="titre" />
Réalisateurs: <input id="realisateurs" type="text" name="realisateurs" />
<input type="submit" name="valider" value="valider" />
</form>
<form action="SerialController" method="get">
Afficher article sérialisé <input type="submit" name="afficher" value="afficher" />
</form>
</body>
</html>