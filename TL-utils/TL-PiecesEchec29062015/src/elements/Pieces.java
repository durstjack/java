package elements;

public abstract class Pieces {
	
	// Attributs
	private String couleur;
	private int positionX;
	private int positionY;
	private boolean isCapturer;
	
	// Getters et Setters
	public String getCouleur() { return couleur; }
	public void setCouleur(String couleur) { this.couleur = couleur; }
	public int getPositionX() {	return positionX; }
	public void setPositionX(int positionX) { this.positionX = positionX; }
	public int getPositionY() { return positionY; } 
	public void setPositionY(int positionY) { this.positionY = positionY; }
	public boolean isCapturer() { return isCapturer; }
	public void setIsCapturer(boolean isCapturer) { this.isCapturer = isCapturer; }
	
	//Constructeurs
	public Pieces(String Couleur, int positionX, int positionY){
		setCouleur(Couleur);
		setPositionX(positionX);
		setPositionY(positionY);
		setIsCapturer(false);		
	}
	
	//methode abstraite redefinie pour chaque piece
	public abstract String getDeplacement();
	public abstract String getPieceName();
	
	public void seFaireCapturer(){
		//TODO
	}	
	public void capturer(Pieces pieceACapturer){
		pieceACapturer.setIsCapturer(true);
	}
	public void moveTo( int positionX, int positionY){
		//TODO
	}
	
	
	

}
