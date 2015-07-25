package elements;

public class Pion extends Pieces {
	
	@Override
	//la piece renverra un tableau avec les nouvelles coordonnées possibles pour son deplacement
	public String getDeplacement() {
		String[] coordonnees = { String.valueOf( this.getPositionX() ), String.valueOf( this.getPositionY() ) };
		
		// le sens du pion dépend de sa couleur
		String direction = (this.getCouleur().equals("blanc")) ? "haut" : "bas" ;
		String deplacements = "";
		
		if( direction.equals("haut") ){
			
		}
		return "A1";
	}
	public String getPieceName(){ return "pion"; }
	
	public Pion(String couleur, int positionX, int positionY){
		super( couleur, positionX, positionY );
		
	}

}
