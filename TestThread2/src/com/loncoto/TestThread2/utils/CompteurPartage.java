package com.loncoto.TestThread2.utils;

public class CompteurPartage {
	
	private int compteur;
	
	public CompteurPartage(){
		this.compteur = 0;
	}
	
//	public int augmenteCompteur(){
//		this.compteur = compteur + 1;
//		return this.compteur;
//	}
	
	//introduit une section critique
	//un seul thread peut l'executer à la fois
//	public synchronized int augmenteCompteur(){
//	this.compteur = compteur + 1;
//	return this.compteur;
//	}	
	
	
	//mutex ou verrou
	//synchronized (mutex)
	public int augmenteCompteur(){
	synchronized (this) {
		this.compteur = compteur + 1;
	}
		return this.compteur;
	}		

	@Override
	public String toString() {
		return "CompteurPartage [compteur=" + compteur + "]";
	}

	

}
