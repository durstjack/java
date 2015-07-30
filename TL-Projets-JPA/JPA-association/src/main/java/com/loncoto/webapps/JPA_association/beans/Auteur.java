package com.loncoto.webapps.JPA_association.beans;

import javax.persistence.*;
@Entity
public class Auteur {
	
	private int id;
	private String nom;
	private String prenom;
	
	@Id @GeneratedValue
	public int getId() { return id;	}
	public void setId(int id) {	this.id = id; }
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }
	public String getPrenom() {	return prenom; }
	public void setPrenom(String prenom) { 	this.prenom = prenom; }
	
	public Auteur(){this(0,"","");}
	public Auteur(int id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}	
	
}
