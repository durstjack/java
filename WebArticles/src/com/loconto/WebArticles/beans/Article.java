package com.loconto.WebArticles.beans;

public class Article {

	private int id;
	private String libelle;
	private Double prix;
	private Double poids;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public Double getPoids() {
		return poids;
	}
	public void setPoids(Double poids) {
		this.poids = poids;
	}
	
	
	public Article() { this(0, "", 0.0, 0.0); }
	
	public Article(int id, String libelle, Double prix, Double poids) {
		super();
		this.setId(id);
		this.setLibelle(libelle);
		this.setPrix(prix);
		this.setPoids(poids);
	}
	
	
	
	
	
}
