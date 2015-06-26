package metier;

public class Livre {
	
	// en mettant l attribut en statique il n'est plus lié à l'oblet mais a la classe
	//de plus on peut y acceder en faisant Livre.nbLivres sans instance, directement.
	//mais on le remet en privée pour plus de securité et on construit un setter
	private static int nbLivres = 0;
	public static int getNbLivres(){
		return nbLivres;
	}
	
	private String titre;
	private String isbn;
	private double prix;
	
	//on peut generer les getters et les setters grace a eclipse dans => source => "generate getters and setters"
	//cas nos attribut sont des boolean on peut a la place du "get" mettre "is" par ex isbisextile()
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getIsbn() {
		return isbn;
	}
	private void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPrix(){
			return this.prix;
	}
	//encapsulation des attributs grace à des getteurs et des setters
	public void setPrix( double prix){
		this.prix = ( prix >= 0 ) ? prix : 0.0 ;
	}
	
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
		/*
		this.titre = titre;
		this.isbn = isbn;
		this.prix = prix;
		*/
		//on utilise plutot les setters pour eveiter les erreurs par ex prix négatifs
		setPrix(prix);
		setIsbn(isbn);
		setTitre(titre);
		nbLivres++;
	}
	
	public void afficher(){
		System.out.println(this.titre + ", "+ prix +" euros");
	}
	

}
