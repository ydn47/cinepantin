<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="entete.jsp"%>

 
		
	
<div class="row">

	<div class="span12">
		<ul class="breadcrumb">
			<li><a href="${boutique}">Accueil</a> <span class="divider">/</span></li>
			<li><a href="#">Compte</a> <span class="divider">/</span></li>
			<li class="active"><a href="#">Connexion</a></li>
		</ul>

		<div class="row">
			<div class="span9">
				<h1>Connexion au compte</h1>
			</div>
		</div>
		
		<hr>

		<div class="row">

			<div class="span5 well">
				<h2>Nouveau Client</h2>
				<p>En créant un compte sur notre boutique, vous serez en mesure de se déplacer à travers le processus de paiement plus rapide, stocker plusieurs adresses de livraison, consulter et suivre vos commandes dans votre compte et plus encore.</p><br>
				<a href="${signup}" class="btn btn-primary pull-right">Créer un compte</a>
			</div>	 		
			
			<div class="span5 well pull-right">
				<h2>Déja client</h2>
				<p>Si vous avez un compte, connectez-vous</p>

				<form action="${signin}" method="post">
					<fieldset>
						<div class="control-group">
							<label for="focusedInput" class="control-label">Email (login)</label>
							<div class="controls">
								<input class="input-xlarge focused" placeholder="Saisir votre login" id="username" name="email" value="" type="email" required autofocus />${erreur["email"] }
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Mot de passe</label>
							<div class="controls">
								<input  id="password" name="mdp" value="" type="password" placeholder="Saisir votre mdp" class="input-xlarge"  />${erreur["mp"] }
							</div>
						</div>

<!-- 						<button class="btn btn-primary pull-right" type="submit">Login</button> -->
						<input  class="btn btn-primary pull-right" type="submit" name="signin" value="Se connecter" />
						<p>${erreurCompte}</p>
					</fieldset>
				</form>
				
			</div>

		</div>
	</div>

</div>

<%@include file="pied.jsp"%>

</body>
</html>