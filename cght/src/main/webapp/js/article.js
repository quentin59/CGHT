$(document).ready(function() {
	
	$("#valider").click(function(event){
		
		var contenu = $('#editor').elrte('val');
		$("#texte").val(contenu);
	});
	
	$("#categorie").change(function(event){
		if ($("select[name='categorie'] > option:selected").val()!="Vente de matériel")
		{
			$("#box-prix").css("display","none");
		}
		else
			{
			$("#box-prix").css("display","block");
			}
	});
	
});