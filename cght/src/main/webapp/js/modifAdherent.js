$(document).ready(function() {

	var compteurCheque=0;
	
$("#ajoutercheque").click(function(event) {
		compteurCheque++;
		$("#compteurCheque").val(compteurCheque);
		$("#tablepaiements").append('<tr><td><input type="checkbox" name="payer'+compteurCheque+'" id="payer'+compteurCheque+'"/></td><td><input type="text" id="banque'+compteurCheque+'" name="banque'+compteurCheque+'" /></td><td><input type="text" id="numCheque'+compteurCheque+'" name="numCheque'+compteurCheque+'" /></td><td><input type="text" id="echeance'+compteurCheque+'" name="echeance'+compteurCheque+'" /></td><td><input type="number" id="montant'+compteurCheque+'" name="montant'+compteurCheque+'" /></td></tr>');
	});

});