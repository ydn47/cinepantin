<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="span3">
	<!-- start sidebar -->
	<ul class="breadcrumb">
		<li>Categories</li>
	</ul>
	<div class="span3 product_list">
		<ul class="nav">
			<c:set var="indice" value="${0}"/>
			<c:forEach var="categorie" items="${lstCategories}"
				varStatus="status">
				
				<li><a href="${categController}${categorie.getIdCategorie()}">${categorie.getNomCategorie()}
						(${totalArticles[indice]})</a></li>
				<c:set var="indice" value="${indice + 1}"/>
			</c:forEach>

		</ul>
	</div>
	<!-- end sidebar -->
</div>
