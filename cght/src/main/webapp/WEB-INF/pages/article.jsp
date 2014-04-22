<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    
	<!-- En-tête de la page -->
	<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Article</title>
		<link rel="stylesheet" href="css/style.css"/>
		<link rel="icon" type="image/jpg" href="img/cght.jpg" />
		<!-- JQuery -->
	<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	<!-- Javascript spécifique -->
	<script type="text/javascript" src="js/menu.js"></script>
	<script type="text/javascript" src="js/article.js"></script>
	
	<!-- jQuery and jQuery UI -->
	<script src="elrte-1.3/js/jquery-1.6.1.min.js" type="text/javascript" charset="utf-8"></script>
	<script src="elrte-1.3/js/jquery-ui-1.8.13.custom.min.js" type="text/javascript" charset="utf-8"></script>
	<link rel="stylesheet" href="elrte-1.3/css/smoothness/jquery-ui-1.8.13.custom.css" type="text/css" media="screen" charset="utf-8">

	<!-- elRTE -->
	<script src="elrte-1.3/js/elrte.min.js" type="text/javascript" charset="utf-8"></script>
	<link rel="stylesheet" href="elrte-1.3/css/elrte.min.css" type="text/css" media="screen" charset="utf-8">

	<script type="text/javascript" charset="utf-8">
		$().ready(function() {
			var opts = {
				cssClass : 'el-rte',
				// lang     : 'ru',
				height   : 200,
				toolbar  : 'complete',
				cssfiles : ['elrte-1.3/css/elrte-inner.css']
			}
			$('#editor').elrte(opts);
		})
	</script>
    </head>
    
    <body>

    	
    <!-- Header -->
    	<jsp:include page="header.jsp"/>
    	
    	
    
    
    	<!-- Menu de navigation -->
    	<jsp:include page="menu.jsp">
    	<jsp:param name="pageSelectionnee" value="index"/>
		</jsp:include>
    
    
    <div class="menuLateral">  
    
    </div>
    
    <div class="contenuPage">
    <form action="article" method="post">
    	<label for"titre">Titre</label>
    	<input type="text" name="titre" id="titre" style="width:400px;" value="${titre}"/>
    	<div id="editor">
    	${contenu}
    	</div>
    	<input type="text" value="" class="hidden" name="texte" id="texte" />
    	<input type="text" value="${id}" class="hidden" name="id" id="id" />
    	<input type="submit" value="Mettre en ligne l'article" class="bouton" id="valider"/>
    </form>
	</div>	
    </body>
</html>