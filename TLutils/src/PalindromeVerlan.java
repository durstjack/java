
public class PalindromeVerlan {

	public static void main(String[] args) {

		System.out.println("'serres' est un palindrome ? " + estPalindrome("serres"));
		System.out.println("'bonjour' est un palindrome ? " + estPalindrome("bonjour"));
		System.out.println("'abcdcba' est un palindrome ? " + estPalindrome("abcdcba"));
		System.out.println("'abedcba' est un palindrome ? " + estPalindrome("abedcba"));

	}
	
	public static boolean estPalindrome(String chaine) {
		int start = 0;
		int end = chaine.length() - 1;
		//on a "deux pointers", un au debut et un a la fin
		//on les compare, puis on avance d un cran etc etc
		while (start < end) {
			if (chaine.charAt(start) != chaine.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}

}
