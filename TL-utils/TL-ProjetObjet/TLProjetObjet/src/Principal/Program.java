package Principal;
import java.io.ObjectOutput;
import java.util.Arrays;

import metier.Livre;

public class Program {

	public static void main(String[] args) {
		//metier.Livre l1;
		Livre L1;
		L1 = new Livre("La belle au bois dormant", "33363663", 19.32);
		L1.afficher();
		
	}

}
