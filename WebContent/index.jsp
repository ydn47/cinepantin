<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include page="entete.jsp">
	<jsp:param value="boutique" name="origine"/>
</jsp:include>
	<div class="row">
		<%@include file="menuLeft.jsp"%>
        <div class="span9">

			<div id="myCarousel" class="carousel slide">
            <div class="carousel-inner">
              <div class="item active">
				<img width="700px" height="210px" src="${imgDir}carousel_4.jpg" alt="">
                <div class="carousel-caption">
                  <h4>La Reine des Neiges</h4>
                  <p>Après RAIPONCE, découvrez cette année à Noël LA REINE DES NEIGES le nouveau film d'animation des Studios Disney, un conte alliant comédie, aventure et émotion dans la plus pure tradition.</p>
               </div>

              </div>
              <div class="item">
                <img src="${imgDir}carousel_2.jpg" alt="">
                <div class="carousel-caption">
                  <h4>Le Festival du Film de Colmar</h4>
                  <p>Le Festival du Film de Colmar vous propose, durant 7 jours, d'assister à des séances gratuites en présence d'acteurs, de réalisateurs ou de producteurs.</p>
                </div>
              </div>

              <div class="item">
		<img src="${imgDir}carousel_3.jpg" alt="">
                <div class="carousel-caption">
                  <h4>Cinéma d'été</h4>
                  <p>Parmi toutes les expositions en plein air que Rome offre, le Worldhotel Ripa Roma est fier d'être un partenaire officiel d'un événement historique, l'édition XX de Isola del Cinema qui se déroule dans le decor de l'île du Tibre.</p>
                </div>
              </div>
            </div>

            <a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">›</a>
          </div>
          </div>
		  
		  
		  
		<div class="span7 popular_products">
		 <h4>Sélection CINEPANTIN</h4><br>
		<ul class="thumbnails">
       		<c:if test="${empty lstArticles}">
				<p>
					Aucun résultat trouvé.
				<p>
			</c:if>
			<c:forEach var="article" items="${lstArticles}" varStatus="indexArticle">
				<li class="span2">
          			<div class="thumbnail">
            			<a href="${articleCont}${article.getIdArticle()}"><img width="150px" height ="123px" alt="" src="${imgDir}article${article.getIdArticle()}.jpg"></a>
            			<div class="caption">
              			<a href="${articleCont}${article.getIdArticle()}"> <h5>${article.getNomArticle()}</h5></a>  Prix: ${article.getPrixUnitTTCFormat()} EUR<br><br>
            			</div>
          			</div>
        		</li>
			</c:forEach>
 
      </ul>
		</div>
        <div class="span2">
		
		 <div class="roe">
		<h4>Newsletter</h4><br>
		<p>Inscrivez-vous à notre newsletter hebdomadaire et rester à jour avec les dernières offres.</p>
		
		    <form class="form-search">
    <input type="text" class="span2" placeholder="Saisir votre email"><br><br>
    <button type="submit" class="btn pull-right">S'inscrire</button>
    </form>
		</div><br><br>
            <a href="#"><img alt="" title="" src="${imgDir}paypal_mc_visa_amex_disc_150x139.gif"></a>
			<a href="#"><img alt="" src="${imgDir}bnr_nowAccepting_150x60.gif"></a>

		</div>
	  
      </div>





<%@include file="pied.jsp"%>

</body>
</html>