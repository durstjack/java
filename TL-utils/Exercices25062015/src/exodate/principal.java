package exodate;

import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
	
		Scanner reader = new Scanner(System.in);		
		
		System.out.println("Entrez une année :");
		int annee = Integer.parseInt(reader.nextLine());
		System.out.println("Entrez un mois :");
		int mois = Integer.parseInt(reader.nextLine());
		
		System.out.println(getCalendrier(mois, annee));

		
	}
	// renvoi un calendrier ss forme de string
	public static String getCalendrier( int mois, int annee){
	
		String CalendrierHeader = getHeader(mois, annee);
		String CalendrierCorps = getCoprs(mois, annee);
		String Calendrier = CalendrierHeader + CalendrierCorps;
		return Calendrier;
		
	}
	// renvoi le header du calendrier forme de string
	public static String getHeader( int mois, int annee){
		
		String header = "----------------------------\n";
		header += "    " + getNomMois(mois) + " " + annee;
		header += "\n----------------------------\n";
		header += "LUN MAR MER JEU VEN SAM DIM \n";		
		return header;

	}
	// renvoi le corps du calendrier forme de string
	public static String getCoprs( int mois, int annee){
		
		String corps = "----------------------------\n";
		int jourDebut = jourDebutMois(mois, annee);		
		int nbJours = nbJoursMois(mois, annee);
		System.out.println(" ");
		
		for(int marge = 0; marge < jourDebut; marge++ ){
			corps += "    ";
		}
		for (int i = 1; i <= nbJours; i++) {
			//on adapte la marge si le chiffre est sur deux digits			
			corps += (i >= 10) ? i + "  " : i + "   " ;
			if( ( i + jourDebut) % 7 == 0 ) corps += "\n";
		}
		return corps;
	}	
	//renvoi le nom du mois string
	public static String getNomMois( int mois){
		String output ="";
		String[] tabMois = {"janvier", "fevrier", "mars", "avril", "mai", "juin", "juillet", "aout", "septembre", "octobre", "novembre", "decembre" };
		if( mois >=1 && mois <= 12 ){ output = tabMois[(mois - 1 )]; }
		return output;
	}
	//renvoi true si annee bisextille
	public static boolean isBisextile( int annee ){
		if ( (annee % 4 == 0) && (annee % 100 != 0)  ){ return true; }
		else if ( (annee % 400 == 0)  ){ return true; }
		else{ return false; }
		//on peut le faireen une ligne un test renvoi tru ou false
		//return ( (annee % 4 == 0 && annee % 100 != 0) || annee % 400 == 0 );
	}
	//fonction nbjourmois renvoi int
	public static int nbJoursMois( int mois, int annee ){
		int[] tabJoursDesMois = { 0,31,28,31,30,31,30,31,31,30,31,30,31};
		if(!isBisextile(annee)){ return tabJoursDesMois[mois]; }
		else{
			if(mois == 2){return 29; }
			else { return tabJoursDesMois[mois]; }
		}
	}
	//fonction jourDebutMois renvoi un int 0 pour lundi, 1 pour lundi
	public static int jourDebutMois(int mois, int annee){
		
		//compter le nb de jours sont passés depuis un jour de reference
		//jour de reference 1 janvier 1800 mercredi
		int jours = 2; //on commence un mercredi
		
		//on commence une boucle 
		for( int an = 1800; an < annee; an++ ){
			jours += ( isBisextile(an) )? 366 : 365;
		}
		for( int m = 1; m < mois; m++ ){
			jours += nbJoursMois(m, annee);
		}
		
		//puis modulo 7 pour savoir quel j on est
		int jourDebut = jours % 7;
		return jourDebut;
		
	}

	
}
