$(document).ready(function() {
	
	$("#valider").click(function(event){
		
		var contenu = $('#editor').elrte('val');
		$("#texte").val(contenu);
	});
});