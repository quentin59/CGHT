<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    
	<!-- En-tête de la page -->
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Paramètres</title>
		<link rel="stylesheet" href="css/style.css"/>
		<link rel="icon" type="image/jpg" href="img/cght.jpg" />
		<!-- JQuery -->
	<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	<!-- Javascript spécifique -->
	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/parametres.js"></script>
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
			<li><a href="profil">Informations personnelles</a></li>
			<li><a href="parametres"><b>Paramètres</b></a></li>
		</ul>
	</nav>
    	
    	<!-- Corps de la page -->
    	<div class="contenuPage">
		<form id="formParametres" action="parametres" method="post">
		<fieldset class="profil">
		<legend>Modifier mes paramètres de connnexion</legend>
			<table class="col">
				<tr>
					<td>
						<label for="vieuxmail">Ancienne adresse mail</label>
					</td>
					<td>
						<input id="vieuxmail" name="vieuxmail" type="text" placeholder="Ancienne adresse mail"/>
					</td>
					<td>
						<label for="vieuxmdp">Ancien mot de passe</label>
					</td>
					<td>
						<input id="vieuxmdp" name="vieuxmdp" type="password" placeholder="Ancien mot de passe"/>
					</td>
				</tr>
				<tr>
					<td>
						<label for="newmail">Nouvelle adresse mail</label>
					</td>
					<td>
						<input id="newmail" name="newmail" type="text" placeholder="Nouvelle adresse mail"/>
					</td>
					<td>
						<label for="newmdp">Nouveau mot de passe</label>
					</td>
					<td>
						<input id="newmdp" name="newmdp" type="password" placeholder="Nouveau mot de passe"/>
					</td>
				</tr>
				<tr>
				</tr>
				<tr>		
					<td>
						<label for="newmail2">Retapez votre nouvelle adresse mail</label>
					</td>
					<td>
						<input id="newmail2" name="newmail2" type="text" placeholder="Nouvelle adresse mail"/>
					</td>
					<td>
						<label for="newmdp2">Retapez votre nouveau mot de passe</label>
					</td>
					<td>
						<input id="newmdp2" name="newmdp2" type="password" placeholder="Nouveau mot de passe"/>
					</td>
				</tr>
				<tr><td colspan="3"><div id="erreurMail" class="hidden" style="color:red;" >Les nouvelles adresses mails sont différentes.</div></td></tr>
				<tr><td colspan="3"><div id="erreurPassword" class="hidden" style="color:red;" >Les nouveaux mots de passe sont différents.</div></td></tr>
				<tr style="color:red;"><td colspan="3"><%
       if(request.getAttribute("identifiantsErreur")!=null) {
           out.print((String)request.getAttribute("identifiantsErreur"));
       }%></td></tr>
			</table>
		</fieldset>
		
		<input type="submit" id="modifierInformations" name="modifierInformations" value="Enregistrer les modifications"/>
	</form>
        </div>   
		
    </body>
</html>