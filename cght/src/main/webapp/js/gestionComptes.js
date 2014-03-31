$(document).ready(function() {
	
	$("#toutselectionner").click(function(event){
		alert($(".supprimer:checked").size());
		if ($(".supprimer:checked").size()!=6)
			{
			$(".supprimer").attr("checked","checked");
			}
		else
			{
			$(".supprimer").removeAttr("checked");
			}
		
	});
});