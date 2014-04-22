<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:url var = "jQuery"    value="/_js/libs/jquery-1.10.2.min.js"/>
	<c:url var = "bootstjs"    value="/_js/bootstrap.min.js"/>
	
	<c:url var = "normalize" value="/_css/normalize.css"/>
	<c:url var = "boots"     value="/_css/bootstrap.min.css"/>
	<c:url var = "bord"     value="/_css/dashboard.css"/>
	<c:url var = "starter"     value="/_css/starter-template.css"/>


	<c:url var="urlAdd" value="/dvd/add" />
	<link rel="stylesheet" href="${bord}" >
	<link rel="stylesheet" href="${normalize}"  />
	<link rel="stylesheet" href="${boots}" />
	<link href="${starter}" rel="stylesheet">
	<link rel="stylesheet" type="text/css" media="screen" href="//d85wutc1n854v.cloudfront.net/live/css/screen.css?buster-140319-2">
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">CinePantin</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Boutique</a></li>
					<li><a href="#about">Evènements</a></li>
					<li><a href="#about">A propos</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
				<ul class="nav secondary-nav">
					<li><a href="/signin"
						style="padding-left: 17px; background: transparent url('//d85wutc1n854v.cloudfront.net/live/imgs/lock_icon.png') no-repeat 0px center;">Sign
							in</a></li>
					<li><a href="/signup">Sign up</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		
		<div id="menu">
                                <div class="container">
                                        <div id="categories">
                                                <div class="category_button"><a href="#" title="Select a category">Categories</a></div>
                                                <div class="dropdown_container">
                                                        <div class="categories">
                                                                <ul>
                                                                        <li><a href="/themes/admin" title="Admin, dashboard, and other backend themes">Admin &amp; Dashboards <span>&nbsp;</span></a></li>
                                                                        <li><a href="/themes/landing-pages" title="Landing page themes">Landing Pages <span>&nbsp;</span></a></li>
                                                                        <li><a href="/themes/business" title="Business and corporate themes">Business &amp; Corporate <span>&nbsp;</span></a></li>
                                                                        <li><a href="/themes/portfolios" title="Portfolio themes">Portfolios <span>&nbsp;</span></a></li>
                                                                        <li><a href="/themes/resumes-cv" title="Resume and Curriculum Vitae (CV) themes">Resumes &amp; CV <span>&nbsp;</span></a></li>
                                                                        <li><a href="/themes/e-commerce" title="E-Commerce and shopping themes">E-Commerce <span>&nbsp;</span></a></li>
                                                                        <li><a href="/themes/components" title="Theme components">Components <span>&nbsp;</span></a></li>
                                                                        <li><a href="/themes/blogs-magazines" title="Blog and magazine themes">Blogs &amp; Magazines <span>&nbsp;</span></a></li>
                                                                        <li><a href="/themes/wordpress" title="Bootstrap WordPress themes">WordPress <span>&nbsp;</span></a></li>
                                                                        <li><a href="/themes/other" title="Miscellaneous themes">Other <span>&nbsp;</span></a></li>
                                                                </ul>
                                                        </div>
                                                </div>
                                        </div>
                                        <div id="search">
                                                <form action="/search" method="get">
                                                        <input class="query" name="q" type="text" placeholder="Enter search terms" size="29" value=""><input class="submit button" type="submit" value="">
                                                </form>
                                        </div>
                                       
                                </div>
                        </div>
    </div>
 </div>    
     
<div class="container">

      <div class="row row-offcanvas row-offcanvas-right">

        <div class="col-xs-12 col-sm-9">
          <p class="pull-right visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
          </p>
          <div class="jumbotron">
            <h1>Hello, world!</h1>
            <p>This is an example to show the potential of an offcanvas layout pattern in Bootstrap. Try some responsive-range viewport sizes to see it in action.</p>
          </div>
          <div class="row">
            <div class="col-6 col-sm-6 col-lg-4">
              <h2>Heading</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
            </div><!--/span-->
            <div class="col-6 col-sm-6 col-lg-4">
              <h2>Heading</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
            </div><!--/span-->
            <div class="col-6 col-sm-6 col-lg-4">
              <h2>Heading</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
            </div><!--/span-->
            <div class="col-6 col-sm-6 col-lg-4">
              <h2>Heading</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
            </div><!--/span-->
            <div class="col-6 col-sm-6 col-lg-4">
              <h2>Heading</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
            </div><!--/span-->
            <div class="col-6 col-sm-6 col-lg-4">
              <h2>Heading</h2>
              <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
              <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
            </div><!--/span-->
          </div><!--/row-->
        </div><!--/span-->

      </div><!--/row-->

      <hr>

      <footer>
        <p>© Company 2014</p>
      </footer>

    </div>

</body>
</html>