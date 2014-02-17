<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    
	<!-- En-tête de la page -->
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Inscription</title>
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
    	<jsp:param name="pageSelectionnee" value="administration"/>
		</jsp:include>
    	
    	<!-- Menu d'administration -->
    	<jsp:include page="adminMenu.jsp">
    	<jsp:param name="pageAdminSelectionnee" value="inscription"/>
		</jsp:include>
    	
    	<!-- Corps de la page -->
    	<div class="contenuPage">
			<form id="inscription">
	
		<fieldset class="inscription">
		<legend>Nouvel adhérent</legend>
			<table class="col">
				<tr>
					<td>
						<label for="nom">Nom</label>
					</td>
					<td>
						<input id="nom" type="text" placeholder="Nom"/>
					</td>
					<td>
						<label for="prenom">Prénom</label>
					</td>
					<td>
						<input id="prenom" type="text" placeholder="Prénom"/>
					</td>
				</tr>
			</table>
		</fieldset>
		
		<fieldset class="inscription">
		<legend>Informations générales</legend>
			<table class="col">
				<tr>
					<td>
						<label for="datenaissance">Date de naissance</label>
					</td>
					<td>
						<select name="Jour">
							<c:forEach var="i" begin="1" end="31">
								<option value="${i}">${i}</option>
							</c:forEach>
						</select>
						<select name="Mois">
							<c:forEach var="j" begin="1" end="12">
								<option value="${j}">${j}</option>
							</c:forEach>
						</select>
						<select name="Année">
							<c:forEach var="k" begin="1914" end="2014">
								<option value="${k}">${k}</option>
							</c:forEach>
						</select>
					</td>
					<td>
						<label for="telfixe">Téléphone fixe</label>
					</td>
					<td>
						<input id="telfixe" type="text" placeholder="Téléphone fixe"/>
					</td>
				</tr>
				<tr>
					<td>
						<label for="adresse">Adresse</label>
					</td>
					<td>
						<input id="adresse" type="text" placeholder="Adresse"/>
					</td>
					<td>
						<label for="telmobile">Téléphone mobile</label>
					</td>
					<td>
						<input id="telmobile" type="text" placeholder="Téléphone mobile"/>
					</td>
				</tr>
				<tr>
					<td>
						<label for="codepostal">Code postal</label>
					</td>
					<td>
						<input id="codepostal" type="text" placeholder="Code postal"/>
					</td>
					<td>
						<label for="mail">Adresse mail</label>
					</td>
					<td>
						<input id="mail" type="text" placeholder="Adresse mail"/>
					</td>
				</tr>
				<tr>
					<td>					
						<label for="ville">Ville</label>
					</td>
					<td>
						<input id="ville" type="text" placeholder="Ville"/>
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
						<input id="licence" type="text" placeholder="Licence"/>
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
						<select name="ligne"> 
							<option value="NC3">NC</option>
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
						<input type="checkbox" name="certificat" value="certificat"> Certificat médical</input>
					</td>
				</tr>
				<tr>
					<td>
						<label for="numpass">Numéro de pass</label>
					</td>
					<td>
						<input id="numpass" type="text" placeholder="Numéro de pass"/>
					</td>
					<td colspan="2">
						<input type="checkbox" name="prendrephotos" value="prendrephotos"> Autorisation de prendre des photos</input>
					</td>
				</tr>
				<tr>
					<td>	
						<label for="nbrecours">Nombre de cours</label>
					</td>
					<td>
						<input id="nbrecours" type="text" placeholder="Nombre de cours"/>
					</td>
					<td colspan="2">
						<input type="checkbox" name="publierphotos" value="publierphotos"> Autorisation de publier des photos</input>
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
				<tr>
					<td>
						<input type="submit" name="ajoutercours" value="Ajouter un cours"/>
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
		
		<fieldset class="inscription" id="statut">
		<legend>Statut</legend>
			<input type= "radio" name="statut" value="adherent">Adhérent</input>
			<input type= "radio" name="statut" value="administrateur">Administrateur</input>
		</fieldset>
		
		<input type="submit" id="ajouteradherent" name="ajouteradherent" value="Ajouter un adherent"/>
		
	</form>
        </div>   
		
    </body>
</html>