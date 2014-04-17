<!DOCTYPE html>
<html>
    
	<!-- En-t�te de la page -->
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Contact</title>
		<link rel="stylesheet" href="css/style.css"/>
		<link rel="icon" type="image/jpg" href="img/cght.jpg" />
		<!-- JQuery -->
	<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	<!-- Javascript sp�cifique -->
	<script type="text/javascript" src="js/menu.js"></script>
    </head>
    
    <body>
    <!-- Header -->
    	<jsp:include page="header.jsp"/>
    
    
    	<!-- Menu de navigation -->
    	<jsp:include page="menu.jsp">
    	<jsp:param name="pageSelectionnee" value="contact"/>
		</jsp:include>
    
    <div class="menuLateral">
		<ul>
			<li>Contact</li>
		</ul>
	</div>
    	<!-- Corps de la page -->
		
		<div class="contenuPage">
			<form id="contact" action="contact" method="post">
				<h2>Formulaire de contact</h2>
				<table>
					<tr>
						<td>
							<label for="nom">Nom</label>
						</td>
						<td>
							<input type="text" id="nom" name="nom" required />
						</td>
					</tr>
					<tr>
						<td>
							<label for="prenom">Pr�nom</label>
						</td>
						<td>
							<input type="text" id="prenom" name="prenom" required />
						</td>
					</tr>
					<tr>
						<td>
							<label for="mail">E-mail</label>
						</td>
						<td>
							<input type="email" id="mail" name="mail" required />
						</td>
					</tr>
				</table><br>
				
				
				<label for="sujet">Sujet :</label></br>
				<input type="text" id="sujet" name="sujet" required size="37" /></br></br>
				<label for="message">Message :</label></br>
				<textarea id="message" name="message" cols="35" rows="5" required></textarea></br></br>
				<input type="submit" value="Envoyer"/>
			</form>
        </div>   
		
    </body>
</html>