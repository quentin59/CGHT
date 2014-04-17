$(document).ready(function() {
	
	$("#toutselectionner").click(selection);
});


var selection = function(){
	
	if ($(".supprimer:checked").size()!=$("tr").size()-1)
	{
	$(".supprimer").attr("checked",true);
	}
else
	{
	$(".supprimer").attr("checked",false);
	}
};