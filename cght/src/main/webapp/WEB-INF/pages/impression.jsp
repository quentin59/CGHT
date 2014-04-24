<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    
	<!-- En-tête de la page -->
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Administration</title>
        <link rel="icon" type="image/jpg" href="../img/cght.jpg" />
		<link rel="stylesheet" href="../css/style.css"/>
		<!-- JQuery -->
	<script type="text/javascript" src="../js/jquery-1.10.2.js"></script>
	<!-- Javascript spécifique -->
	<script type="text/javascript" src="../js/menu.js"></script>
    </head>
    
    <body>
    <!-- Header -->
    	<header>
	<img id="header" src="../img/bandeau.jpg" alt= "bandeau.jpg" class="header"/>
	<div id="identifiant">
		<h3>${prenom} ${nom}</h3>
		<a id="boutonDeconnexion" href="/mawebapp/connexion?logout">Déconnexion</a>
	</div>
</header>
    
    
    	<!-- Menu de navigation -->
    	<jsp:include page="menu.jsp">
    	<jsp:param name="pageSelectionnee" value="administration"/>
		</jsp:include>
    
     <!-- Menu d'administration -->
    	<jsp:include page="adminMenu.jsp">
    	<jsp:param name="pageAdminSelectionnee" value="impression"/>
		</jsp:include>
    	
    	
    	<!-- Corps de la page -->
		
        <div class="contenuPage">
    <fieldset id="fieldsetfichesadherents">
	<legend id="legendfiches">Fiches adhérents</legend>
	<table id="fichesadherents">
		<tr>
			<td>Nom</td>
			<td>Prénom</td>
			<td>Sélectionner<br/>
				<input type="checkbox" name="selectionneradherent" value="selectionneradherent">Tout sélectionner</input>
			</td>
		</tr>
		<c:forEach var="adherent" items="${adherents}">
			<tr>
				<td>${adherent.nom}</td>
				<td>${adherent.prenom}</td>
			<td>
				<input type="checkbox" name="adherent${adherent.licence}" value="adherent${adherent.licence}"></input>
			</td>
		</tr>
		</c:forEach>
	</table>
	
	<input type="submit" class="bouton" name="imprimerfiches" value="Imprimer" />
	
	</fieldset>
	
	<fieldset id="fieldsetfichespresence">
	<form action="impression" method="post">
	<legend id="legendpresences">Fiches de présence</legend>
	<table id="fichespresences">
		<tr>
			<td colspan="2">
			Cours
			</td>
			<td>
			Sélectionner
			<br/>
			<input type="checkbox" name="selectionnercours" value="selectionnercours">Tout sélectionner</input>
			</td>
		</tr>
		<c:forEach var="cours" items="${cours}" >
		<tr>
			<td>${cours.jourCours}</td>
			<td><fmt:formatNumber pattern="00" value="${cours.heureDebut}"/>h<fmt:formatNumber pattern="00" value="${cours.minuteDebut}"/>-<fmt:formatNumber pattern="00" value="${cours.heureFin}"/>h<fmt:formatNumber pattern="00" value="${cours.minuteFin}"/></td>
			<td>
			<input type="checkbox" name="cours${cours.idCours}" value="cours${cours.idCours}"></input>
			</td>
		</tr>
		</c:forEach>
	</table>
	
	<input type="submit" class="bouton" name="imprimerpresence" value="Imprimer" />
	</form>
	</fieldset>
        </div>   
		
    </body>
</html>