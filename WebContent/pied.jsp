<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<footer>
	<hr>
	<div class="row well no_margin_left">

	<div class="span3">
		<h4>Information</h4>
		<ul>
			<li><a href="two-column.html">About Us</a></li>
			<li><a href="typography.html">Delivery Information</a></li>
			<li><a href="typography.html">Privacy Policy</a></li>
			<li><a href="typography.html">Terms &amp; Conditions</a></li>
		</ul>
	</div>
	<div class="span3">
		<h4>Customer Service</h4>
		<ul>
			<li><a href="contact.html">Contact Us</a></li>
			<li><a href="typography.html">Returns</a></li>
			<li><a href="typography.html">Site Map</a></li>
		</ul>
	</div>
	<div class="span3">
		<h4>Extras</h4>
		<ul>
			<li><a href="typography.html">Brands</a></li>
			<li><a href="typography.html">Gift Vouchers</a></li>
			<li><a href="typography.html">Affiliates</a></li>
			<li><a href="typography.html">Specials</a></li>
		</ul>
	</div>
	<div class="span2">
		<h4>My Account</h4>
		<ul>
			<li><a href="my_account.html">My Account</a></li>
			<li><a href="typography.html">Order History</a></li>
			<li><a href="typography.html">Wish List</a></li>
			<li><a href="typography.html">Newsletter</a></li>
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
