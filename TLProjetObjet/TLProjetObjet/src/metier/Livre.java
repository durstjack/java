package metier;

public class Livre {
	public String titre;
	public String isbn;
	public double prix;
	
	//java fournit un constructeur par défault, sauf à partir du moment ou on en definit un
	//il ne definit plus de constructeur par défault
	//le constructeur n a pas de type de retour, doit avoir le meme nom que la classe
	public Livre(){
	//si on fait un chainage de constructeur  on doit commencer par ca pas de code avant genre syso etc...
	// on utilise this()
		this("inconnu", "00000", 0.01);		
	/*	
		System.out.println("Construction du livre........");
		titre = "inconnu";
		isbn = "--------";
		prix = 0;
	*/
	}
	//on peut avoir plusieurs commentaires, comme pour les methodes si la signature n'est pas la même
	// on rajoute this pour lever l'anbiguité avec la variable locale et l'attribut de l'objet
	public Livre(String titre, String isbn, double prix){
		System.out.println("Construction du livre........");
		this.titre = titre;
		this.isbn = isbn;
		this.prix = prix;
	}
	
	public void afficher(){
		System.out.println(this.titre + ", "+ prix +" euros");
	}
	

}
