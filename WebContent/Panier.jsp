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
	 
        <table class="table table-bordered table-striped">
		  <thead>
			  <tr>
				<th>Remove</th>
				<th>Image</th>
				<th>Article</th>
				<th>Quantité</th>
				<th>Prix unitaire</th>
				<th>Total</th>
			  </tr>
			</thead>
			<tbody>
			  <tr>
				<td class=""><input type="checkbox" value="option1" id="optionsCheckbox"></td>
				<td class="muted center_text"><a href="product.html"><img src="css/images/macbook-pro.jpg"></a></td>
				<td>MacBook Pro</td>
				
				<td><input type="text" placeholder="1" class="input-mini"></td>
				<td>EUR 2,350.00</td>
				<td>EUR 2,350.00</td>
			  </tr>			  
			  <tr>
				<td class=""><input type="checkbox" value="option1" id="optionsCheckbox"></td>
				<td class="muted center_text"><a href="product.html"><img src="css/images/macbook-pro.jpg"></a></td>
				<td>MacBook Pro</td>
				
				<td><input type="text" placeholder="1" class="input-mini"></td>
				<td>EUR 2,350.00</td>
				<td>EUR 2,350.00</td>
			  </tr>	
			   <tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>Total HT</td>
				<td><strong>EUR 4,700.00</strong></td>
			  </tr>		 			 
			  <tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>Total TTC</td>
				<td><strong>EUR 4,700.00</strong></td>
			  </tr>		  
			</tbody>
		  </table>
		  
		  <form class="form-horizontal">
			<fieldset>	  
				<div class="row">
		  			<div class="span5">
		  				<input type="submit" class="btn primary" value="Mettre à jour" name="updateCart"/>
					</div>		  
					<div class="span2">
						<input type="submit" class="btn primary" value="Continuer votre shopping" name="retourBoutique"/>
					</div>		  
					<div class="span5">
            			<a href="checkout.html" class="btn primary pull-right">Passer la commande</a>
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