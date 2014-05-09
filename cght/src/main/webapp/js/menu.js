$(document).ready(function() {
	
	window.onresize= function(){
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
	var largeur=$(document).width();
	var largeurMenuLateral=$(".menuLateral").width();
	$(".contenuPage").css("width",largeur-largeurMenuLateral-96);
	};
});