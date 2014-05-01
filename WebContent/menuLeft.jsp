<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="span3"><!-- start sidebar -->
<ul class="breadcrumb">
    <li>Categories</li>
</ul>
<div class="span3 product_list">
	<ul class="nav">
		<c:forEach var="categorie" items="${lstCategories}" varStatus="indexCategorie">
			<li>
				<a href="listings.jsp">${categorie.getNomCategorie} (5)</a>
			</li>
		</c:forEach>
		<li>
			<a class="active" href="listings.jsp">Livre (5)</a>
		</li>
		<li>
			<a href="listings.jsp">DVD (5)</a>
		  </li>
		<li>
			<a href="listings.jsp">Téléphonie (2)</a>
		</li>
	</ul>
</div>
<!-- end sidebar -->	
</div>