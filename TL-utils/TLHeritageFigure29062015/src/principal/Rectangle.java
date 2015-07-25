package principal;

public class Rectangle extends Figure {
	String nom;
	int tailleX;
	int tailleY;
	
	

	private String getNom() {return nom;}
	private void setNom(String nom) { this.nom = nom; }
	private int getTailleX() { return tailleX; }
	private void setTailleX(int tailleX) { this.tailleX = tailleX; }
	private int getTailleY() { return tailleY; }
	private void setTailleY(int tailleY) { this.tailleY = tailleY; }
	
	public Rectangle( String nom, int tailleX, int tailleY) {
		setNom(nom);
		setTailleX(tailleX);
		setTailleY(tailleY);
	}
	
	public void afficher(){
		System.out.println("Je suis le rectangle " + getNom() + " Longueur de " + getTailleX() + " Largueur de " + getTailleY());
	}
	

}
