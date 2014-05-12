<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="entete.jsp"%>
<div class="row">
<%@include file="menuLeft.jsp"%>
	<div class="span9">
		<ul class="breadcrumb">
		    <li>
		    	<a href="#">Home</a> <span class="divider">/</span>
		    </li>
		    <li>
		    	<a href="listings.jsp">${nomCateg}</a> <span class="divider">/</span>
		    </li>
	    </ul>
  
  <c:forEach items="${articlesObject}" var="article">
  <div class="row">
	 <div class="span1">
	  <a href="${articleCont}${article.getIdArticle()}"><img alt="" id="tmp" src="css/images/ipodtouch_image2_20080909.jpg"></a>
	  </div>	 
	 
	  <div class="span6">
	   <a href="${articleCont}${article.getIdArticle()}"><h5>${article.getNomArticle()}</h5></a>
              <p>${article.getShortDescArticle()}</p>
	  </div>	

	  <div class="span1">
	   <p>${article.getPrixUnitTTCFormat()} &euro;</p>
	  </div>	 
	  
	  <div class="span2">
	   		<p>
	   			<a class="btn btn-primary" href="${articleCont}${article.getIdArticle()}">Voir Détails</a> 
	   		</p>
	  </div>
  </div>
  <hr>
   </c:forEach>


	  
	  
	      <div class="pagination">
    <ul>
    <li><a href="#">Précédent</a></li>
    <li class="active">
    <a href="#">1</a>
    </li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">Suivant</a></li>
    </ul>
    </div>
	  
		</div>

      </div>
      
 <%@include file="pied.jsp"%>

</body>
</html>     