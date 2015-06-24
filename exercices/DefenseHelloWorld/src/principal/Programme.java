package principal;

public class Programme {

	public static void main(String[] args) {
		System.out.println("Bonjour Thierry");
		
		int i = 32;
		System.out.println(i);
		
		int[] tab1 = {5, 15, 36};
		int[] tab2 = tab1;
		System.out.println("tab2[0] = " + tab2[0]);
		tab1[0] = 32;
		System.out.println("tab2[0] = " + tab2[0]);


	}

}
