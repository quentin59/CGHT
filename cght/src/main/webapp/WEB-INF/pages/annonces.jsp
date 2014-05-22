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
		
		<div class="menuLateral" style="width:250px;">  
		    <ul>
		    	<li style="margin-bottom:20px;"><a href="annonces">Annonces</a></li>
		    </ul>
		    <form action="annonces" method="post">
				<label for="categorie">Catégorie</label>
		    	<select name="categorie" id="categorie" >
		    		<option value="toute"></option>
		    		<option value="Vente de matériel" <c:if test="${categorie==\"Vente de matériel\"}" >selected</c:if>>Vente de matériel</option>
		    		<option value="Recherche de matériel" <c:if test="${categorie==\"Recherche de matériel\"}" >selected</c:if>>Recherche de matériel</option>
		    		<option value="Recherche de partenaire de jeu" <c:if test="${categorie==\"Recherche de partenaire de jeu\"}" >selected</c:if>>Recherche de partenaire de jeu</option>
		    	</select><br>
		    	<input type="submit" value="Valider"/>
			</form>
			<ul>
		    	<li style="margin-top:0px; margin-bottom:0px; margin-left:-40px;
	border : 1px solid black;
	color:black;
	background-image:none;" id="ajouter-contenu"><a href="poster-annonce">Ajouter une annonce</a></li>
		    	<c:set var="i" value="0" />
		    <c:forEach var="annee" items="${annees}" varStatus="listeAnnee" >
					<li><a href="annonces?annee=${annee}"> ${annee}</a></li>
							<ul><c:forEach var="mois" items="${mois[listeAnnee.index]}">
								<li><a href="annonces?annee=${annee}&mois=${moisChiffre[i]}"> ${mois}</a></li>
								<c:set var="i" value="${i+1}"/>						
							</c:forEach> 
							</ul>
				</c:forEach>
			</ul>
			
    </div>
   <div class="contenuPage" style="left:100px;">
    	<c:forEach var="annonce" items="${annonces}" >
			<article class="annonce">
			<div class="boutonsadmin" style="float:right;">
						<% if (request.getSession().getAttribute("statut").equals("administrateur")) {%>
						<a href="poster-annonce?id=${annonce.idAnnonce}" ><img alt="modifer" src="img/modifier.jpg" height="50" width="50"/></a>
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
					<p>Contact : ${annonce.coordonnees}</p>
				</div>
			</article>								
		</c:forEach> 
	</div>	
    </body>
</html>