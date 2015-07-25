/*
 *  écrire une classe rectangle représentant un rectangle (x1,y1, x2, y2)
 - fournir plusieurs constructeurs, une méthode getAire() qui calcule l'aire
 - fournir une méthode permettant d'afficher en texte ce rectangle
 - fournir une méthode statique déterminant s'il y a une collision entre 2 rectangles
 * */
package exo1;

public class Rectangle {
	
	private int coinHautGaucheX;
	private int coinHautGaucheY;
	private int coinBasDroiteX;
	private int coinBasDroiteY;
	
			
	public int getCoinHautGaucheX() {
		return coinHautGaucheX;
	}
	private void setCoinHautGaucheX(int coinHautGaucheX) {
		this.coinHautGaucheX = (coinHautGaucheX >= 0) ? coinHautGaucheX : 0;
	}

	public int getCoinHautGaucheY() {
		return coinHautGaucheY;
	}
	private void setCoinHautGaucheY(int coinHautGaucheY) {
		this.coinHautGaucheY = (coinHautGaucheY >= 0) ? coinHautGaucheY : 0;
	}


	public int getCoinBasDroiteX() {
		return coinBasDroiteX;
	}
	private void setCoinBasDroiteX(int coinBasDroiteX) {
		this.coinBasDroiteX = (coinBasDroiteX >= 0) ? coinBasDroiteX : 0;
	}

	public int getCoinBasDroiteY() {
		return coinBasDroiteY;
	}
	private void setCoinBasDroiteY(int coinBasDroiteY) {
		this.coinBasDroiteY = (coinBasDroiteY >= 0) ? coinBasDroiteY : 0;
	}
	//
	public double[] getMesures(){
		return new double[]{ this.coinBasDroiteX - this.coinHautGaucheX, this.coinBasDroiteY - this.coinHautGaucheY };
	}
	//fonction pour calculer l'Aire
	public double getAire(){
		int Longueur = this.coinBasDroiteX - this.coinHautGaucheX;
		int Largeur = this.coinBasDroiteY - this.coinHautGaucheY;
		double aire = Math.abs(Longueur*Largeur);
		return aire;
	}
	//fonction pour afficher
	public void affiche(){
		double Longueur = this.getMesures()[0];
		double Largeur = this.getMesures()[1];
		String output;
		output = "";
		for(int j = 0; j <= Largeur; j++){
			for(int i = 0; i <= Longueur; i++){
				output += "X";			
			}
			output += "\n";
		}
		System.out.println(output);
	}
	
	public Rectangle(){
		this( 1, 1, 4, 4);			
	}

	public Rectangle(int coinHautGaucheX, int coinHautGaucheY, int coinBasDroiteX, int coinBasDroite) {
		super();
		setCoinHautGaucheX(coinHautGaucheX);
		setCoinHautGaucheY(coinHautGaucheY);
		setCoinBasDroiteX(coinBasDroiteX);
		setCoinBasDroiteY(coinBasDroite);
	}

}
