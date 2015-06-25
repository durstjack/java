package exo3;

import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Entrez la somme de départ");
		String saisie = reader.nextLine();
		double sommeDepart = Double.parseDouble(saisie);
		System.out.println("Entrez le taux d'interet en %");
		saisie = reader.nextLine();
		double taux = Double.parseDouble(saisie);
		double tauxSaisie = taux;
		taux = 1 + (taux / 100) ;
		System.out.println("Entrez la somme à atteindre");
		saisie = reader.nextLine();
		double sommeFinale = Double.parseDouble(saisie);
		
		double nbAnnee = 0.0;
		double sommeTemp = sommeDepart;
		
		for( ; sommeTemp <= sommeFinale;){
			sommeTemp = sommeTemp*taux;
			nbAnnee++;
		}
		taux = tauxSaisie;
		
		System.out.println("Il faudra "+ nbAnnee +" annees pour atteindre la somme de "+ sommeFinale +"€ avec une somme de depart de "+ sommeDepart +"€ et un interet de " + taux + "%");

	}

}
