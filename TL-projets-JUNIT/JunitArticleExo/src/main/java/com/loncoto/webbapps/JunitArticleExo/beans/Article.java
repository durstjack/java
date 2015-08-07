package com.loncoto.webbapps.JunitArticleExo.beans;

public class Article {

	private int id;
	private String nom;
	private double prix;
	private double poids;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		if(nom.length() > 2 && nom.length() < 50.0){		
			this.nom = nom;
		}
		else throw new RuntimeException();
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		if( prix > 0.0){
			this.prix = prix;			
		}
		else this.prix = 0.0;
		//else throw new RuntimeException();
	}
	public double getPoids() {
		return poids;
	}
	public void setPoids(double poids) {
		if(poids > 0.0 && poids < 20.0){
			this.poids = poids;
		}
		else throw new RuntimeException();
	}
	
	
	public Article(int id, String nom, double prix, double poids) {
		setId(id);
		setNom(nom);
		setPrix(prix);
		setPoids(poids);
	}
	
	
	
	
}
