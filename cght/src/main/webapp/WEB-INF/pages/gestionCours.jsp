<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    
	<!-- En-tête de la page -->
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Administration</title>
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
		<tr>
			<td>
				Mercredi
			</td>
			<td>
				18h
			</td>
			<td>
				19h30
			</td>
			<td>
				<input type="checkbox" name="supprimercours" value="supprimercours"></input>
			</td>
		</tr>
	</table>
	
	<input type="submit" class="bouton" name="supprimercours" value="Supprimer"/>
	
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
					</select>
				</td>
			</tr>
			<tr>
				<td>
				Heure de début
				</td>
				<td>
					<select name="heuredebut"> 
						<option value="08">08</option>
						<option value="09">09</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
					</select>
					h
					<select name="minutedebut">
						<c:forEach var="i" begin="00" end="55" step="5">
								<option value="${i}">${i}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Heure de fin</td>
				<td>
					<select name="heurefin"> 
						<option value="08">08</option>
						<option value="09">09</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
					</select>
					h
					<select name="minutefin">
						<c:forEach var="j" begin="00" end="55" step="5">
								<option value="${j}">${j}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
	</fieldset>
	
	<input type="submit" class="bouton" name="ajoutercours" value="Ajouter un cours"/>
        </div>   
		
    </body>
</html>