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
			<li>Informations personnelles</li>
			<li>Paramètres</li>
		</ul>
	</nav>
    	<!-- Corps de la page -->
		<div class="contenuPage">
			<h2>Mon profil</h2>
        </div>   
		
    </body>
</html>