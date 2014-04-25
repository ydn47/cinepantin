<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="Head.jsp"%>

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
	
<%-- 	src="${img}/germinal.jpg"> --%>
<div class="container">
	<div class="row featurette">
		<p id="succes">Il y a actuellement  :${nbvisiteurs} utilisateur(s) connecté(s)</p>
        <div class="col-md-5">
          <img class="featurette-image img-responsive" data-src="holder.js/500x500/auto" alt="500x500" 
          src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSI1MDAiIGhlaWdodD0iNTAwIj48cmVjdCB3aWR0aD0iNTAwIiBoZWlnaHQ9IjUwMCIgZmlsbD0iI2VlZSI+PC9yZWN0Pjx0ZXh0IHRleHQtYW5jaG9yPSJtaWRkbGUiIHg9IjI1MCIgeT0iMjUwIiBzdHlsZT0iZmlsbDojYWFhO2ZvbnQtd2VpZ2h0OmJvbGQ7Zm9udC1zaXplOjMxcHg7Zm9udC1mYW1pbHk6QXJpYWwsSGVsdmV0aWNhLHNhbnMtc2VyaWY7ZG9taW5hbnQtYmFzZWxpbmU6Y2VudHJhbCI+NTAweDUwMDwvdGV4dD48L3N2Zz4=">
        </div>
        <div class="col-md-7">
          <h2 class="featurette-heading">${articleObject.getNomArticle()}
         
          <span class="text-muted">${articleObject.getPrixUnitArticle()}</span></h2>
          <p class="lead">${articleObject.getShortDescArticle()}</p>
          <p class="lead">${articleObject.getLongDescArticle()}</p>
       
	        <form class="form-inline" role="form" method="post" action="${paniercont}" id="form-product-details">
				<!-- Hidden fields -->
				<div class="hidden">
					<input type="hidden" value="${articleObject.getIdArticle()}" name="productId">
				</div>
	
  				<div class="form-group">
  				
    				<label for="quantity">Quantité</label>
    				<input type="number" required min="1" max="5" value="1" class="form-control" id="quantity" name="quantity" size ="10" />
  				</div>
  				<input tabindex="3" class="btn primary large" type="submit" name="addCart" value="Ajouter au panier" />		
  				
			</form>
			 
       </div>
	</div>
    <h2 class="sub-header">Détails sur le produit</h2>
    <div class="table-responsive">
       <table class="table table-striped">
         <thead>
           <tr>
             <th>#</th>
             <th>Header</th>
             <th>Header</th>
             <th>Header</th>
             <th>Header</th>
           </tr>
         </thead>
         <tbody>
           <tr>
             <td>1,001</td>
             <td>Lorem</td>
             <td>ipsum</td>
             <td>dolor</td>
             <td>sit</td>
           </tr>
           <tr>
             <td>1,002</td>
             <td>amet</td>
             <td>consectetur</td>
             <td>adipiscing</td>
             <td>elit</td>
           </tr>
           
         </tbody>
       </table>
     </div>
</div>  

	<hr>

	<%@include file="Footer.jsp"%>
</body>
</html>      