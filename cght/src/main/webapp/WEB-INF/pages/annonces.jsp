<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    
	<!-- En-tête de la page -->
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Les petites annonces</title>
		<link rel="stylesheet" href="css/style.css"/>
		<link rel="icon" type="image/jpg" href="img/cght.jpg" />
		<!-- JQuery -->
	<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	<!-- Javascript spécifique -->
	<script type="text/javascript" src="js/menu.js"></script>
    </head>
    
    <body>
    <!-- Header -->
    	<jsp:include page="header.jsp"/>
    
    
    	<!-- Menu de navigation -->
    	<jsp:include page="menu.jsp">
    	<jsp:param name="pageSelectionnee" value="annonces"/>
		</jsp:include>
		
		<div class="menuLateral">  
		    <ul>
		    	<li><a href="annonces">Annonces</a></li>
		    	
		    	<li id="ajouter-contenu"><a href="poster-annonce">Ajouter une annonce</a></li>
		    	<c:set var="i" value="0" />
		    <c:forEach var="annee" items="${annees}" varStatus="listeAnnee" >
					<li><a href="annonces?annee=${annee}"> ${annee}</a></li>
							<ul><c:forEach var="mois" items="${mois[listeAnnee.index]}">
								<li><a href="annonces?annee=${annee}&mois=${moisChiffre[i]}"> ${mois}</a></li>						
							</c:forEach> 
							</ul>
				</c:forEach>
			</ul>
    </div>
   <div class="contenuPage">
    	<c:forEach var="annonce" items="${annonces}" >
			<article class="annonce">
			<div class="boutonsadmin" style="float:right;">
						<% if (request.getSession().getAttribute("statut").equals("administrateur")) {%>
						<a href="#" ><img alt="modifer" src="img/modifier.jpg" height="50" width="50"/></a>
						<a href="annonces?supprimer=${annonce.idAnnonce}" ><img alt="supprimer" src="img/supprimer.png" height="52" width="52"/></a>
						<%} %>
					</div>
				<div class="contenuannonce">
					<div class="teteannonce"><h2>${annonce.titre}</h2><p>(<fmt:formatDate value="${annonce.dateAnnonce}" pattern="dd MMMM yyy"/>)</p></div>
					<p>Catégorie : ${annonce.categorie}</p>
					<c:if test="${annonce.categorie==\"Vente de matériel\"}" >
					<p>${annonce.prix} €</p>
					</c:if>
					<p>${annonce.contenu}</p>
				</div>
				<div class="photoannonce"> 
					<img src="img/1024.png" alt= "filet.jpg" height="200px"/>
				</div>
			</article>								
		</c:forEach> 
	</div>	
    </body>
</html>