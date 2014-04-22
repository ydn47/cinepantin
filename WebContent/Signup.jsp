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

<c:url var = "signup"  value="/sign/up"/>	
</head>
<body>
	<%@include file="Header.jsp"%>
	<div id="page_signin">
		<div class="page-header-top">
			<div class="container">
				<h1>Créer un compte</h1>
			</div>
		</div>
		<div class="container">
			<div class="content">
				<div class="row">
					<div class="span16">


						<div id="signup">
							<div class="title">Créer un compte</div>
							<form action="${signup}" method="post" class="form-stacked">
								<fieldset>
									<div class="clearfix">
										<label for="isignup_username">Nom:</label>
										<div class="input">
											<input id="isignup_username" tabindex="5" name="nom"
												label="Username" value="" type="text"> <span
												class="help-block">May contain letters, digits,
												dashes and underscores, and should be between 2 and 20
												characters long.</span>
										</div>
									</div>
									<div class="clearfix">
										<label for="isignup_username">Prénom:</label>
										<div class="input">
											<input id="isignup_username" tabindex="5" name="prenom"
												label="Username" value="" type="text"> <span
												class="help-block">May contain letters, digits,
												dashes and underscores, and should be between 2 and 20
												characters long.</span>
										</div>
									</div>
									<div class="clearfix">
										<label for="isignup_email">Email (login):</label>
										<div class="input">
											<input id="isignup_email" tabindex="6" name="email"
												label="Email address" value="" type="text"> <span
												class="help-block"><strong>Type carefully.</strong>
												You will be sent a confirmation email.</span>
										</div>
									</div>
									<div class="clearfix">
										<label for="isignup_password">Mot de passe</label>
										<div class="input">
											<input id="isignup_password" tabindex="7" name="password"
												label="Password" value="" type="password"> <span
												class="help-block">The longer the better. Include
												numbers for protein.</span>
										</div>
									</div>
									<div class="clearfix">
										<p class="clickedit">
											By clicking on the "Create your account" button below, you
											certify that you have read and agree to our <a href="/terms"
												title="Terms of use" target="_blank">terms of use</a> and <a
												href="/privacy" title="Privacy policy" target="_blank">privacy
												policy</a>.
										</p>
									</div>
									<div class="clearfix">
										<div class="input">
											<ul class="inputs-list">
												<li><label><input id="isignup_subscribe"
														tabindex="8" type="checkbox" name="subscribe"
														label="Subscribe" value="1" checked="checked"><span>Sign
															me up for the newsletter (provided by MailChimp)</span></label></li>
											</ul>
										</div>
									</div>
									<div class="actions">
										<input tabindex="9" class="btn success large" type="submit" name="signup"
											value="Créer votre compte">
									</div>
								</fieldset>
							</form>
						</div>
						<script>
							$("#iusername").focus();
						</script>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="Footer.jsp"%>
</body>
</html>