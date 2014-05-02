<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="entete.jsp"%>
<div class="row">
		 <div class="span12">
		     <ul class="breadcrumb">
    <li>
    <a href="${boutique}">Home</a> <span class="divider">/</span>
    </li>
    <li>
    <a href="${paniercont}">Panier</a> <span class="divider">/</span>
    </li>
    <li class="active">
    <a href="/">Paiement</a>
    </li>
    </ul>
	
	
	  	 <div class="row">
	 <div class="span12">
	 
    
		            <div id="accordion2" class="accordion">
            <div class="accordion-group">
              <div class="accordion-heading">
                <a href="#collapseOne" data-parent="#accordion2" data-toggle="collapse" class="accordion-toggle">
                  <h3>Etape 1: Identifiez-vous</h3>
                </a>
              </div>
              <div class="accordion-body collapse in" id="collapseOne">
                <div class="accordion-inner">
				  
				  <div class="span6 no_margin_left">
				<h4>Nouveau client</h4>
				<p>En créant un compte, vous pourrez commander plus vite, d'être à jour sur le statut de votre commande et de garder trace des commandes que vous avez déjà faites.</p>

				<form class="">
					<fieldset>
						<input type="radio" name="optionsCheckboxList1" value="option1"> Register Account <br>
						<input type="radio" name="optionsCheckboxList1" value="option2"> Guest Checkout <br><br><br><br><br>
					  	<a data-parent="#collapse2" data-toggle="collapse" href="#collapse2" class="btn btn-primary pull-right">Continue</a>

					</fieldset>
				</form>
				  </div>
				<div class="span5">
				<h4>Registered Customers</h4>
				<p>If you have an account with us, please log in.</p>

				<form class="">
					<fieldset>
						<div class="control-group">
							<label class="control-label" for="focusedInput">Username</label>
							<div class="controls">
							<input type="text" class="input-xlarge focused" id="username" placeholder="Enter your username" style="background-image: url(&quot;data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAASCAYAAABSO15qAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH3QsPDhss3LcOZQAAAU5JREFUOMvdkzFLA0EQhd/bO7iIYmklaCUopLAQA6KNaawt9BeIgnUwLHPJRchfEBR7CyGWgiDY2SlIQBT/gDaCoGDudiy8SLwkBiwz1c7y+GZ25i0wnFEqlSZFZKGdi8iiiOR7aU32QkR2c7ncPcljAARAkgckb8IwrGf1fg/oJ8lRAHkR2VDVmOQ8AKjqY1bMHgCGYXhFchnAg6omJGcBXEZRtNoXYK2dMsaMt1qtD9/3p40x5yS9tHICYF1Vn0mOxXH8Uq/Xb389wff9PQDbQRB0t/QNOiPZ1h4B2MoO0fxnYz8dOOcOVbWhqq8kJzzPa3RAXZIkawCenHMjJN/+GiIqlcoFgKKq3pEMAMwAuCa5VK1W3SAfbAIopum+cy5KzwXn3M5AI6XVYlVt1mq1U8/zTlS1CeC9j2+6o1wuz1lrVzpWXLDWTg3pz/0CQnd2Jos49xUAAAAASUVORK5CYII=&quot;); background-repeat: no-repeat; background-attachment: scroll; background-position: right center;" autocomplete="off">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Password</label>
							<div class="controls">
							<input type="password" class="input-xlarge" id="password" placeholder="Enter your password" style="background-image: url(&quot;data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAASCAYAAABSO15qAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH3QsPDhss3LcOZQAAAU5JREFUOMvdkzFLA0EQhd/bO7iIYmklaCUopLAQA6KNaawt9BeIgnUwLHPJRchfEBR7CyGWgiDY2SlIQBT/gDaCoGDudiy8SLwkBiwz1c7y+GZ25i0wnFEqlSZFZKGdi8iiiOR7aU32QkR2c7ncPcljAARAkgckb8IwrGf1fg/oJ8lRAHkR2VDVmOQ8AKjqY1bMHgCGYXhFchnAg6omJGcBXEZRtNoXYK2dMsaMt1qtD9/3p40x5yS9tHICYF1Vn0mOxXH8Uq/Xb389wff9PQDbQRB0t/QNOiPZ1h4B2MoO0fxnYz8dOOcOVbWhqq8kJzzPa3RAXZIkawCenHMjJN/+GiIqlcoFgKKq3pEMAMwAuCa5VK1W3SAfbAIopum+cy5KzwXn3M5AI6XVYlVt1mq1U8/zTlS1CeC9j2+6o1wuz1lrVzpWXLDWTg3pz/0CQnd2Jos49xUAAAAASUVORK5CYII=&quot;); background-repeat: no-repeat; background-attachment: scroll; background-position: right center;" autocomplete="off">
							</div>
						</div>

											  	<a href="#collapse2" class="btn btn-primary pull-right">Continue</a>

					</fieldset>
				</form>
				  </div>
				  
				  
                </div>
              </div>
            </div>

		<div class="accordion-group">
			<div class="accordion-heading">
				<a href="#collapse2" data-parent="#accordion2" data-toggle="collapse" class="accordion-toggle">
					<h3>Etape 2: Adresse</h3>
				</a>
			</div>
			<div class="accordion-body collapse" id="collapse2">
				<div class="accordion-inner">
										<div class="span6 no_margin_left">
						<legend>Your Personal Details</legend>
					  <div class="control-group">
						<label class="control-label">First Name</label>
						<div class="controls docs-input-sizes">
						  <input type="text" class="span4" placeholder="">
						</div>
					  </div>
					  <div class="control-group">
						<label class="control-label">Last Name</label>
						<div class="controls docs-input-sizes">
						  <input type="text" class="span4" placeholder="">
						</div>
					  </div>					  
					  <div class="control-group">
						<label class="control-label">Email Address</label>
						<div class="controls docs-input-sizes">
						  <input type="text" class="span4" placeholder="">
						</div>
					  </div>					 

					  <div class="control-group">
						<label class="control-label">Telephone</label>
						<div class="controls docs-input-sizes">
						  <input type="text" class="span4" placeholder="">
						</div>
					  </div>
					  </div>
					  <div class="span5">
					<legend>Your Address </legend>
					  <div class="control-group">
						<label class="control-label">Address 1</label>
						<div class="controls docs-input-sizes">
						  <input type="text" class="span4" placeholder="">
						</div>
					  </div>
					  <div class="control-group">
						<label class="control-label">Address 2</label>
						<div class="controls docs-input-sizes">
						  <input type="text" class="span4" placeholder="">
						</div>
					  </div>					  <div class="control-group">
						<label class="control-label">City</label>
						<div class="controls docs-input-sizes">
						  <input type="text" class="span4" placeholder="">
						</div>
					  </div>
					  <div class="control-group">
						<label class="control-label">ZIP</label>
						<div class="controls docs-input-sizes">
						  <input type="text" class="span4" placeholder="">
						</div>
					  </div>					  <div class="control-group">
						<label class="control-label">Country</label>
						<div class="controls docs-input-sizes">
							<select class="span4">
							<option>United Kingdom</option>
							<option>United States</option>
							</select>
						</div>
					  </div>
					  </div>
					  <div class="span11 no_margin_left">
					  <br><a href="#collapse3" class="btn btn-primary pull-right">Continue</a><br><br><br>
					    </div>
				</div>

			</div>
		</div>
			
			
		<div class="accordion-group">
			<div class="accordion-heading">
				<a href="#collapse3" data-parent="#accordion2" data-toggle="collapse" class="accordion-toggle">
					<h3>Etape 3: Détails de livraison</h3>
				</a>
			</div>
			<div class="accordion-body collapse" id="collapse3">
<div class="accordion-inner">
										<div class="span6 no_margin_left">
						<legend>Your Personal Details</legend>
					  <div class="control-group">
						<label class="control-label">First Name</label>
						<div class="controls docs-input-sizes">
						  <input type="text" class="span4" placeholder="">
						</div>
					  </div>
					  <div class="control-group">
						<label class="control-label">Last Name</label>
						<div class="controls docs-input-sizes">
						  <input type="text" class="span4" placeholder="">
						</div>
					  </div>					  
					  <div class="control-group">
						<label class="control-label">Email Address</label>
						<div class="controls docs-input-sizes">
						  <input type="text" class="span4" placeholder="">
						</div>
					  </div>					 

					  <div class="control-group">
						<label class="control-label">Telephone</label>
						<div class="controls docs-input-sizes">
						  <input type="text" class="span4" placeholder="">
						</div>
					  </div>
					  </div>
					  <div class="span5">
					<legend>Your Address </legend>
					  <div class="control-group">
						<label class="control-label">Address 1</label>
						<div class="controls docs-input-sizes">
						  <input type="text" class="span4" placeholder="">
						</div>
					  </div>
					  <div class="control-group">
						<label class="control-label">Address 2</label>
						<div class="controls docs-input-sizes">
						  <input type="text" class="span4" placeholder="">
						</div>
					  </div>					  <div class="control-group">
						<label class="control-label">City</label>
						<div class="controls docs-input-sizes">
						  <input type="text" class="span4" placeholder="">
						</div>
					  </div>
					  <div class="control-group">
						<label class="control-label">ZIP</label>
						<div class="controls docs-input-sizes">
						  <input type="text" class="span4" placeholder="">
						</div>
					  </div>					  <div class="control-group">
						<label class="control-label">Country</label>
						<div class="controls docs-input-sizes">
							<select class="span4">
							<option>United Kingdom</option>
							<option>United States</option>
							</select>
						</div>
					  </div>
					  </div>
					  					  <div class="span11 no_margin_left">
					  <br><a href="#collapse3" class="btn btn-primary pull-right">Continue</a><br><br><br>
					    </div>
				</div>
			</div>
		</div>
			
			
					<div class="accordion-group">
			<div class="accordion-heading">
				<a href="#collapse4" data-parent="#accordion2" data-toggle="collapse" class="accordion-toggle">
					<h3>Etape 4: Paiement</h3>
				</a>
			</div>
			<div class="accordion-body collapse" id="collapse4">
				<div class="accordion-inner">
											<input type="radio" name="payment1" value="option1"> Collect in store<br>
						<input type="radio" name="payment1" value="option2"> Paypal<br>
						<input type="radio" name="payment1" value="option2"> Google checkout<br><br>
<div class="control-group">
            <label class="control-label" for="textarea">Comments</label>
            <div class="controls">
              <textarea class="input-xlarge span11" id="textarea" rows="3"></textarea>
            </div>
          </div>
					  <div class="span11 no_margin_left">
					  <br><a href="#collapse3" class="btn btn-primary pull-right">Confirm order</a><br><br><br>
					    </div>				</div>
			</div>
		</div>
			
			
			
			
			
          </div>
	  
		</div>

      </div>
      
      <%@include file="pied.jsp"%>

</body>
</html>
      