<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="Head.jsp"%>


<body style="padding-top: 100px">
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
												value="${nom}" type="text" autofocus required min="2">
											${erreur["nom"] } <span class="help-block">Peut
												contenir des lettres, des chiffres, tirets et caractères de
												soulignement, et doit être comprise entre 2 et 20
												caractères.</span>
										</div>
									</div>
									<div class="clearfix">
										<label for="isignup_username">Prénom:</label>
										<div class="input">
											<input id="isignup_username" tabindex="5" name="prenom"
												value="${prenom}" type="text" required>
											${erreur["prenom"] } <span class="help-block">Peut
												contenir des lettres, des chiffres, tirets et caractères de
												soulignement, et doit être comprise entre 2 et 20
												caractères.</span>
										</div>
									</div>
									<div class="clearfix">
										<label for="isignup_email">Email (login):</label>
										<div class="input">
											<input id="isignup_email" tabindex="6" name="email" value=""
												type="email" required> ${erreur["email"] } <span
												class="help-block"><strong>Tapez
													soigneusement.</strong> Vous recevrez un email de confirmation.</span>
										</div>
									</div>
									<div class="clearfix">
										<label for="isignup_password">Mot de passe</label>
										<div class="input">
											<input id="isignup_password" tabindex="7" name="mdp" value=""
												type="password" required> ${erreur["mdp"] } <span
												class="help-block">The longer the better. Include
												numbers for protein.</span>
										</div>
									</div>
									<div class="clearfix">
										<label for="isignup_adresse">Adresse</label>
										<div class="input">
											<input id="isignup_adresse" tabindex="8" name="adresse"
												value="" type="text" required> ${erreur["adresse"] }
											<span class="help-block">Indiquez votre adresse.</span>
										</div>
									</div>
									<div class="clearfix">
										<label for="isignup_ville">Ville</label>
										<div class="input">
											<input id="isignup_ville" tabindex="9" name="ville"
												value="" type="text" required> ${erreur["ville"] } <span
												class="help-block">Indiquez votre ville.</span>
										</div>
									</div>
									<div class="clearfix">
										<label for="isignup_codepostal">Code postal</label>
										<div class="input">
											<input id="isignup_codepostal" tabindex="10" name="codepostal"
												value="" type="text" required> ${erreur["codepostal"] } <span
												class="help-block">Indiquez votre code postal.</span>
										</div>
									</div>
									<div class="clearfix">
										<label for="isignup_pays">Pays</label>
										<div class="input">
											<input id="isignup_pays" tabindex="11" name="pays"
												value="" type="text" required> ${erreur["pays"] } <span
												class="help-block">Indiquez votre pays.</span>
										</div>
									</div>
									<div class="clearfix">
										<label for="isignup_tel">Téléphone</label>
										<div class="input">
											<input id="isignup_tel" tabindex="12" name="tel"
												value="" type="tel" required> ${erreur["tel"] } <span
												class="help-block">Indiquez votre téléphone.</span>
										</div>
									</div>
									<div class="clearfix">
										<p class="clickedit">
											En cliquant sur le bouton "Créer votre compte" ci-dessous,
											vous certifiez que vous avez lu et acceptez <a href="/terms"
												title="Terms of use" target="_blank">nos conditions
												d'utilisation</a> et <a href="/privacy" title="Privacy policy"
												target="_blank">notre politique de confidentialité.</a>.
										</p>
									</div>
									<div class="clearfix">
										<div class="input">
											<ul class="inputs-list">
												<li><label> <input id="isignup_subscribe"
														tabindex="8" type="checkbox" name="subscribe" value="1"
														checked="checked"><span>Inscrivez-moi à la
															newsletter</span>
												</label></li>
											</ul>
										</div>
									</div>
									<div class="actions">
										<input tabindex="9" class="btn success large" type="submit"
											name="signup" value="Créer votre compte">
									</div>
								</fieldset>
							</form>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<hr>
	<%@include file="Footer.jsp"%>
</body>
</html>