$(document).ready(function() {

	var compteurCheque=0;
	var compteurAjouterCours=0;
	
$("#ajoutercheque").click(function(event) {
		compteurCheque++;
		$("#compteurCheque").val(compteurCheque);
		$("#tablepaiements").append('<tr><td><input type="checkbox" name="payer'+compteurCheque+'" id="payer'+compteurCheque+'"/></td><td><input type="text" id="banque'+compteurCheque+'" name="banque'+compteurCheque+'" /></td><td><input type="text" id="numCheque'+compteurCheque+'" name="numCheque'+compteurCheque+'" /></td><td><input type="text" id="echeance'+compteurCheque+'" name="echeance'+compteurCheque+'" /></td><td><input type="number" id="montant'+compteurCheque+'" name="montant'+compteurCheque+'" /></td></tr>');
	});

$("select[name='Cours-1']").change(function(event) {
	$("#horaires-1").empty();
	var coursSelectionne = $("select[name='Cours-1'] > option:selected").val();
	$.post("ajoutercours", {cours:coursSelectionne}).done(function(data){
		for (var i=0;i<data.length;i++)
		{
			$("#horaires-1").append('<option value="'+formater(data[i].heureDebut)+'h'+formater(data[i].minuteDebut)+' - '+formater(data[i].heureFin)+'h'+formater(data[i].minuteFin)+'">'+formater(data[i].heureDebut)+'h'+formater(data[i].minuteDebut)+' - '+formater(data[i].heureFin)+'h'+formater(data[i].minuteFin)+'</option>');
		}
	}).fail(function(){
		alert("un truc foire !");		
	});
});

$("select[name='Cours-2']").change(function(event) {
	$("#horaires-2").empty();
	var coursSelectionne = $("select[name='Cours-2'] > option:selected").val();
	$.post("ajoutercours", {cours:coursSelectionne}).done(function(data){
		
		for (var i=0;i<data.length;i++)
		{
			$("#horaires-2").append('<option value="'+formater(data[i].heureDebut)+'h'+formater(data[i].minuteDebut)+' - '+formater(data[i].heureFin)+'h'+formater(data[i].minuteFin)+'">'+formater(data[i].heureDebut)+'h'+formater(data[i].minuteDebut)+' - '+formater(data[i].heureFin)+'h'+formater(data[i].minuteFin)+'</option>');
		}
	}).fail(function(){
		alert("Il y a un problème, contactez l'administrateur.");		
	});
});

$("select[name='Cours-3']").change(function(event) {
	$("#horaires-3").empty();
	var coursSelectionne = $("select[name='Cours-3'] > option:selected").val();
	$.post("ajoutercours", {cours:coursSelectionne}).done(function(data){
		
		for (var i=0;i<data.length;i++)
		{
			$("#horaires-3").append('<option value="'+formater(data[i].heureDebut)+'h'+formater(data[i].minuteDebut)+' - '+formater(data[i].heureFin)+'h'+formater(data[i].minuteFin)+'">'+formater(data[i].heureDebut)+'h'+formater(data[i].minuteDebut)+' - '+formater(data[i].heureFin)+'h'+formater(data[i].minuteFin)+'</option>');
		}
	}).fail(function(){
		alert("Il y a un problème, contactez l'administrateur.");		
	});
});

$("#ajoutercours").click(function(event) {
	compteurAjouterCours++;
	if (compteurAjouterCours==1)
	{
		$("#cours-hidden-1").show();
	}
	else if (compteurAjouterCours==2)
	{
		$("#cours-hidden-2").show();
	}
	else if (compteurAjouterCours==3)
	{
		$("#cours-hidden-3").show();
	}
	else
	{
		$("#erreur-nombrecours").show();
	}
	
});

function formater(temps){
	
	var tempsFormate = temps;
	if (temps<10)
		{
		tempsFormate='0'+temps;
		}
	return tempsFormate;
}

});