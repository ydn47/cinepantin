<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<footer>
	<hr>
	<div class="row well no_margin_left">

	<div class="span3">
		<h4>Information</h4>
		<ul>
			<li><a href="about.jsp">À propos de nous</a></li>
			<li><a href="${contact}">Informations sur la livraison</a></li>
			<li><a href="${contact}">Politique de confidentialité</a></li>
			<li><a href="${contact}">Conditions Générales</a></li>
		</ul>
	</div>
	<div class="span3">
		<h4>Service client</h4>
		<ul>
			<li><a href="${contact}">Contactez-nous</a></li>
			<li><a href="${contact}">Retour</a></li>
			<li><a href="${contact}">Plan du site</a></li>
		</ul>
	</div>
	<div class="span3">
		<h4>Extras</h4>
		<ul>
			<li><a href="${contact}">Marques</a></li>
			<li><a href="${contact}">Les chèques-cadeaux</a></li>
			<li><a href="${contact}">Affiliés</a></li>
			<li><a href="${contact}">Promotions</a></li>
		</ul>
	</div>
	<div class="span2">
		<h4>Mon compte</h4>
		<ul>
			<c:choose>
				<c:when test="${msg != null}">
					<li><a href="${signmodif}">Mon compte</a></li> 
				</c:when>
				<c:otherwise>
					<li><a href="${sign}">Mon compte</a></li>
				</c:otherwise>
			</c:choose>
			<!--  <li><a href="my_account.html">Mon compte</a></li>-->
			<li><a href="${contact}">Historique des commandes</a></li>
			<li><a href="${contact}">Newsletter</a></li>
		</ul>
	</div>

</div>
</footer>
</div> <!-- /container -->
<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
	<c:url var="jQuery" value="/_js/jquery-1.11.0.min.js" />
	<c:url var="bootstjs" value="/_js/bootstrap.min.js" />
	<c:url var="multiseljs" value="/_js/bootstrap_multiselect.js" />
	<c:url var="ratingpack" value="/_js/jquery.rating.pack.js" />
	<c:url var="valider" value="/_js/valider.js" />
	
	<script src="${jQuery}"></script>
	<script src="${bootstjs}"></script>
	<script src="${multiseljs}"></script>
	<script src="${valider}"></script>

	<script src="${ratingpack}"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			mutiselectCode();
		});
	</script>

<script>
$(function() {
	$('#theme_switcher ul li a').bind('click',
		function(e) {
			$("#switch_style").attr("href", "http://bootswatch.com/"+$(this).attr('rel')+"/bootstrap.min.css");    		
			return false;
		}
	);
});
</script>


<div id="cacaowebchromeextension"></div><script type="text/javascript">var Cacaoweb = { callbackIsRunning: function () { var cacaodiv = document.createElement("div"); cacaodiv.id = "cacaorunning"; document.body.appendChild(cacaodiv); } };</script><script id="isrunning" src="http://127.0.0.1:4001/isrunning" type="text/javascript"></script>
