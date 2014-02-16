<div class="menuLateral" id="menuAdmin">
	<ul>
		<li <% if (request.getParameter("pageAdminSelectionnee").equals("administration"))
				{ %> class="active" <% } %>> <a href="administration">Administration</a></li>
		<li <% if (request.getParameter("pageAdminSelectionnee").equals("inscription"))
				{ %> class="active" <% } %>> <a href="inscription">Inscription</a></li>
		<li <% if (request.getParameter("pageAdminSelectionnee").equals("gestionComptes"))
				{ %> class="active" <% } %>> <a href="gestion-comptes">Gestion des comptes</a></li>
		<li>Gestion des cours</li>
		<li>Impressions</li>
		<li>Importer/Exporter</li>
	</ul>
</div>