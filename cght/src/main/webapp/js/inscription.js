$(document).ready(function() {
	
	$("#inscription").submit(function(event) {
		var licence = $("#licence").val();
		var licence1 = licence.substring(0,7);
		var licence2 = licence.substring(7);
		var regex = new RegExp(/([A-Za-z])/);
		if (licence.length!=8 || isNaN(licence1) || !regex.test(licence2))
			{
			$(".licenceIncorrecte").slideDown();
			event.preventDefault();
			}
		});
	
	$("select[name='Cours']").change(function(event) {
		var coursSelectionne = $("select[name='Cours'] > option:selected").val();
		$.post("ajoutercours", {cours:coursSelectionne}).done(function(data){
			for (var i=0;i<data.length;i++)
			{
				$("#horaires").append('<option value="'+formater(data[i].heureDebut)+'h'+formater(data[i].minuteDebut)+' - '+formater(data[i].heureFin)+'h'+formater(data[i].minuteFin)+'">'+formater(data[i].heureDebut)+'h'+formater(data[i].minuteDebut)+' - '+formater(data[i].heureFin)+'h'+formater(data[i].minuteFin)+'</option>');
			}
			
		}).fail(function(){
			alert("un truc foire !");		
		});
	});
	
	$("#ajoutercours").click(function(event) {
	$("table#informationTennis").append('<tr> <td>Cours 1</td> <td> <select name="Cours"> <option value="vide"></option> <c:forEach var="cours" items="${cours}" > <option value="${cours.jourCours}">${cours.jourCours}</option> </c:forEach> </select> <select name="Horaires" id="horaires"> </select> </td> </tr>');
	});
	
	
	function formater(temps){
		
		var tempsFormate = temps;
		if (temps==5 || temps==0 )
			{
			tempsFormate='0'+temps;
			}
		return tempsFormate;
	}
		
		
});