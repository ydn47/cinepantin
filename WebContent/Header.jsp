<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:url var="jQuery"           value="/_js/libs/jquery-1.10.2.min.js" />
<c:url var="bootstjs"         value="/_js/bootstrap.min.js" />
<c:url var="normalize"        value="/_css/normalize.css" />
<c:url var="boots"            value="/_css/bootstrap.min.css" />
<c:url var="bootsiconlarge"   value="/_css/bootstrap.icon-large.min.css" />
<c:url var="bootscloudfront"  value="/_css/screen.css" />
<c:url var="img"              value="/_img" />

<link rel="stylesheet" href="${normalize}" />
<link rel="stylesheet" href="${boots}" />
<link rel="stylesheet" href="${bootsiconlarge}" >
<link rel="stylesheet" href="${bootscloudfront}">

<c:url var = "boutique"  value="/boutique"/>
<c:url var = "signin"  value="/sign/in"/>
<c:url var = "signup"  value="/sign/up"/>
<c:url var = "disconnect"  value="/sign/disconnect"/>
<c:url var = "signmodif"  value="/sign/editAccount"/>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">CinePantin</a>
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
  							<li><a class="dropdown-toggle" href="${signmodif}"><i class="glyphicon glyphicon-user"></i> ${msg}</a></li>
    						<li><a class="dropdown-toggle"  href="${disconnect}"><i class="glyphicon glyphicon-lock"></i> Déconexion</a></li>
  						</c:when>
  						<c:otherwise>
  							
  							<li ><a class="dropdown-toggle" href="${signin}"><i class="glyphicon glyphicon-lock"></i> Se connecter</a></li>
							<li ><a  class="dropdown-toggle" href="${signup}">Créer un compte</a></li>
  						</c:otherwise>
					</c:choose>
				<li><a class="dropdown-toggle href="${signmodif}"><i class="glyphicon glyphicon-shopping-cart"></i> Panier</a></li>
					
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
		<div id="menu">
			<div class="container">
				<div id="categories">
					<div class="category_button">
						<a href="#" title="Sélectionnez une catégorie">Catégories</a>
					</div>
					<div class="dropdown_container">
						<div class="categories">
							<ul>
								<li><a href="/themes/admin"
									title="Admin, dashboard, and other backend themes">Admin
										&amp; Dashboards <span>&nbsp;</span>
								</a></li>
								<li><a href="/themes/landing-pages"
									title="Landing page themes">Landing Pages <span>&nbsp;</span></a></li>
								<li><a href="/themes/business"
									title="Business and corporate themes">Business &amp;
										Corporate <span>&nbsp;</span>
								</a></li>
								<li><a href="/themes/portfolios" title="Portfolio themes">Portfolios
										<span>&nbsp;</span>
								</a></li>
								<li><a href="/themes/resumes-cv"
									title="Resume and Curriculum Vitae (CV) themes">Resumes
										&amp; CV <span>&nbsp;</span>
								</a></li>
								<li><a href="/themes/e-commerce"
									title="E-Commerce and shopping themes">E-Commerce <span>&nbsp;</span></a></li>
								<li><a href="/themes/components" title="Theme components">Components
										<span>&nbsp;</span>
								</a></li>
								<li><a href="/themes/blogs-magazines"
									title="Blog and magazine themes">Blogs &amp; Magazines <span>&nbsp;</span></a></li>
								<li><a href="/themes/wordpress"
									title="Bootstrap WordPress themes">WordPress <span>&nbsp;</span></a></li>
								<li><a href="/themes/other" title="Miscellaneous themes">Other
										<span>&nbsp;</span>
								</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div id="search">
					<form action="/search" method="get">
						<input class="query" name="q" type="text"
							placeholder="Enter search terms" size="29" value=""><input
							class="submit button" type="submit" value="">
					</form>
				</div>

			</div>
		</div>
	</div>
	<!-- /.navbar -->
</body>
</html>