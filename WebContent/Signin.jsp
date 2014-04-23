<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:url var="jQuery" value="/_js/libs/jquery-1.10.2.min.js" />
<c:url var="bootstjs" value="/_js/bootstrap.min.js" />

<c:url var="normalize" value="/_css/normalize.css" />
<c:url var="boots" value="/_css/bootstrap.min.css" />
<c:url var="bord" value="/_css/dashboard.css" />
<c:url var="starter" value="/_css/starter-template.css" />
<c:url var="starter" value="/_css/jumbotron.css" />


<c:url var="urlAdd" value="/dvd/add" />
<link rel="stylesheet" href="${bord}">
<link rel="stylesheet" href="${normalize}" />
<link rel="stylesheet" href="${boots}" />
<%-- 	<link href="${starter}" rel="stylesheet"> --%>
<link href="${jumbotron}" rel="stylesheet">
<link rel="stylesheet" type="text/css" media="screen"
	href="//d85wutc1n854v.cloudfront.net/live/css/screen.css?buster-140319-2">
	
<c:url var = "signin"  value="/sign/in"/>	
<c:url var = "reset"  value="/sign/reset"/>	
</head>
<body>
	<%@include file="Header.jsp"%>
	<div id="page_signin">
		<div class="page-header-top">
			<div class="container">
				<h1>Se connecter</h1>
			</div>
		</div>
		<div class="container">
			<div class="content">
				<div class="row">
					<div class="span16">
						<div id="signin">
							<div class="title">Déja client? Se connecter:</div>
							<form action="${signin}" method="post">
								<input type="hidden" name="next" value="/">
								<fieldset>
									<div class="clearfix">
										<label for="iusername"><span>Email (login):</span></label>
										<div class="input">
											<input tabindex="1" id="iusername" name="email" value="" type="email" required autofocus />
										</div>
									</div>
									<div class="clearfix">
										<label for="ipassword"><span>Mot de passe:</span></label>
										<div class="input">
											<input tabindex="2" id="ipassword" name="mdp" value="" type="password" required />
										</div>
									</div>

									<div class="actions">
										<input tabindex="3" class="btn primary large" type="submit" name="signin" value="Se connecter" />
										<p class="reset">
											 <a tabindex="4" href="${reset}" title="Mot de passe oublié">Mot de passe oublié</a>
										</p>
									</div>
								</fieldset>
							</form>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="Footer.jsp"%>
</body>
</html>