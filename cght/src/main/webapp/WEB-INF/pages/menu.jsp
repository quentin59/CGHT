<nav id="menuGeneral">
	<ul>
		<li <% if (request.getParameter("pageSelectionnee").equals("index"))
				{ %> class="active" <% } %>> <a href="/mawebapp/index">Accueil</a></li>
		<li <% if (request.getParameter("pageSelectionnee").equals("annonces"))
				{ %> class="active" <% } %>> <a href="/mawebapp/annonces">Petites annonces</a></li>
		<li <% if (request.getParameter("pageSelectionnee").equals("profil"))
				{ %> class="active" <% } %>> <a href="/mawebapp/profil">Mon Profil</a></li>
		<li <% if (request.getParameter("pageSelectionnee").equals("contact"))
				{ %> class="active" <% } %>> <a href="/mawebapp/contact">Contact</a></li>
	
	<% if (request.getSession().getAttribute("statut").equals("administrateur")) {%>
		<li <% if (request.getParameter("pageSelectionnee").equals("administration"))
				{ %> class="active" <% } %>> <a href="/mawebapp/admin/administration">Administration</a></li>
				<%} %>
	</ul>
</nav>