$(document).ready(function() {  

		
//		//$('h2#titrep').hide();
//		$( "h2#titrep" ).animate({
//		    opacity: 0.95,
//			width: "800px",
//		    height: "40px"
//		  }, 5000, function() {
//			 // $( this ).after( "<div>Animation complete.</div>" );
//		  });
//		
//		$( "h2#titrep").css({ "font-size": "30px", "color": "green", "text-align": "center" });
	
	$("#ajaxTTcmd").click(function( event ){
			event.preventDefault();
			//ajaxdata url sur le serveur, data est dans la fonction de call backs et c'est la (dans data) ou on aura le resultat de la raquete ajax
			$.getJSON("ajaxdata", function(data){
				var proverbes = data.proverbes;
				var zone = $("#zoneAllProverbes");
		    	zone.empty();
				for(var i =0; i < proverbes.length; i++){					
					zone.append("<p>" + proverbes[i] + "</p>");
				}

			});
		
	});
    
	$("#ajaxUNcmd").click(function( event ){
		event.preventDefault();
		$.getJSON("ajaxdata", function(data){
			var proverbes = data.proverbes;
			var zone = $("#zoneProverbe");
		    var x = Math.floor((Math.random() * 9) + 1);
		    	zone.empty();
				zone.append("<p>" + proverbes[x] + "</p>");


		});
	
});

    
	
});