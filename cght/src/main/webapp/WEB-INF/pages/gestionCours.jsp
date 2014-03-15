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
    	<jsp:param name="pageAdminSelectionnee" value="gestionCours"/>
		</jsp:include>
    	
    	<!-- Corps de la page -->
    	<div class="contenuPage">
    	<h1>Gestion des cours</h1>
			<table id="tablecours">
		<tr>
			<td>
				<label for="jour">Jour</label>
			</td>
			<td>
				<label for="heuredebut">Heure de début</label>
			</td>
			<td>
				<label for="heurefin">Heure de fin</label>
			</td>
			<td>
				<label for="supprimer">Supprimer</label>
			</td>
		</tr>
		<c:forEach var="cours" items="${cours}" >
		<tr>
			<td>
				${cours.jourCours}
			</td>
			<td>
				<fmt:formatNumber pattern="00" value="${cours.heureDebut}"/>h<fmt:formatNumber pattern="00" value="${cours.minuteDebut}"/>
			</td>
			<td>
				<fmt:formatNumber pattern="00" value="${cours.heureFin}"/>h<fmt:formatNumber pattern="00" value="${cours.minuteFin}"/>
			</td>
			<td>
				<input type="checkbox" name="supprimercours" value="supprimercours"></input>
			</td>
		</tr>
		</c:forEach>
	</table>
	
	<input type="submit" class="bouton" name="supprimercours" value="Supprimer"/>
	
	<form action="gestion-cours" method="post">
	<fieldset class="cours">
	<legend>Nouveau cours</legend>
		<table id="ajoutercours">
			<tr>
				<td>
				Jour
				</td>
				<td>
					<select name="jour"> 
						<option value="lundi">Lundi</option>
						<option value="mardi">Mardi</option>
						<option value="mercredi">Mercredi</option>
						<option value="jeudi">Jeudi</option>
						<option value="vendredi">Vendredi</option>
						<option value="samedi">Samedi</option>
						<option value="dimanche">Dimanche</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
				Heure de début
				</td>
				<td>
					<select name="heuredebut"> 
						<c:forEach var="i" begin="8" end="22" >
							<option value="<fmt:formatNumber pattern="00" value="${i}"/>"><fmt:formatNumber pattern="00" value="${i}"/></option>
						</c:forEach>
					</select>
					h
					<select name="minutedebut">
						<c:forEach var="i" begin="00" end="55" step="5">
								<option value="<fmt:formatNumber pattern="00" value="${i}"/>"><fmt:formatNumber pattern="00" value="${i}"/></option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Heure de fin</td>
				<td>
					<select name="heurefin"> 
						<c:forEach var="i" begin="8" end="22" >
							<option value="<fmt:formatNumber pattern="00" value="${i}"/>"><fmt:formatNumber pattern="00" value="${i}"/></option>
						</c:forEach>
					</select>
					h
					<select name="minutefin">
						<c:forEach var="i" begin="00" end="55" step="5">
								<option value="<fmt:formatNumber pattern="00" value="${i}"/>"><fmt:formatNumber pattern="00" value="${i}"/></option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
	</fieldset>
	
	
	<input type="submit" class="bouton" name="ajoutercours" value="Ajouter un cours"/>
	</form>
        </div>   
		
    </body>
</html>