$(document).ready(function() {
	
	var compteurAjouterCours=0;
	var compteurCheque=1;
	
	$("#inscription").submit(function(event) {
		
		//Controle du format du numéro de licence ainsi que de la date.
		var licence = $("#licence").val();
		var licence1 = licence.substring(0,7);
		var licence2 = licence.substring(7);
		var regex = new RegExp(/([A-Za-z])/);
		var jour = $("select[name='jour'] > option:selected").val();
		var mois = $("select[name='mois'] > option:selected").val();
		var annee = $("select[name='annee'] > option:selected").val();
		if (jour=="jour" || mois=="mois" || annee=="annee")
		{
		$(".dateNaissanceIncorrecte").slideDown();
		event.preventDefault();
		}
		if (licence.length!=8 || isNaN(licence1) || !regex.test(licence2))
			{
			$(".licenceIncorrecte").slideDown();
			event.preventDefault();
			}
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
			alert("Il y a un problème, contactez l'administrateur.");		
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
			$("#cours-hidden-2").show();
		}
		else if (compteurAjouterCours==2)
		{
			$("#cours-hidden-3").show();
		}
		else
		{
			$("#erreur-nombrecours").show();
		}
		
	});
	
	$("#ajoutercheque").click(function(event) {
		compteurCheque++;
		$("#compteurCheque").val(compteurCheque);
		$("#tablepaiements").append('<tr><td><input type="checkbox" name="payer'+compteurCheque+'" id="payer'+compteurCheque+'"/></td><td><input type="text" id="banque'+compteurCheque+'" name="banque'+compteurCheque+'" /></td><td><input type="text" id="numCheque'+compteurCheque+'" name="numCheque'+compteurCheque+'" /></td><td><input type="text" id="echeance'+compteurCheque+'" name="echeance'+compteurCheque+'" /></td><td><input type="number" id="montant'+compteurCheque+'" name="montant'+compteurCheque+'" /></td></tr>');
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