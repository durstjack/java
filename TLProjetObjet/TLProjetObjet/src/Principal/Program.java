package Principal;
import java.io.ObjectOutput;
import java.util.Arrays;

import metier.Livre;

public class Program {

	public static void main(String[] args) {
		//metier.Livre l1;
		Livre L1;
		L1 = new Livre();
		L1.titre = "La belle au bois dormant";
		L1.isbn = "3655236325";
		L1.prix = 22.63;
		
		Livre L2 = new Livre();
		L2.titre = "Le chateau de monpère";
		L2.isbn = "1423652362";
		L2.prix = 32.90;
		
		L1.afficher();
		
	}

}
