<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="entete.jsp"%>
	<div class="row">
		<%@include file="menuLeft.jsp"%>
        <div class="span9">

			<div id="myCarousel" class="carousel slide">
            <div class="carousel-inner">
              <div class="item active">
		<img width="700px" height="210px" src="${imgDir}carousel_4.jpg" alt="">
                <div class="carousel-caption">
                  <h4>First Thumbnail label</h4>
                  <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                </div>

              </div>
              <div class="item">
                <img src="${imgDir}carousel_2.jpg" alt="">
                <div class="carousel-caption">
                  <h4>Second Thumbnail label</h4>
                  <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                </div>
              </div>

              <div class="item">
		<img src="${imgDir}carousel_3.jpg" alt="">
                <div class="carousel-caption">
                  <h4>Third Thumbnail label</h4>
                  <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
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