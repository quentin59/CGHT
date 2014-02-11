<!DOCTYPE html>
<html>
    
	<!-- En-tête de la page -->
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Les petites annonces</title>
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
    	<jsp:param name="pageSelectionnee" value="annonces"/>
		</jsp:include>
		
		<div class="menuLateral">  
			<ul>
				<li>Petites annonces</li>
    		<%--
    			<c:forEach var="" items="${}" varStatus="" >
					<li>${}</li>
					<ul>
						<c:forEach var="" items="${[.index]}">
							<li> ${}</li>						
						</c:forEach> 
					</ul>
				</c:forEach> --%>
			</ul>
   		</div>
		<!-- Corps de la page -->
		
    <div class="contenuPage">
		<h2>Les petites annonces</h2>
		
    </div>       
		
    </body>
</html>