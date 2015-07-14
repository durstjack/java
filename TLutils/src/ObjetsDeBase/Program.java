package ObjetsDeBase;

//import metier.Livre;


public class Program {

	public static void main(String[] args) {
		
		System.out.println(Livre.getCompteur());
		
		//metier.Livre l1;
		Livre l1;
		l1 = new Livre("20000 lieux sous les mers", "3435434354", 22.99);		
		l1.afficher();
		
		
		Livre l2 = new Livre();
		
		System.out.println(l1.getPrix());
		l1.setPrix(-45.5);
		
		l1.afficher();
		
		System.out.println(Livre.getCompteur());
		
	}

}
