<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<script id="tinyhippos-injected">if (window.top.ripple) { window.top.ripple("bootstrap").inject(window, document); }</script><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Cine Pantin</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

<!--     Le styles -->
<!--     <link href="css/bootstrap.css" rel="stylesheet"> -->
<!--     <link id="switch_style" href="http://bootswatch.com//bootstrap.min.css" rel="stylesheet"> -->
<!--     <link href="css/main.css" rel="stylesheet"> -->
<!--     <link href="css/jquery.rating.css" rel="stylesheet"> -->
<!--     <link href="css/bootstrap-multiselect.css" rel="stylesheet"> -->
    
    <!-- StyleSheet -->
	<c:url var="normalize" value="/_css/normalize.css" />
	<c:url var="boots" value="/_css/bootstrap.min.css" />
	<c:url var="bootsrap" value="/css/bootstrap.css" />
	<c:url var="main" value="/css/main.css" />
	<c:url var="jqueryrating" value="/css/jquery.rating.css" />
	<c:url var="multiselect" value="/css/bootstrap-multiselect.css" />
	
	
<link rel="stylesheet" href="${normalize}" /> 
<%-- <link rel="stylesheet" href="${boots}" />  --%>
	<link rel="stylesheet" href="${bootsrap}">
	<link rel="stylesheet" href="${main}">
	<link rel="stylesheet" href="${jqueryrating}">	
	<link rel="stylesheet" href="${multiselect}" />

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

  <!-- Urls -->
	<c:url var="articleCont" value="/article/" scope="request"/>
	<c:url var="boutique" value="/boutique" scope="request"/>
	<c:url var="sign" value="/sign/" scope="request"/>
	<c:url var="signin" value="/sign/in" scope="request"/>
	<c:url var="signup" value="/sign/up" scope="request"/>
	<c:url var="disconnect" value="/sign/disconnect" scope="request"/>
	<c:url var="signmodif" value="/sign/editAccount" scope="request"/>
	<c:url var="paniercont" value="/panier" scope="request"/>
	<c:url var="commandecont" value="/commande" scope="request"/>
  	<c:url var="imgDir" value="/css/images/" scope="request"/>
  	<c:url var="categController" value="/articles/" scope="request"/>
  	<c:url var="contact" value="/contact" scope="request"/>
  </head>
 <body>

    <div class="container">
		<div class="row"><!-- start header -->
			<div class="span4 logo">
			<a href="${boutique}">
				<h1>CinePantin</h1>
			</a>
			</div>
			<div class="span8">
			
				<div class="row">
					<div class="span1">&nbsp;</div>
					<div class="span2">
						<h4>Devise</h4>
						<a href="#">EUR</a>
					</div>
					<div class="span2">
						<a href="${paniercont}"><h4>Panier</h4></a>
						<a href="${paniercont}">${nbArticles} article(s) - ${total} EUR</a>
					</div>					
					<div class="span3 customer_service">
						<h4>Livraison gratuite</h4>
						<h4><small>Service client: 0800 8475 548</small></h4>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="links pull-right">
						<a href="${boutique}">Acceuil</a> |
						<c:choose>
						<c:when test="${msg != null}">
							<a href="${signmodif}${param.origine}"> ${msg}</a> |
							<a href="${disconnect}${param.origine}">Déconexion</a></li> |
						</c:when>
						<c:otherwise>

							<a href="${sign}${param.origine}">Mon compte</a> |
						</c:otherwise>
					</c:choose>
					
						<a href="${paniercont}">Panier</a> 
						
					</div>
				
				</div>
			</div>
		</div><!-- end header -->
		
		<div class="row"><!-- start nav -->
			<div class="span12">
			  <div class="navbar">
					<div class="navbar-inner">
					  <div class="container" style="width: auto;">
						<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
						  <span class="icon-bar"></span>

						  <span class="icon-bar"></span>
						  <span class="icon-bar"></span>
						</a>
						<div class="nav-collapse">
						  <ul class="nav">
							<li><a href="${boutique}">Boutique</a></li>

							<li><a href="${boutique}">Evènements</a></li>
							<li><a href="about.jsp">About</a><li>
							<li><a href="${contact}">Contact</a><li>
			
						  </ul>
						  
						  	<ul class="nav pull-right">
						  
						   	<li class="divider-vertical"></li> 
						   	<form class="navbar-search" action="${boutique}" method="get">								
						   		<select  id="example22" multiple="multiple" style="display: none" name="choixCategories"> 
									<c:if test = '${not empty "${lstCategories}" }' >
										<c:forEach var="cat" items="${lstCategories}">
											<option value="${cat.getIdCategorie()}">${cat.getNomCategorie()}</option>
										</c:forEach>
									</c:if>							
								</select> 
								<input class="search-query span2" name="q" type="text" placeholder="Recherche"  value="" id="query" />  
								<input class="btn btn-primary btn-small search_btn" id="searchForm" type="submit" value="Ok" name="search"> 
						 	</form> 
						 </ul> 
							
							
						 
						</div><!-- /.nav-collapse -->
					  </div>
					</div><!-- /navbar-inner -->
				</div><!-- /navbar -->
			</div>
		</div><!-- end nav -->	 
	
