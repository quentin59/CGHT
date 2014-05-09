<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    
	<!-- En-tête de la page -->
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Détails</title>
        <link rel="icon" type="image/jpg" href="../img/cght.jpg" />
		<link rel="stylesheet" href="../css/style.css"/>
		<!-- JQuery -->
	<script type="text/javascript" src="../js/jquery-1.10.2.js"></script>
	<!-- Javascript spécifique -->
	<script type="text/javascript" src="../js/menu.js"></script>
	<script type="text/javascript" src="../js/modifAdherent.js"></script>
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
    	<jsp:param name="pageAdminSelectionnee" value=""/>
		</jsp:include>
    	
    	
    	<!-- Corps de la page -->
		<div class="contenuPage">
			<form id="modif" method="post" action="modifieradherent">
	
		<fieldset class="inscription">
		<legend>Identité</legend>
			<table class="col">
				<tr>
					<td>
						<label for="nom">Nom</label>
					</td>
					<td>
						<input id="nom" type="text" name="nom" value="${adherent.nom}"/>
					</td>
					<td>
						<label for="prenom">Prénom</label>
					</td>
					<td>
						<input id="prenom" type="text" name="prenom" value="${adherent.prenom}"/>
					</td>
				</tr>
				<tr>
					<td>
						<label for="datenaissance">Date de naissance</label>
					</td>
					<td>
						<input type="date" id="datenaissance" name="datenaissance" value="<fmt:formatDate value="${adherent.dateNaissance}" pattern="dd-MM-yyyy"/>"/>
					</td>
				</tr>
			</table>
		</fieldset>
		
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
					<td>
						<label for="mail">Mail</label>
					</td>
					<td>
						<input id="mail" type="text" name="mail" value="${adherent.mail}" />
					</td>	
				</tr>
			</table><br>
			<c:set var="admin" scope="page" value="${adherent.statut}"/>
			<input type= "radio" name="statut" value="adherent" <c:if test="${adherent.statut=='adherent'}">checked</c:if> >Adhérent</input>
			<input type= "radio" name="statut" value="administrateur" <c:if test="${adherent.statut=='administrateur'}">checked</c:if> >Administrateur</input>
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
						<input id="licence" type="text" name="licence" value="${adherent.licence}" />
					</td>
					<td colspan="2">
					<c:set var="certif" scope="page" value="${adherent.certif}"/>
						<input type="checkbox" name="certificat" value="certificat" <c:if test="${certif}">checked</c:if>> Certificat médical</input>
					</td>
				</tr>
				<tr>
					<td>
						<label for="classement">Classement</label>
					</td>
					<td>
						<select name="classement"> 
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
						<input type="checkbox" name="prendrePhoto" value="prendrePhoto" <c:if test="${prendrePhoto}">checked</c:if>> Autorisation de prendre des photos</input>
					</td>
				</tr>
				<tr>
					<td>
						<label for="numpass">Numéro de pass</label>
					</td>
					<td>
						<input id="numpass" type="text" name="numpass" value="${adherent.numPass}" />
					</td>
					<td colspan="2">
						<c:set var="publierPhoto" scope="page" value="${adherent.publierPhoto}"/>
						<input type="checkbox" name="publierPhoto" value="publierPhoto" <c:if test="${publierPhoto}">checked</c:if>> Autorisation de publier des photos</input>
					</td>
				</tr>
			</table>
		</fieldset>
		<input type="submit" id="ajouteradherent" name="ajouteradherent" value="Enregistrer les modifications"/>
		
	</form>
		
		<fieldset class="inscription">
		<legend>Paiements</legend>
		<form action="ajouter-paiement-adherent" method="post">
			<input style="display:none;" id="licence" type="text" name="licence" value="${adherent.licence}"/>
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
					<td><input type="checkbox" name="encaisserpaiement${paiement.idPaiement}" value="encaisserpaiement${paiement.idPaiement}" id="paiement${paiement.idPaiement}" <c:if test="${paiement.payer==true}">checked</c:if> /></td>
					<td>${paiement.banque}</td>
					<td>${paiement.numCheque}</td>
					<td>${paiement.echeance}</td>
					<td>${paiement.montant}€</td>
				</tr>
				</c:forEach>
			</table>
			<input class="hidden" type="text" id="compteurCheque" name="compteurCheque" value="0" /><br>
			<input type="text" class="valider" id="ajoutercheque" name="ajoutercheque" value="Ajouter un paiement"/>
			
			<input type="submit" class="bouton" name="ajouterpaiement" value="Enregistrer" />
		</form>
		</fieldset>
		
		<fieldset class="inscription">
		<legend>Cours de ${adherent.prenom} ${adherent.nom}</legend>
	<form action="supprimer-cours-adherent" method="post">
	<input style="display:none;" id="licence" type="text" name="licence" value="${adherent.licence}"/>
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
				<input type="checkbox" name="supprimercours${cours.idCours}" value="supprimercours${cours.idCours}" id="cours${cours.idCours}"/>
			</td>
		</tr>
		</c:forEach>
		
	</table>
	
	<input type="submit" class="bouton" name="supprimercours" value="Supprimer" />
	</form>
	
	
	<form action="ajouter-cours-adherent" method="post">
		<input type="hidden" name="licence" value="${adherent.licence}" />
		<table>
			<tr class="hidden" id="cours-hidden-1" >
					<td>Cours 1</td>
					<td>
						<select name="Cours-1">
								<option value="vide"></option>
							<c:forEach var="cours" items="${jourscours}" >
								<option value="${cours}">${cours}</option>
							</c:forEach>
						</select>
						<select name="horaires-1" id="horaires-1">
						</select>
					</td>
				</tr>
				<tr class="hidden" id="cours-hidden-2">
					<td>Cours 2</td>
					<td>
						<select name="Cours-2">
								<option value="vide"></option>
							<c:forEach var="cours" items="${jourscours}" >
								<option value="${cours}">${cours}</option>
							</c:forEach>
						</select>
						<select name="horaires-2" id="horaires-2">
						</select>
					</td>
				</tr> 
				<tr class="hidden" id="cours-hidden-3">
					<td>Cours 3</td>
					<td>
						<select name="Cours-3">
								<option value="vide"></option>
							<c:forEach var="cours" items="${jourscours}" >
								<option value="${cours}">${cours}</option>
							</c:forEach>
						</select>
						<select name="horaires-3" id="horaires-3">
						</select>
					</td>
				</tr>
				<tr class="hidden" id="erreur-nombrecours">
					<td colspan="2">Vous ne pouvez pas prendre plus de 3 cours.</td>
				</tr>
				<tr>
					<td>
						<input type="text" class="valider" id="ajoutercours" name="ajoutercours" value="Ajouter un cours"/>
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" class="bouton" name="valider-ajoutercours" value="Enregistrer" />
					</td>
				</tr>
		</table>
	</form>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	</fieldset>
		</div>
		
    </body>
</html>