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
		<section>	
			<div class="caracteristiques">	
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Nom</th>
							<th>Prenom</th>
							<th>Date de naissance</th>
							<th>Numéro de licence</th>
							<th>Classement</th>
							<th>Téléphone</th>
							<th>Supprimer</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="adherent" items="${adherents}">
							<tr>
								<td>${adherent.nom}</td>
								<td>${adherent.prenom}</td>
								<td><fmt:formatDate value="${adherent.dateNaissance}" pattern="dd MMMM yyyy"/></td>
								<td>${adherent.licence}</td>
								<td>${adherent.classement}</td>
								<td>${adherent.telephone}</td>
								<td><input class="supprimer" id="${adherent.licence}" type="reset" value="Supprimer"/></td>
							</tr>
							</c:forEach>
					</tbody>
				</table>
			</div>	
		</section>
        </div>   
		
    </body>
</html>