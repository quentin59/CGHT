<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    
	<!-- En-tête de la page -->
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Administration</title>
		<link rel="stylesheet" href="../css/style.css"/>
		<link rel="icon" type="image/jpg" href="../img/cght.jpg" />
		<!-- JQuery -->
	<script type="text/javascript" src="../js/jquery-1.10.2.js"></script>
	<!-- Javascript spécifique -->
	<script type="text/javascript" src="../js/menu.js"></script>
	<script type="text/javascript" src="../js/gestionComptes.js"></script>
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
    	<jsp:param name="pageAdminSelectionnee" value="gestionComptes"/>
		</jsp:include>
    	
    	<!-- Corps de la page -->
    	<div class="contenuPage">
    	<h1>Gestion des comptes</h1>
		<section>	
			<div class="caracteristiques">
			<form method="post" action="gestion-comptes">	
				<table id="comptes">
					<thead>
						<tr>
							<th>Nom</th>
							<th>Prénom</th>
							<th>Date de naissance</th>
							<th>Numéro de licence</th>
							<th>Classement</th>
							<th>Téléphone</th>
							<th>Détails</th>
							<th>Supprimer</br><input type="submit" id="toutselectionner" value="Tout sélectionner"/></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="adherent" items="${adherents}">
							<tr>
								<td>${adherent.nom}</td>
								<td>${adherent.prenom}</td>
								<td>${adherent.dateNaissance}</td>
								<td>${adherent.licence}</td>
								<td>${adherent.classement}</td>
								<td>${adherent.telephone}</td>
								<td><a href="modifieradherent?licence=${adherent.licence}"><input class="modifier" id="${adherent.licence}" type="submit" value="Détails"/></a></td>
								<td><input class="supprimer" id="supprimer${adherent.licence}" name="supprimer${adherent.licence}" type="checkbox" value=""/></td>
							</tr>
							</c:forEach>
					</tbody>
				</table>
				<input class="bouton" value="Supprimer" type="submit"/>
				</form>
			</div>	
		</section>
        </div>   
		
    </body>
</html>