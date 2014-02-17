<div class="menuLateral" id="menuAdmin">
	<ul>
		<li <% if (request.getParameter("pageAdminSelectionnee").equals("administration"))
				{ %> class="gras" <% } %>> <a href="administration">Administration</a></li>
		<li <% if (request.getParameter("pageAdminSelectionnee").equals("inscription"))
				{ %> class="gras" <% } %>> <a href="inscription">Inscription</a></li>
		<li <% if (request.getParameter("pageAdminSelectionnee").equals("gestionComptes"))
				{ %> class="gras" <% } %>> <a href="gestion-comptes">Gestion des comptes</a></li>
		<li <% if (request.getParameter("pageAdminSelectionnee").equals("gestionCours"))
				{ %> class="gras" <% } %>> <a href="gestion-cours">Gestion des cours</a></li>
		<li <% if (request.getParameter("pageAdminSelectionnee").equals("impression"))
				{ %> class="gras" <% } %>> <a href="impression">Impressions</a></li>
		<li>Importer/Exporter</li>
	</ul>
</div>