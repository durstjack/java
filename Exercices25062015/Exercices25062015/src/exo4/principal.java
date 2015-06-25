package exo4;

import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int valeur = 0;
		do{
		System.out.println("Entrez une valeur comprise entre 1 et 999");
		String saisie = reader.nextLine();
		valeur = Integer.parseInt(saisie);
		}while( valeur < 1 || valeur > 999 );
		
		int valeurTemp = valeur;
		int centaines = 0, dizaines = 0, unites = 0;
		int situation;
		
		
		while( valeurTemp > 0 ){
			
			if( valeurTemp >= 100  ){  situation = 100; } //le nombre saisi a des centaines
			else if( valeurTemp >= 10  ){  situation = 10; }//le nombre saisi a des dizaines
			else{ situation = 1; }			
			
			switch (situation){
			
			case 1:
					unites++;
					valeurTemp = valeurTemp - 1;
					break;
					
			case 10:
					dizaines++;
					valeurTemp = valeurTemp - 10;
					break;
					
			case 100:					
					centaines++;
					valeurTemp = valeurTemp - 100;
					break;
					
			default:
				
					break;		
			}

		}// fin du while
		System.out.println("Dans votre nombre il y a "+ centaines +" centaines, "+ dizaines +" dizaines, et "+ unites+" unités" );
		
		String strChiffreRomain = "";
		if( centaines > 0 ){ 
			if centaines
			
		}
		
	}

}
