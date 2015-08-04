package com.loncoto.webapps.SpringCamelot.beans;
//class qui est l'advice
public class Menestrel {
	
	public void chanteAvant(IChevalier chevalier){
		System.out.println("tralalallala... sir " + chevalier.getNom() + " part couragesement en quete!! ");
	}
	
	public void chanteApres(IChevalier chevalier){
		System.out.println("oyez oyez... sir " + chevalier.getNom() + " revient fierement de sa quete!! ");
	}
	

}
