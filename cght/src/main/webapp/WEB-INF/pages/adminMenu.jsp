<div class="menuLateral" id="menuAdmin">
	<ul>
		<li <% if (request.getParameter("pageAdminSelectionnee").equals("administration"))
				{ %> class="gras" <% } %>> <a href="/mawebapp/admin/administration">Administration</a></li>
		<li <% if (request.getParameter("pageAdminSelectionnee").equals("inscription"))
				{ %> class="gras" <% } %>> <a href="/mawebapp/admin/inscription">Inscription</a></li>
		<li <% if (request.getParameter("pageAdminSelectionnee").equals("gestionComptes"))
				{ %> class="gras" <% } %>> <a href="/mawebapp/admin/gestion-comptes">Gestion des comptes</a></li>
		<li <% if (request.getParameter("pageAdminSelectionnee").equals("gestionCours"))
				{ %> class="gras" <% } %>> <a href="/mawebapp/admin/gestion-cours">Gestion des cours</a></li>
		<li <% if (request.getParameter("pageAdminSelectionnee").equals("impression"))
				{ %> class="gras" <% } %>> <a href="/mawebapp/admin/impression">Impressions</a></li>
		<li <% if (request.getParameter("pageAdminSelectionnee").equals("exporter"))
				{ %> class="gras" <% } %>> <a href="/mawebapp/admin/exporter">Exporter</a></li>
	</ul>
</div>