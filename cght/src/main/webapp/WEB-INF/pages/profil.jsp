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
			<form id="inscription" method="post" action="inscription">
	
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
		</fieldset>
		
		<fieldset class="inscription">
		<legend>Informations tennis</legend>
			<table class="col">
				<tr>
					<td>
						<label for="licence">Licence</label>
					</td>
					<td>
						<input id="licence" type="text" name="licence" placeholder="Licence" disabled/>
					</td>
					<td>
					</td>
					<td>
					</td>
				</tr>
				<tr>
					<td>
						<label for="classement">Classement</label>
					</td>
					<td>
						<select name="classement" disabled> 
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
						<input type="checkbox" name="certificat" value="certificat" disabled> Certificat médical</input>
					</td>
				</tr>
				<tr>
					<td>
						<label for="numpass">Numéro de pass</label>
					</td>
					<td>
						<input id="numpass" type="text" name="numpass" placeholder="Numéro de pass" disabled/>
					</td>
					<td colspan="2">
						<input type="checkbox" name="prendrePhoto" value="prendrePhoto" disabled> Autorisation de prendre des photos</input>
					</td>
				</tr>
				<tr>
					<td>	
						<label for="nbrecours">Nombre de cours</label>
					</td>
					<td>
						<input id="nbrecours" type="text" placeholder="Nombre de cours" disabled/>
					</td>
					<td colspan="2">
						<input type="checkbox" name="publierPhoto" value="publierPhoto" disabled> Autorisation de publier des photos</input>
					</td>
				</tr>
				<tr>
					<td>
						Cours i
					</td>
					<td>
						<select name="Cours">
							<%--<c:forEach var="jour">
								<option value="jour">Jour</option>
							</c:forEach>--%>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						Horaires i
					</td>
					<td>
						<select name="Horaires">
							<%-- <c:forEach var="horaires">
								<option value="horaires">Horaires</option>
							</c:forEach>--%>
						</select>
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
			</table>
		</fieldset>
		
		<input type="submit" id="ajouteradherent" name="ajouteradherent" value="Enregistrer les modifications"/>
		
	</form>
        </div>  
		
    </body>
</html>