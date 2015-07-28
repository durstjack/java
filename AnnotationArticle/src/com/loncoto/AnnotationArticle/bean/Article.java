package com.loncoto.AnnotationArticle.bean;

import com.loncoto.AnnotationArticle.utils.FormAnnotation;

public class Article {
	
	
	public int id;
	@FormAnnotation(label="description", name="libelle" )
	public String libelle;
	@FormAnnotation(label="prix de l'article", name="prix" )
	public double prix;
	@FormAnnotation(label="poids de l'article", name="poids" )
	public double poids;
	
	
	public int getId() { return id;	}
	public void setId(int id) { this.id = id; }
	public String getLibelle() { return libelle; }
	public void setLibelle(String libelle) { this.libelle = libelle;}
	public double getPrix() { return prix; }
	public void setPrix(double prix) { this.prix = prix; }
	public double getPoids() { return poids; }
	public void setPoids(double poids) { this.poids = poids; }
	
	public Article() { this (0, "", 0.0, 0.0); }
	public Article(int id, String libelle, double prix, double poids) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
		this.poids = poids;
	}

}
