<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="Head.jsp"%>


<body style="padding-top: 100px">
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
	<hr>
	<%@include file="Footer.jsp"%>
</body>
</html>