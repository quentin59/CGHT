<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    
	<!-- En-tête de la page -->
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Bienvenue</title>
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
    	<jsp:param name="pageSelectionnee" value="index"/>
		</jsp:include>
    
    
    <div class="menuLateral">  
    <ul>
    	<li>Accueil</li>
    <c:forEach var="annee" items="${annees}" varStatus="listeAnnee" >
			<li>${annee}</li>
					<ul><c:forEach var="mois" items="${mois[listeAnnee.index]}">
						<li> ${mois}</li>						
					</c:forEach> 
					</ul>
		</c:forEach>
	</ul>
    </div>
    <div class="contenuPage">
    	<c:forEach var="actualite" items="${actualites}">
			<article class="actualite">
				<h2>${actualite.titre}</h2>
				<p>${actualite.contenu}</p>
				<p>${actualite.licence}</p>
				<p>${actualite.dateActualite}</p>
			</article>								
		</c:forEach> 
	</div>	
    </body>
</html>