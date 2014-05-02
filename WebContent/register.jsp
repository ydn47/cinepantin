<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="entete.jsp"%>
<div class="row">

	<div class="span12">
		<ul class="breadcrumb">
			<li><a href="${boutique}">Home</a> <span class="divider">/</span></li>
			<li><a href="#">Account</a> <span class="divider">/</span></li>
			<li class="active"><a href="#">Créer un compte</a></li>
		</ul>
	</div>

	<div class="span12">
		<h1>Créer un compte</h1>

		<br>
		<form class="form-horizontal" action="${signup}" method="post">
			<fieldset>
				<div class="span6 no_margin_left">
					<legend>Vos détails personnels</legend>
					<div class="control-group">
						<label class="control-label">Prénom</label>
						<div class="controls docs-input-sizes">
							<input name="prenom" value="${prenom}" type="text" autofocus
								required class="span4" placeholder="">${erreur["prenom"] }
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Nom</label>
						<div class="controls docs-input-sizes">
							<input name="nom" value="${nom}" type="text" required
								class="span4" placeholder="">${erreur["nom"] }
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Email (login)</label>
						<div class="controls docs-input-sizes">
							<input name="email" value="${email}" class="span4" type="email" required>
							${erreur["email"] }
						</div>
					</div>

					<div class="control-group">
						<label class="control-label">Mot de passe</label>
						<div class="controls docs-input-sizes">
							<input class="span4" name="mdp" type="password" required>
							${erreur["mdp"] }
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Confirmation</label>
						<div class="controls docs-input-sizes">
						  <input class="span4"  name="mdp2" type="password" required>${erreur["mdp2"] }
						</div>
					  </div>

				</div>
				<div class="span6">
					<legend>Votre adresse </legend>
					<div class="control-group">
						<label class="control-label">Rue</label>
						<div class="controls docs-input-sizes">
							<input type="text" class="span4" name="adresse" value="${adresse}" required>
							${erreur["adresse"] }
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Code postal</label>
						<div class="controls docs-input-sizes">
							<input type="text" class="span4" name="cp" value="${cp}"required>
							${erreur["cp"] }
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Ville</label>
						<div class="controls docs-input-sizes">
							<input type="text" class="span4" name="ville" value="${ville}"required>
							${erreur["ville"] }
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Pays</label>
						<div class="controls docs-input-sizes">
							<input type="text" class="span4" name="pays" value="${pays}"required>
							${erreur["pays"] }
						</div>
					</div>
					<div class="control-group">
						<label class="control-label">Téléphone</label>
						<div class="controls docs-input-sizes">
							<input type="text" class="span4" value="${telephone}" name="telephone" required>${erreur["telephone"] }
						</div>
					</div>
				</div>


				<div class=" span12 no_margin_left">
					<hr>
					<div class="span8">
						<input type="checkbox" name="optionsCheckboxList1" value="option1" checked="checked">
						J'ai lu et j'accepte la politique de confidentialité<br>
						 <input type="checkbox" name="subscribe" value="1" checked="checked" >
						Inscrivez-moi à lanewsletter

					</div>
					<div class="span3">
						<input  class="btn btn-primary btn-large pull-right" type="submit"
											name="signup" value="Créer votre compte">
					</div>
					<hr>
				</div>
			</fieldset>
		</form>

	</div>

	<hr>



</div>





<%@include file="pied.jsp"%>

</body>
</html>