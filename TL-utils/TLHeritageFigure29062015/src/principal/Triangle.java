package principal;

public class Triangle extends Figure {

	String nom;
	int taille;	

	private String getNom() {return nom;}
	private void setNom(String nom) { this.nom = nom; }
	private int getTaille() { return taille; }
	private void setTaille(int taille) { this.taille = taille; }
	
	public Triangle( String nom, int taille) {
		setNom(nom);
		setTaille(taille);
	}
	
	public void afficher(){
		System.out.println("Je suis le triangle " + getNom() + " Longueur de " + getTaille());
	}
	

}
