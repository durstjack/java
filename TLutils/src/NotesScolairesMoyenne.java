import java.util.Scanner;


public class NotesScolairesMoyenne {

	public static void main(String[] args) {
		
		// variable utilisée lors de la saisie 
		boolean erreur;
		
		Scanner reader = new Scanner(System.in);		
		System.out.println("Entrez le nombre de notes");		
		String nbrNotesStr = reader.nextLine();
		
		int nbrNotes = Integer.parseInt(nbrNotesStr);
		double[] tableauNotes = new double[nbrNotes];
		
		for(int i = 0; i < nbrNotes; i++){
			do{
				System.out.println("Entrez le note n° " + ( i + 1) );	
				tableauNotes[i] = Double.parseDouble(reader.nextLine());
				if ( tableauNotes[i] < 0 || tableauNotes[i] >20 ){ erreur = true; System.err.println("La note doit etre entre 0 et 20 !!"); }
				else{ erreur = false; }
			}
			while( erreur == true );

		}
		
		
		//Afficher le tableau dans un syso gâce a la methode toString de Arrays
		//System.out.println(Arrays.toString(tableauNotes));
				
		double somme = 0;
		double minus = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		
		for (double x : tableauNotes){ 
				somme += x;
				minus = ( x < minus) ? x : minus;
				max = ( x > max) ? x : max;	
		}
		
		//calcul de la moyenne
		double moyenne = somme / nbrNotes;
	
		//calcul des notes supérieures à la moyenne
		int nbrNotesSupMoyenne = 0;	
		for (double x : tableauNotes){ 
				if( x > moyenne ){ nbrNotesSupMoyenne++; }
		}	
		
		System.out.println("La moyenne des notes = " + moyenne);	
		System.out.println("La note la plus basse est = " + minus);
		System.out.println("La note la plus haute est = " + max);
		System.out.println("Il y a " + nbrNotesSupMoyenne +" note(s) superieur a la moyenne");
	}


}


