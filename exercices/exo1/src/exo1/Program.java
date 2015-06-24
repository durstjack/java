package exo1;

import java.util.*;

public class Program {
	
	public static void main(String[] args) {
		
		// le reader lit depuis le clavier
		Scanner reader = new Scanner(System.in);
		
		System.out.println("quelle choix pour la figure 1 ou 2 ?");		
		String saisieChoix = reader.nextLine();		
		int choix = Integer.parseInt(saisieChoix);
		
		System.out.println("quelle taille voulez vous ?");		
		String saisie = reader.nextLine();	
		// je convertie la saisie en entier
		int compteur = Integer.parseInt(saisie);
		
		switch(choix){
			
			case 1 :
						for(int j = compteur; j > 0; j--){
							
							for(int i = 0; i < compteur; i++){
								System.out.print("X");
							}
							compteur--;
							System.out.println("");							
						}
						break;
				
			case 2:
						// on sauvegarde la taille
						int taille = compteur;
						
						for(int j = compteur; j > 0; j--){
							
							for(int i = 0; i < compteur; i++){
								
								// on utilise une variable caratere pour tester la ligne en cours
								String caractere;
								if ( i == 0 || i == (compteur-1) || j == taille ){
									caractere = "X";
								}else{
									caractere = "O";
								}
									
								System.out.print(caractere);
							}
							compteur--;
							System.out.println("");
							
						}				
						break;
						
			case 3:
						// on sauvegarde la taille
						int tailleCompteur = compteur;
						int numLigne = 0;
						
						for(int j = compteur; j > 0; j--){
							
							int marge = (tailleCompteur/2) - numLigne;
							numLigne++;
							for(int i = 0; i < marge; i++){
								System.out.print(" ");						

							}
							int nbCaractere = tailleCompteur - (marge * 2);
							for(int n = 0; n <= nbCaractere; n++){
								System.out.print("X");						

							}

							
							compteur--;
							System.out.println("");
							
						}				
						break;			
		
		}
		

		
	
	}

}
