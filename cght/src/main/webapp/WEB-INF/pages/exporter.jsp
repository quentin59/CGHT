<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    
	<!-- En-tête de la page -->
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Exporter</title>
        <link rel="icon" type="image/jpg" href="../img/cght.jpg" />
		<link rel="stylesheet" href="../css/style.css"/>
		<!-- JQuery -->
	<script type="text/javascript" src="../js/jquery-1.10.2.js"></script>
	<!-- Javascript spécifique -->
	<script type="text/javascript" src="../js/menu.js"></script>
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
    	<jsp:param name="pageAdminSelectionnee" value="exporter"/>
		</jsp:include>
    	
    	
    	<!-- Corps de la page -->
		
        <div class="contenuPage">
			<form style="text-align:center;" action="exporter" method="post">
				<input type="submit" value="Exporter la base  de données" />
				
				<%
					if(request.getAttribute("acknowledge")!=null) 
					{
						%><p style="text-align:center; color:white; background-color:red; width:220px; padding:5px;"><%
						  out.print((String)request.getAttribute("acknowledge"));
						%></p><%
					}
			  	%>
			</form>
        </div>   
		
    </body>
</html>