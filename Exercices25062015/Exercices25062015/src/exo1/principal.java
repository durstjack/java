package exo1;

import java.util.Scanner;

public class principal {
	
	public static void main(String[] args) {
	
	int[] tableau1 = { 2, 6, 7, 8, 1, 12 };
	int[] tableau2;
	tableau2 = new int[]{ 1, 3, 6, 7, 42, 47 };
	
	System.out.println("le tableau 1 a "+ nbImpaire(tableau1)+" valeurs impaires ");
	System.out.println("le tableau 2 a "+ nbImpaire(tableau2)+" valeurs impaires ");

	}
	
	public static int nbImpaire(int[] tableau) {
		int nbImpaire = 0;
		for( int valeur : tableau ){
			if( valeur % 2 != 0 ){ nbImpaire++; }
		}
		return nbImpaire;
	}

}
