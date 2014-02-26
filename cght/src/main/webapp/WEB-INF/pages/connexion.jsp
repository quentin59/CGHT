<!DOCTYPE html>
<html>

<!-- En-tête de la page -->
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Bienvenue</title>
	<link rel="stylesheet" href="css/style.css" content="text/css"/>
	<link rel="icon" type="image/jpg" href="img/cght.jpg" />
</head>

<!-- Corps de la page -->	
<body id="connexion">
	
	<div class="box">
	<%
       if(request.getAttribute("loginError")!=null) {
           out.print((String)request.getAttribute("loginError"));
       }else{
           out.print("Merci de vous connecter !");
       }
   %>
   		<form method="post" action="connexion" >
		<p>
			<input class="connexion" type="text" name="login" placeholder="Identifiant (adresse mail)" size="25px" required /><br/><br/>
			<input class="connexion" type="text" name="password" placeholder="Mot de passe" size="25px" required /><br/><br/>
			<a href="">Mot de passe oublié ?</a><br/><br/><br/><br/>
			<input id="maintenirConnexion" class="connexion" type="checkbox" />
			<label for="maintenirConnexion">Maintenir la connexion</label><br/>
			<input id="modifier" type="submit" value="Se connecter"/>
		</p>
		</form>
	</div>
	
</body>

</html>