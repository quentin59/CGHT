<nav id="menuGeneral">
	<ul>
		<li <% if (request.getParameter("pageSelectionnee").equals("index"))
				{ %> class="active" <% } %>> <a href="index">Accueil</a></li>
		<li <% if (request.getParameter("pageSelectionnee").equals("annonces"))
				{ %> class="active" <% } %>> <a href="annonces">Petites annonces</a></li>
		<li <% if (request.getParameter("pageSelectionnee").equals("profil"))
				{ %> class="active" <% } %>> <a href="profil">Mon Profil</a></li>
		<li <% if (request.getParameter("pageSelectionnee").equals("contact"))
				{ %> class="active" <% } %>> <a href="contact">Contact</a></li>
		<li <% if (request.getParameter("pageSelectionnee").equals("administration"))
				{ %> class="active" <% } %>> <a href="administration">Administration</a></li>
	</ul>
</nav>