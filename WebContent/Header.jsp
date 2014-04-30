<script type="text/javascript">
		$(document).ready(function() {
			mutiselectCode();
		});
	</script>

	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${boutique}">CinePantin</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="${boutique}">Boutique</a></li>
					<li><a href="#about">Evènements</a></li>
					<li><a href="#about">A propos</a></li>
					<li><a href="#contact">Contact</a></li>
				</ul>
				<ul class="nav secondary-nav">
					<c:choose>
						<c:when test="${msg != null}">
							<li><a href="${signmodif}"><i
									class="glyphicon glyphicon-user"></i> ${msg}</a></li>
							<li><a href="${disconnect}"><i
									class="glyphicon glyphicon-lock"></i> Déconexion</a></li>
						</c:when>
						<c:otherwise>

							<li><a href="${signin}"><i
									class="glyphicon glyphicon-lock"></i> Se connecter</a></li>
							<li><a href="${signup}">Créer un compte</a></li>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${nbArticles == 0}">
							<li class="dropdown">
								<a href="#" rel="nofollow" class="cart">Cart <span class="badge">0</span></a>
								<div class="dropdown-menu cart-content">
									<p>Vous n'avez pas d'articles dans votre panier.</p>
								</div>
							</li>
						</c:when>
						<c:otherwise>
							<!-- Not empty cart -->
							<li class="dropdown cart-not-empty">
								<a href="${paniercont}" rel="nofollow" class="cart"><i class="glyphicon glyphicon-shopping-cart"></i>
									Panier <span class="badge">${nbArticles}</span>
								</a>
							</li>
						</c:otherwise>
					</c:choose>
					
					

				</ul>
			</div><!--/.nav-collapse -->
		</div><!-- container-->
		<div id="menu">
			<div class="container">
				<form action="${boutique}" method="get">
					<div id="categories">
						<select  id="example22" multiple="multiple" style="display: none" name="choixCategories">
							<c:forEach var="cat" items="${lstCategories}">
								<option value="${cat.getIdCategorie()}">${cat.getNomCategorie()}</option>
							</c:forEach>
						</select>
					</div>
					<div id="search">
						<input class="query" name="q" type="text" placeholder="Enter search terms" size="29" value="" id="query" /> 
						<input class="btn btn-search" id="searchForm" type="submit" value="Rechercher" name="search">
						
					</div>
				</form>
			</div>
		</div>
		
	</div>

</body>
</html>
