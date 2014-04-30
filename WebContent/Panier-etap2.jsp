<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="Head.jsp"%>
<c:url var="main" value="/_css/main.css" />
<link rel="stylesheet" href="${main}">

<body style="padding-top: 100px">
	<%@include file="Header.jsp"%>


	<div class="jumbotron">
		<div class="container">
			<h1>Hello, world!</h1>
			<p>This is a template for a simple marketing or informational
				website. It includes a large callout called a jumbotron and three
				supporting pieces of content. Use it as a starting point to create
				something more unique.</p>
			<p>
				<a class="btn btn-primary btn-lg" role="button">Learn more »</a>
			</p>
		</div>
	</div>
<div class="container">

	<div class="row">
	 	<div class="span12">
			<div class="accordion" id="accordion2">
            	<div class="accordion-group">
              		<div class="accordion-heading">
                		<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
                 		 <h3>Step 1: Checkout Options</h3>
                		</a>
              		</div>
              		<div id="collapseOne" class="accordion-body collapse" style="height: 0px;">
	                	<div class="accordion-inner">
					  		<div class="span6 no_margin_left">
								<h4>New Customer</h4>
								<p>By creating an account you will be able to shop faster, be up to date on an order's status, and keep track of the orders you have previously made.</p>
	
								<form class="">
									<fieldset>
										<input type="radio" value="option1" name="optionsCheckboxList1"> Register Account <br>
										<input type="radio" value="option2" name="optionsCheckboxList1"> Guest Checkout <br><br><br><br><br>
									  	<a class="btn btn-primary pull-right" href="#collapse2" data-toggle="collapse" data-parent="#collapse2">Continue</a>
				
									</fieldset>
								</form>
					  		</div>
							<div class="span5">
								<h4>Registered Customers</h4>
								<p>If you have an account with us, please log in.</p>
				
									<form class="">
										<fieldset>
											<div class="control-group">
												<label for="focusedInput" class="control-label">Username</label>
												<div class="controls">
												<input type="text" placeholder="Enter your username" id="username" class="input-xlarge focused">
												</div>
											</div>
											<div class="control-group">
												<label class="control-label">Password</label>
												<div class="controls">
												<input type="password" placeholder="Enter your password" id="password" class="input-xlarge">
												</div>
											</div>
					
											<a class="btn btn-primary pull-right" href="#collapse2">Continue</a>
					
										</fieldset>
									</form>
							</div> <!-- class="span5"> -->
	                	</div><!--<div class="accordion-inner"-->
              		</div><!--id="collapseOne"-->
            	</div> <!--class="accordion-group"-->

		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapse2">
					<h3>Step 2: Billing Details</h3>
				</a>
			</div>
			<div id="collapse2" class="accordion-body collapse" style="height: 0px;">
				<div class="accordion-inner">
					<div class="span6 no_margin_left">
						<legend>Your Personal Details</legend>
					  <div class="control-group">
						<label class="control-label">First Name</label>
						<div class="controls docs-input-sizes">
						  <input type="text" placeholder="" class="span4">
						</div>
					  </div>
					  <div class="control-group">
						<label class="control-label">Last Name</label>
						<div class="controls docs-input-sizes">
						  <input type="text" placeholder="" class="span4">
						</div>
					  </div>					  
					  <div class="control-group">
						<label class="control-label">Email Address</label>
						<div class="controls docs-input-sizes">
						  <input type="text" placeholder="" class="span4">
						</div>
					  </div>					 

					  <div class="control-group">
						<label class="control-label">Telephone</label>
						<div class="controls docs-input-sizes">
						  <input type="text" placeholder="" class="span4">
						</div>
					  </div>
					  </div>
					  <div class="span5">
					<legend>Your Address </legend>
					  <div class="control-group">
						<label class="control-label">Address 1</label>
						<div class="controls docs-input-sizes">
						  <input type="text" placeholder="" class="span4">
						</div>
					  </div>
					  <div class="control-group">
						<label class="control-label">Address 2</label>
						<div class="controls docs-input-sizes">
						  <input type="text" placeholder="" class="span4">
						</div>
					  </div>					  <div class="control-group">
						<label class="control-label">City</label>
						<div class="controls docs-input-sizes">
						  <input type="text" placeholder="" class="span4">
						</div>
					  </div>
					  <div class="control-group">
						<label class="control-label">ZIP</label>
						<div class="controls docs-input-sizes">
						  <input type="text" placeholder="" class="span4">
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
					  <br><a class="btn btn-primary pull-right" href="#collapse3">Continue</a><br><br><br>
					    </div>
				</div>

			</div>
		</div>
			
			
		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapse3">
					<h3>Step 3: Delivery Details</h3>
				</a>
			</div>
			<div id="collapse3" class="accordion-body collapse" style="height: 0px;">
<div class="accordion-inner">
										<div class="span6 no_margin_left">
						<legend>Your Personal Details</legend>
					  <div class="control-group">
						<label class="control-label">First Name</label>
						<div class="controls docs-input-sizes">
						  <input type="text" placeholder="" class="span4">
						</div>
					  </div>
					  <div class="control-group">
						<label class="control-label">Last Name</label>
						<div class="controls docs-input-sizes">
						  <input type="text" placeholder="" class="span4">
						</div>
					  </div>					  
					  <div class="control-group">
						<label class="control-label">Email Address</label>
						<div class="controls docs-input-sizes">
						  <input type="text" placeholder="" class="span4">
						</div>
					  </div>					 

					  <div class="control-group">
						<label class="control-label">Telephone</label>
						<div class="controls docs-input-sizes">
						  <input type="text" placeholder="" class="span4">
						</div>
					  </div>
					  </div>
					  <div class="span5">
					<legend>Your Address </legend>
					  <div class="control-group">
						<label class="control-label">Address 1</label>
						<div class="controls docs-input-sizes">
						  <input type="text" placeholder="" class="span4">
						</div>
					  </div>
					  <div class="control-group">
						<label class="control-label">Address 2</label>
						<div class="controls docs-input-sizes">
						  <input type="text" placeholder="" class="span4">
						</div>
					  </div>					  <div class="control-group">
						<label class="control-label">City</label>
						<div class="controls docs-input-sizes">
						  <input type="text" placeholder="" class="span4">
						</div>
					  </div>
					  <div class="control-group">
						<label class="control-label">ZIP</label>
						<div class="controls docs-input-sizes">
						  <input type="text" placeholder="" class="span4">
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
					  <br><a class="btn btn-primary pull-right" href="#collapse3">Continue</a><br><br><br>
					    </div>
				</div>
			</div>
		</div>
			
			
					<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapse4">
					<h3>Step 4: Payment Method</h3>
				</a>
			</div>
			<div id="collapse4" class="accordion-body collapse" style="height: 0px;">
				<div class="accordion-inner">
											<input type="radio" value="option1" name="payment1"> Collect in store<br>
						<input type="radio" value="option2" name="payment1"> Paypal<br>
						<input type="radio" value="option2" name="payment1"> Google checkout<br><br>
<div class="control-group">
            <label for="textarea" class="control-label">Comments</label>
            <div class="controls">
              <textarea rows="3" id="textarea" class="input-xlarge span11"></textarea>
            </div>
          </div>
					  <div class="span11 no_margin_left">
					  <br><a class="btn btn-primary pull-right" href="#collapse3">Confirm order</a><br><br><br>
					    </div>				</div>
			</div>
		</div>
			
			
			
			
			
          </div>
	  
		</div>

</div><!-- container -->

	<hr>

	<%@include file="Footer.jsp"%>
</body>
</html>      