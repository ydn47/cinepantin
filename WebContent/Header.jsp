<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:url var="jQuery" value="/_js/jquery-1.11.0.min.js" />
<c:url var="bootstjs" value="/_js/bootstrap.min.js" />
<c:url var="multiseljs" value="/_js/bootstrap_multiselect.js" />
<c:url var="valider" value="/_js/valider.js" />

<c:url var="normalize" value="/_css/normalize.css" />
<c:url var="boots" value="/_css/bootstrap.min.css" />
<c:url var="bootsiconlarge" value="/_css/bootstrap.icon-large.min.css" />
<c:url var="bootscloudfront" value="/_css/screen.css" />
<c:url var="jumbotron" value="/_css/jumbotron.css" />
<c:url var="dashboard" value="/_css/dashboard.css" />
<c:url var="multiselcss" value="/_css/bootstrap-multiselect.css" />
<c:url var="img" value="/_img" />

<link rel="stylesheet" href="${normalize}" />
<link rel="stylesheet" href="${boots}" />
<link rel="stylesheet" href="${bootsiconlarge}">
<link rel="stylesheet" href="${bootscloudfront}">
<link rel="stylesheet" href="${jumbotron}">

<script src="${jQuery}"></script>
<script src="${bootstjs}"></script>
<script src="${multiseljs}"></script>
<script src="${valider}"></script>


<c:url var="articleCont" value="/article/" />
<c:url var="boutique" value="/boutique" />
<c:url var="signin" value="/sign/in" />
<c:url var="signup" value="/sign/up" />
<c:url var="disconnect" value="/sign/disconnect" />
<c:url var="signmodif" value="/sign/editAccount" />
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function() {
			mutiselectCode();
		});
	</script>

	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${boutique}">CinePantin</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="${boutique}">Boutique</a></li>
					<li><a href="#about">Evènements</a></li>
					<li><a href="#about">A propos</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
				<ul class="nav secondary-nav">
					<c:choose>
						<c:when test="${msg != null}">
							<li><a href="${signmodif}"><i
									class="glyphicon glyphicon-user"></i> ${msg}</a></li>
							<li><a href="${disconnect}"><i
									class="glyphicon glyphicon-lock"></i> Déconexion</a></li>
						</c:when>
						<c:otherwise>

							<li><a href="${signin}"><i
									class="glyphicon glyphicon-lock"></i> Se connecter</a></li>
							<li><a href="${signup}">Créer un compte</a></li>
						</c:otherwise>
					</c:choose>
					<!--<li><a class="dropdown-toggle" href><i class="glyphicon glyphicon-shopping-cart"></i> Panier</a></li>-->
					<!-- Empty cart -->
					<li class="dropdown">
						<a href="cart.php" rel="nofollow" class="cart">
							Cart <span class="badge">0</span>
						</a>
						<div class="dropdown-menu cart-content">
							<p>You have no items in your shopping cart.</p>
						</div>
					</li>
					<!-- Not empty cart -->
							<li class="dropdown cart-not-empty">
								<a href="cart.php" rel="nofollow" class="cart"><i class="glyphicon glyphicon-shopping-cart"></i>
									Panier <span class="badge">2</span>
								</a>
								<div class="dropdown-menu cart-content">
									<form id="form-cart-mini" action="cart-step2.php" method="post" role="form">
										<table class="table table-cart-mini">
											<colgroup>
												<col width="70">
												<col>
												<col width="100">
											</colgroup>
											<tbody>
												<tr>
													<td class="image">
														<a href="product-details.php" class="thumbnail"><img src="img/product/1/118x85.png" alt="Product #1"></a>
													</td>
													<td class="product">
														<h3 class="name" style="margin:0"><a href="product-details.php">
															Product #1
														</a></h3>
														<a href="?item=1&amp;qty=0" class="btn btn-remove" data-tip="tooltip" data-title="Delete" data-original-title=""><i class="icon-trash"></i> <span>Remove</span></a>
													</td>
													<td class="unitprice text-center">
														<span class=="qty">2</span> X <span class="price" style="font-size:1em;">$50.00</span></div>
													</td>
												</tr>
												<tr>
													<td class="image">
														<a href="product-details.php" class="thumbnail"><img src="img/product/1/118x85.png" alt="Product #2"></a>
													</td>
													<td class="product">
														<h3 class="name" style="margin:0"><a href="product-details.php">
															Product with very long name #2
														</a></h3>
														<a href="?item=1&amp;qty=0" class="btn btn-remove" data-tip="tooltip" data-title="Delete" data-original-title=""><i class="icon-trash"></i> <span>Remove</span></a>
													</td>
													<td class="unitprice text-center">
														<span class=="qty">2</span> X <span class="price" style="font-size:1em;">$50.00</span></div>
													</td>
												</tr>
											</tbody>
											<tfoot>
												<tr >
													<td colspan="2" class="empty">
														<a href="cart.php" role="button" class="btn btn-default btn-sm"><span>View Cart</span></a>
														<button type="submit" name="checkout" class="btn btn-warning btn-sm"><span>Checkout</span></button>
													</td>
													<td class="total">
														<div class="total-price">
															<span class="price">$200.00</span>
														</div>
													</td>
												</tr>
											</tfoot>
										</table>
									</form>
								</div>
							</li>

				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<div id="menu">
			<div class="container">
				<form action="${boutique}" method="get">
					<div id="categories">


						<!--  						<a href="#" title="Sélectionnez une catégorie">Catégories</a>  -->
						<select id="example22" multiple="multiple" style="display: none"
							name="choixCategories">
							<c:forEach var="cat" items="${lstCategories}">
								<option value="${cat.getIdCategorie()}">${cat.getNomCategorie()}</option>
							</c:forEach>
						</select>

						<!-- 					<div class="dropdown_container"> -->
						<!-- 						<div class="categories"> -->
						<!-- 							<select id="example22" multiple="multiple" style="display: none"> -->
						<%-- 								<c:forEach var="cat" items="${lstCategories}"> --%>
						<%-- 									<option value="${cat.getNomCategorie()}">${cat.getDescriptionCategorie()}</option> --%>
						<%-- 								</c:forEach> --%>
						<!-- 							</select> -->
						<!-- 						</div> -->
						<!-- 					</div> -->
					</div>
					<div id="search">
						<input class="query" name="q" type="text"
							placeholder="Enter search terms" size="29" value="" id="query" required="required"> 
						<input id="searchForm"
							class="submit button" type="submit" value="Rechercher"
							name="search">
					</div>
				</form>
			</div>
		</div>
		<!-- /.container -->
	</div>
	<!-- /.menu -->

</body>
</html>