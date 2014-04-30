<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="Head.jsp"%>
<c:url var="main" value="/_css/main.css" />
<link rel="stylesheet" href="${main}">

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
	
<!-- 		http://wrapbootstrap.com/preview/WB00223R0 -->
	<div class="span12">

	 
	<h1> Shopping Cart</h1><br>
	 <c:if test='${not empty "$panierContent"}'>
         <form class="form-horizontal" method="post" action="${paniercont}">
        <table class="table table-bordered table-striped">
		  <thead>
			  <tr>
				<th>Supprimer</th>
				<th>Image</th>
				<th>Article</th>
				<th>Quantité</th>
				<th>Prix unitaire</th>
				<th>Total</th>
			  </tr>
			</thead>
			<tbody>
				<c:forEach var="ligne" items="${panierContent.getLignesPanier()}">
						<tr>
							<td class=""><input type="checkbox" value="${ligne.getArticle().getIdArticle()}" id="optionsCheckbox" name="optionsCheckbox"></td>
							<td class="muted center_text"><a href="product.html"><img src="css/images/macbook-pro.jpg"></a></td>
							<td>${ligne.getArticle().getNomArticle()}</td>
				
							<td><input style ="height: 18px;padding-top:0px;padding-bottom:0px;" class="input-mini" type ="number" min="1" max="5" value="${ligne.getQteCommande()}"></td>
							<td>EUR ${ligne.getArticle().getPrixUnitArticleTTC()}</td>
							<td>EUR ${ligne.getTotalTTC()} </td>
						</tr>
					</c:forEach>
			  <tr>

			  </tr>			  
			   <tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>Total TTC</td>
				<td><strong>EUR ${panierContent.getMontantTotalTTC()}</strong></td>
			  </tr>		
			   <tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>Total HT</td>
				<td><strong>EUR ${panierContent.getMontantTotalHT()}</strong></td>
			  </tr>		 			 
			   
			</tbody>
		  </table>
		 </c:if> 
		  <form class="form-horizontal" method="post" action="${paniercont}">
			<fieldset>	  
				<div class="row">
		  			<div class="span5">
		  				<input type="submit" class="btn primary" value="Modifier le panier" name="updateCart"/>
					</div>		  
					<div class="span2">
						<a href="${boutique}" class="btn primary pull-right">Continuer votre shopping</a>
					</div>		  
					<div class="span5">
            			<a href="${paniercont}" class="btn primary pull-right">Passer la commande</a>
					</div>
          		</div>
        	</fieldset>
        </form>
	</div>
	
	</div><!-- container -->

	<hr>

	<%@include file="Footer.jsp"%>
</body>


</html>      