<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@include file="entete.jsp"%>
<div class="row">

	<div class="span3">
	<h2>Our location</h2>
	<h3>Address:</h3>
	<p>Your Store<br>Street address 1<br>Store Town<br>ZIP</p>	
	<div style="width:200px;height:200px"><iframe width="200" height="200" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="http://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=London@51.508129,-0.128005&amp;ie=UTF8&amp;z=12&amp;t=m&amp;iwloc=near&amp;output=embed"></iframe><br><table width="200" cellpadding="0" cellspacing="0" border="0"><tbody><tr><td align="left"><small><a href="http://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=London@51.508129,-0.128005&amp;ie=UTF8&amp;z=12&amp;t=m&amp;iwloc=near">View Larger Map</a></small></td><td align="right"><small></small></td></tr></tbody></table></div><br><br>
	<h3>Telephone:</h3>
	<p>1234-123-1234</p>
	</div>
	<div class="span9">
<div class="page-header">
    <h1>Contact us</h1>
  </div>

  <!-- Headings & Paragraph Copy -->
  <div class="row">
  
  
      <div class="span9">
      <form class="form-horizontal">
        <fieldset>
          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce non egestas massa. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Phasellus auctor, urna a pretium aliquam, enim tellus convallis dolor, eget semper sem risus placerat tortor.</p><br>
          <div class="control-group">
            <label for="focusedInput" class="control-label">First Name:</label>
            <div class="controls">
              <input type="text" placeholder="your first name" id="focusedInput" class="input-xlarge focused span6">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label">E-Mail Address:</label>
            <div class="controls">
              <input type="text" placeholder="your email" class="input-xlarge span6">
            </div>
          </div>
		  <div class="control-group">
            <label for="textarea" class="control-label">Enquiry:</label>
            <div class="controls">
              <textarea rows="3" id="textarea" placeholder="What would you like to contact us about?" class="input-xlarge span6"></textarea>
            </div>
          </div>

          <div class="span8">
				<button class="btn btn-primary pull-right" style="margin-right: 20px;" type="submit">Continue</button>
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