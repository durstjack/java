package com.loncoto.webapps.JPA_association.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Post {
	
	private int id;
	private String titre;
	private String corps;
	
	private Categorie categorie;
	private Auteur auteur;
	
	
	//la cle etrangere est tjrs du coté du many
	
	@Id @GeneratedValue
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getTitre() { return titre; }
	public void setTitre(String titre) { this.titre = titre; }
	public String getCorps() { return corps; }
	public void setCorps(String corps) { this.corps = corps; }
	
	
	@ManyToOne	
	public Categorie getCategorie() { return categorie; }
	public void setCategorie(Categorie categorie) {	this.categorie = categorie; }
	
	@ManyToOne(cascade=CascadeType.REFRESH)
	public Auteur getAuteur() { return auteur; }
	public void setAuteur(Auteur auteur) {	this.auteur = auteur; }
	
	public Post(){this(0, "", "");}
	public Post(int id, String titre, String corps) {
		super();
		this.id = id;
		this.titre = titre;
		this.corps = corps;
	}
	
	
	
	

}
