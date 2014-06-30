<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<jsp:include page="entete.jsp">
	<jsp:param value="contact" name="origine"/>
</jsp:include>
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
    <h1>Contactez-nous</h1>
  </div>

  <!-- Headings & Paragraph Copy -->
  <div class="row">
  
  
      <div class="span9">
      <form class="form-horizontal" action="${contact}" method="post">
        <fieldset>
          <p>CinePAntin : Vente en ligne des Livres, dvd et articles de cinéma pour toutes les générations...</p><br>
          <div class="control-group">
            <label for="focusedInput" class="control-label">Nom et Prénom:</label>
            <div class="controls">
              <input type="text" placeholder="votre nom" id="focusedInput" class="input-xlarge focused span6" required name="nom">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label">Adresse email :</label>
            <div class="controls">
              <input type="email" placeholder="votre email" class="input-xlarge span6" required name="email">
            </div>
          </div>
		  <div class="control-group">
            <label for="textarea" class="control-label">Demande:</label>
            <div class="controls">
              <textarea rows="3" id="textarea" placeholder="A quel sujet souhaitez-vous nous contacter?" class="input-xlarge span6" required name="demande"></textarea>
            </div>
          </div>

          <div class="span8">
          		<input class="btn btn-primary pull-right" style="margin-right: 20px;" type="submit"  name="envoyer" value="Envoyer" />
          </div>
        </fieldset>
      </form>

    </div>
  
  

  <!-- Misc Elements -->
  
  </div><!-- /row -->

	</div>

</div>
<%@include file="pied.jsp"%>

</body>
</html>