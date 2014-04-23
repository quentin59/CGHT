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
<body id="connexion"  
style="
	background-image:url('http://img15.hostingpics.net/pics/818190cght.jpg');
	background-attachment:fixed;
	background-repeat:no-repeat;
	background-position:center;
	background-size:contain;">
	
	<div class="box" style="position:relative;
	width:220px;
	height:100%;
	margin:15% 56%;
	background-color:rgba(250,250,250,0.5);
	border:3px solid white;
	padding:10px;">
	<p style="text-align:center;"><%
       if(request.getAttribute("loginError")!=null) {
           out.print((String)request.getAttribute("loginError"));
       }else{
           out.print("Merci de vous connecter !");
       }
   %></p>
   		<form method="post" action="connexion" >
		<p style="text-align:center;">
			<input class="connexion" type="text" name="login" placeholder="Identifiant (adresse mail)" size="25px" required /><br/><br/>
			<input class="connexion" type="password" name="password" placeholder="Mot de passe" size="25px" required /><br/><br/>
			<a href="">Mot de passe oublié ?</a><br/><br/><br/><br/>
			<input id="maintenirConnexion" class="connexion" type="checkbox" />
			<label for="maintenirConnexion">Maintenir la connexion</label><br/>
			<input id="modifier" style="border-radius:0px;
	background-color:rgb(200,200,200);
	border:1px solid black;
	padding:3px 5px;
	cursor:pointer;"type="submit" value="Se connecter"/>
		</p>
		</form>
	</div>
	
</body>

</html>