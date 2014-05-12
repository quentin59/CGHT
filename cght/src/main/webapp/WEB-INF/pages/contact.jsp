<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    
	<!-- En-tête de la page -->
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Contact</title>
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
    	<jsp:param name="pageSelectionnee" value="contact"/>
		</jsp:include>
    
    <div class="menuLateral">
		<ul>
			<li>Contact</li>
		</ul>
	</div>
    	<!-- Corps de la page -->
		
		<div class="contenuPage">
			<form id="contact" action="contact" method="post" style="margin-left:100px;">
				<h2>Formulaire de contact</h2>
				<%
       				if(request.getAttribute("acknowledge")!=null) 
       				{
       					%><p style="color:white; background-color:red; width:220px; padding:5px;"><%
         			  out.print((String)request.getAttribute("acknowledge"));
       					%></p><%
       				}
  				 %>
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
							<label for="prenom">Prénom</label>
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
				<input type="text" id="sujet" name="sujet" required size="62" /></br></br>
				<label for="message">Message :</label></br>
				<textarea id="message" name="message" cols="60" rows="10" required></textarea></br></br>
				<input type="submit" value="Envoyer"/>
			</form>
        </div>   
		
    </body>
</html>