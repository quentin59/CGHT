$(document).ready(function() {
	var hauteur=$(document).height();
	var hauteurBoite=$(".contenuPage").height();
	if (hauteur<hauteurBoite)
		{
		$(".menuLateral").css("height",hauteurHeader);
		}
	else
		{
		$(".menuLateral").css("height",hauteur-$("#header").height()-96);
		}
});