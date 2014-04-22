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
	<c:url var = "starter"     value="/_css/jumbotron.css"/>


	<c:url var="urlAdd" value="/dvd/add" />
	<link rel="stylesheet" href="${bord}" >
	<link rel="stylesheet" href="${normalize}"/>
	<link rel="stylesheet" href="${boots}" />
<%-- 	<link href="${starter}" rel="stylesheet"> --%>
	<link href="${jumbotron}" rel="stylesheet">
	<link rel="stylesheet" type="text/css" media="screen" href="//d85wutc1n854v.cloudfront.net/live/css/screen.css?buster-140319-2">
</head>
<body style="padding-top: 100px">
	<%@include file="Header.jsp" %>
   <div class="jumbotron">
      <div class="container">
        <h1>Hello, world!</h1>
        <p>This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
        <p><a class="btn btn-primary btn-lg" role="button">Learn more »</a></p>
      </div>
    </div>
    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
        </div>
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
          <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
       </div>
        <div class="col-md-4">
          <h2>Heading</h2>
          <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
          <p><a class="btn btn-default" href="#" role="button">View details »</a></p>
        </div>
      </div>

      <hr>

      <%@include file="Footer.jsp" %>
    </div>
</body>
</html>