<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    
	<!-- En-tête de la page -->
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Mon profil</title>
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
    	<jsp:param name="pageSelectionnee" value="profil"/>
		</jsp:include>
    
     <nav class="menuLateral" id="menuProfil">
		<ul>
			<li><a href="profil">Profil</a></li>
			<li><a href="profil"><b>Informations personnelles</b></a></li>
			<li><a href="parametres">Paramètres</a></li>
		</ul>
	</nav>
    	<!-- Corps de la page -->
		<div class="contenuPage">
	
		<fieldset class="inscription">
		<legend>Identité</legend>
			<table class="col">
				<tr>
					<td>
						<label for="nom">Nom</label>
					</td>
					<td>
						<input id="nom" type="text" name="nom" value="${adherent.nom}" disabled="disabled"/>
					</td>
					<td>
						<label for="prenom">Prénom</label>
					</td>
					<td>
						<input id="prenom" type="text" name="prenom" value="${prenom}" disabled="disabled"/>
					</td>
				</tr>
				<tr>
					<td>
						<label for="datenaissance">Date de naissance</label>
					</td>
					<td>
						<input type="date" id="datenaissance" name="datenaissance" value="<fmt:formatDate value="${adherent.dateNaissance}" pattern="dd-MM-yyyy"/>" disabled="disabled"/>
					</td>
				</tr>
			</table>
		</fieldset>
		
		<form method="post" action="profil">
		<fieldset class="inscription">
		<legend>Informations générales</legend>
			<table class="col">
				<tr>
					<td>
						<label for="adresse">Adresse</label>
					</td>
					<td>
						<input id="adresse" type="text" name="adresse" value="${adherent.adresse}"/>
					</td>
					<td>
						<label for="telfixe">Téléphone fixe</label>
					</td>
					<td>
						<input id="telfixe" type="text" name="telfixe" value="${adherent.telephone}"/>
					</td> 
				</tr>
				<tr>
					<td>
						<label for="codepostal">Code postal</label>
					</td>
					<td>
						<input id="codepostal" type="text" name="codepostal" value="${adherent.codePostal}"/>
					</td>
					<td>
						<label for="telmobile">Téléphone mobile</label>
					</td>
					<td>
						<input id="telmobile" type="text" name="telmobile" value="${adherent.portable}"/>
					</td>
				</tr>
				<tr>
					<td>					
						<label for="ville">Ville</label>
					</td>
					<td>
						<input id="ville" type="text" name="ville" value="${adherent.ville}"/>
					</td>
				</tr>
			</table>
			<input type="submit" id="ajouteradherent" name="ajouteradherent" value="Enregistrer les modifications"/>
		
		</form>
		</fieldset>
		
		<fieldset class="inscription">
		<legend>Informations tennis</legend>
			<table class="col">
			<tr><td></td><td></td><td></td><td></td></tr>
				<tr>
					<td>
						<label for="licence">Licence</label>
					</td>
					<td>
						<input id="licence" type="text" name="licence" value="${adherent.licence}" disabled />
					</td>
					<td colspan="2">
					<c:set var="certif" scope="page" value="${adherent.certif}"/>
						<input type="checkbox" name="certificat" value="certificat" <c:if test="${certif}">checked</c:if> disabled > Certificat médical</input>
					</td>
				</tr>
				<tr>
					<td>
						<label for="classement">Classement</label>
					</td>
					<td>
						<select name="classement" disabled > 
							<option value="${adherent.classement}" selected>${adherent.classement}</option>
							<option value="NC">NC</option>
							<option value="40">40</option>
							<option value="30/5">30/5</option>
							<option value="30/4">30/4</option>
							<option value="30/3">30/3</option>
							<option value="30/2">30/2</option>
							<option value="30/1">30/1</option>
							<option value="30">30</option>
							<option value="15/5">15/5</option>
							<option value="15/4">15/4</option>
							<option value="15/3">15/3</option>
							<option value="15/2">15/2</option>
							<option value="15/1">15/1</option>
							<option value="15">15</option>
							<option value="5/6">5/6</option>
							<option value="4/6">4/6</option>
							<option value="3/6">3/6</option>
							<option value="2/6">2/6</option>
							<option value="1/6">1/6</option>
							<option value="0">0</option>
						</select>
					</td>
					<td colspan="2">
					<c:set var="prendrePhoto" scope="page" value="${adherent.prendrePhoto}"/>
						<input type="checkbox" name="prendrePhoto" value="prendrePhoto" <c:if test="${prendrePhoto}">checked</c:if> disabled > Autorisation de prendre des photos</input>
					</td>
				</tr>
				<tr>
					<td>
						<label for="numpass">Numéro de pass</label>
					</td>
					<td>
						<input id="numpass" type="text" name="numpass" value="${adherent.numPass}" disabled />
					</td>
					<td colspan="2">
						<c:set var="publierPhoto" scope="page" value="${adherent.publierPhoto}"/>
						<input type="checkbox" name="publierPhoto" value="publierPhoto" <c:if test="${publierPhoto}">checked</c:if> disabled > Autorisation de publier des photos</input>
					</td>
				</tr>
			</table>
		</fieldset>
		
	<fieldset class="inscription">
		<legend>Paiements</legend>
			<table id="tablepaiements">
				<tr>
					<td>Payé</td>
					<td>Banque</td>
					<td>Numéro de chèque</td>
					<td>Echéance</td>
					<td>Montant</td>
				</tr>
				<c:forEach var="paiement" items="${paiements}" >
				<tr>
					<td><input type="checkbox"  <c:if test="${paiement.payer==true}">checked</c:if> disabled/></td>
					<td>${paiement.banque}</td>
					<td>${paiement.numCheque}</td>
					<td>${paiement.echeance}</td>
					<td>${paiement.montant}€</td>
				</tr>
				</c:forEach>
			</table>
	</fieldset>
	<fieldset class="inscription">
		<legend>Mes cours</legend>
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
				<tr>
				</c:forEach>
			</table>
	</fieldset>
        </div>  
		
    </body>
</html>