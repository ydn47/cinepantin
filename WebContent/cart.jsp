<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="entete.jsp">
	<jsp:param value="panier" name="origine"/>
</jsp:include>
<div class="row">
	 <div class="span12">

	 
	<h1> Panier</h1><br>
	<c:choose>
    <c:when test="${nbArticles <= 0}">
       Votre panier est vide.
        <div class="row">
		  			
		<div class="span2">
			<a href="${boutique}" class="btn btn-primary ">Continuer votre shopping</a>
		</div>		  
					
        </div>
    </c:when>
    <c:otherwise>
       
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
								<td class=""><input type="checkbox" value="${ligne.getArticle().getIdArticle()}" name="optionsCheckbox"></td>
								<td class="muted center_text"><a href="${articleCont}${ligne.getArticle().getIdArticle()}"><img src="${imgDir}article${ligne.getArticle().getIdArticle()}_1.jpg"></a></td>
								<td>${ligne.getArticle().getNomArticle()}</td>
					
								<td>
									<input style ="height: 18px;padding-top:0px;padding-bottom:0px;" class="input-mini" type ="number" min="1" max="5" value="${ligne.getQteCommande()}" name="${ligne.getArticle().getIdArticle()}"/>
									<c:set var="indice" value="_${ligne.getArticle().getIdArticle()}"/>
									<span>${erreur["indice"]}</span>
								</td>
								<td>EUR ${ligne.getArticle().getPrixUnitTTCFormat()}</td>
								<td>EUR ${ligne.getTotalTTCFormat()} </td>
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
					<td><strong>EUR ${panierContent.getMontantTotalTTCFormat()}</strong></td>
				  </tr>		
				   <tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>Total HT</td>
					<td><strong>EUR ${panierContent.getMontantTotalHTFormat()}</strong></td>
				  </tr>		 			 
				   
				</tbody>
			  </table>
			 
			  
			 
			<fieldset>	  
		
	        <div class="row">
			  			<div class="span5">
			  				<input type="submit" class="btn btn-primary" value="Modifier le panier" name="updateCart"/>
						</div>		  
						<div class="span2">
							<a href="${boutique}" class="btn btn-primary ">Continuer votre shopping</a>
						</div>		  
						<div class="span5">
	            			<a href="${commandecont}" class="btn btn-primary pull-right">Passer la commande</a>
						</div>
	          		</div>
	        </fieldset>
	       </form>
      </c:otherwise>
</c:choose>
     

<%@include file="pied.jsp"%>

</body>
</html>


