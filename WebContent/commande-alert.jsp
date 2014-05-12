<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="entete.jsp"%>

  <!-- Headings & Paragraph Copy -->
  <div class="row">
     <div class="span3">
		<h2>Notre magasin</h2>
		<h3>Adresse:</h3>
		<p>CinePantin<br>32 rue de l'arcade<br>75009 Paris<br>FRANCE</p>	
		<div style="width:200px;height:200px">
			<iframe width="200" height="200" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=London@51.508129,-0.128005&amp;ie=UTF8&amp;z=12&amp;t=m&amp;iwloc=near&amp;output=embed"></iframe>
			<br>
			<table width="200" cellpadding="0" cellspacing="0" border="0">
				<tbody>
					<tr><td align="left"><small><a href="http://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=London@51.508129,-0.128005&amp;ie=UTF8&amp;z=12&amp;t=m&amp;iwloc=near">View Larger Map</a></small></td><td align="right"><small></small></td></tr>
				</tbody>
			</table>
		</div>
		<br><br>
		<h3>Téléphone:</h3>
		<p>09 62 33 00 44</p>
	</div>
	<div class="span9">
		<div class="page-header">
    		<h1>Votre commande</h1>
  		</div>

  		<!-- Headings & Paragraph Copy -->
  		<div class="row">
  
  
	      <div class="span9">
	     
	          <p> Désolé, votre commande ne peut aboutir !</p>
	          <br>
	          <p>${msgErreurStock}</p>
	          <p></p>
	         
	    	</div>

  	</div><!-- /row -->
</div>

</div>
<%@include file="pied.jsp"%>

</body>
</html>		