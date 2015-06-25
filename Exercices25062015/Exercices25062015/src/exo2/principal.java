package exo2;
import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Entrez un mot pour voir si c'est un palindrome");
		String saisie = reader.nextLine();
		
		System.out.println("Votre mot inversé devient : " + inverse(saisie));
		if( isPalindrome(saisie) )System.out.println("Le mot "+ saisie +" est un palindrome ");
		else System.out.println("Le mot "+ saisie +" n'est pas un palindrome");
	}
	
	public static String inverse(String chaine) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = chaine.length() - 1; i >= 0; i--)
			sb.append(chaine.charAt(i));
		
		return sb.toString();		
	}
	
	public static boolean isPalindrome(String mot) {		
		if ( mot.equals(inverse(mot)) ) return true;
		else return false;
		
	}	

}
