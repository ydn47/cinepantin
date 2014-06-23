<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>

<%@include file="entete.jsp"%>
<jsp:include page="entete.jsp">
	<jsp:param value="about.jsp" name="origine"/>
</jsp:include>
<!-- http://wrapbootstrap.com/preview/WB00223R0 -->
<div class="row">  
	<div class="span3">
	<h2>Présentation de CinéPantin</h2>
	<h3></h3>
	<!-- <p>With Bootstrap 2, we've simplified the base class: <code>.alert</code> instead of <code>.alert-message</code>. We've also reduced the minimum required markup—no <code>&lt;p&gt;</code> is required by default, just the outer <code>&lt;div&gt;</code>.</p> -->
	<p align="justify">CinePantin est une librairie spécialisée dans le domaine du cinéma, qui dispose d’un magasin
situé à Pantin. Son activité, originellement centrée sur la vente de livres sur le cinéma, s’étend
maintenant à toutes sortes d’articles dans ce domaine (notamment des DVD, des CD, des
affiches, des revues, des objets, des places pour des projections etc.).</p> 
	</div>
	<div class="span9"> 
<div class="page-header">
    <h1>A propos de nous <small>Ce que nous faisons</small></h1>
  </div>

  <!-- Headings & Paragraph Copy -->
  <div class="row">
  
  
      <div class="span9">
      <!-- <blockquote class="pull-right">
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante venenatis.</p>
        <small>Someone famous in <cite title="">Body of work</cite></small>
      </blockquote> -->

    </div>
  
    <div class="span9">
      <h3>Qualité du catalogue</h3>
      <p>Le site propose à ce jour deux catégories de produits culturels : livres et DVD.</p>
      <p></p>
    </div>

    <div class="span9">
      <h3>Innovation technologique</h3>
      <p>Cinepantin fonde sa croissance sur l’innovation technologique, qui lui permet d’offrir à ses clients un éventail de produits toujours plus large, de façon toujours plus simple et à des prix toujours plus concurrentiels.</p>

      <p></p>
    </div>

    <div class="span9">
      <h3>Élaboration de la plateforme</h3>
      <p>Cinepantin a commencé à mettre sa plateforme de commerce électronique à la disposition des professionnels et des particuliers en 2014.</p>

      <p></p>
    </div>

    <div class="span9">
      <h3>Perspectives futures</h3>
      <p>Notre activité, originellement centrée sur la vente de livres sur le cinéma, s’étendra à l'avenir
 à toutes sortes d’articles dans ce domaine (notamment des DVD, des CD, des
affiches, des revues, des objets, des places pour des projections etc.).</p>

      <p></p>
    </div>


  <!-- Misc Elements -->
  
  </div><!-- /row -->

	</div>

</div>
<%@include file="pied.jsp"%>

</body>
</html>