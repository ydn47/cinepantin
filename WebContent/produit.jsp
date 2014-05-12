<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>

<%@include file="entete.jsp"%>
<div class="row">
	<%@include file="menuLeft.jsp"%>
	<c:choose>
			<c:when test="${succes == true}">
				<script type="text/javascript">
					alert('Votre article a été bien ajouté au panier !');
				</script>

			</c:when>
			<c:otherwise>


			</c:otherwise>
		</c:choose>
	<div class="span9">
		<ul class="breadcrumb">
			<li><a href="${boutique}">Home</a> <span class="divider">/</span></li>
			<li><a href="#">${articleObject.getCategorie().getNomCategorie()}</a> <span class="divider">/</span></li>
			<li class="active"><a href="#">${articleObject.getNomArticle()}</a></li>
		</ul>


		<div class="row">
			<div class="span9">
				<h1>${articleObject.getNomArticle()}</h1>
			</div>
		</div>
		<hr>

		<div class="row">
			<div class="span3">
				<img src="css/images/ipod_touch.jpg" alt="">


				<ul class="thumbnails">

					<li class="span1"><a class="thumbnail" href="#"> <img
							alt="" src="css/images/1_50.jpg">
					</a></li>

					<li class="span1"><a class="thumbnail" href="#"> <img
							alt="" src="css/images/2_50.jpg">
					</a></li>

					<li class="span1"><a class="thumbnail" href="#"> <img
							alt="" src="css/images/3_50.jpg">
					</a></li>

				</ul>

			</div>

			<div class="span6">

				<div class="span6">
					<address>
						<c:forEach var="prop" items="${articleObject.getProprietes()}">
							<strong>${fn:toUpperCase(fn:substring(prop.key,0,1))}${fn:substring(prop.key,1,fn:length(prop.key))}</strong>
							<span>${prop.value}</span>
							<br>
						</c:forEach>
					</address>
				</div>

				<div class="span6">
					<h2>
						<strong>Prix: ${articleObject.getPrixUnitTTCFormat()} EUR</strong> <br>
						<br>
					</h2>
				</div>

				<div class="span6">
					<form class="form-inline" method="post" action="${paniercont}">
						<div class="hidden">
						<input type="hidden" value="${articleObject.getIdArticle()}"
							name="productId">
					</div>
						<div class='span3 no_margin_left controls '>
							<label >Qté:</label>
							<input type="number"  min="1" max="5" value="1" placeholder="1" class="span1" name="quantity"/> 
							<input  class="btn btn-primary" type="submit" name="addCart" value="Ajouter au panier" />
							${erreur["quantite"] }
							${erreur["articleID"] }
						</div>
					</form>
				</div>


			</div>


		</div>
		<hr>
		<div class="row">
			<div class="span9">
				<div class="tabbable">
					<ul class="nav nav-tabs">
						<li class="active"><a data-toggle="tab" href="#1">Description</a></li>
						<li><a data-toggle="tab" href="#2">Commentaires</a></li>
					</ul>
					<div class="tab-content">
						<div id="1" class="tab-pane active">
							<p>${articleObject.getShortDescArticle()}</p>
							<p>${articleObject.getLongDescArticle()}</p>
						</div>
						<div id="2" class="tab-pane">
							<p>Il n'y a pas de commentaire pour ce produit.</p>
						</div>
					</div>
				</div>

			</div>
		</div>



	</div>

</div>


<%@include file="pied.jsp"%>

</body>
</html>