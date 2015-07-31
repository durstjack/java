package com.loncoto.webapps.exo3JPA.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
@Entity
public class Formateur {
	
	private int id;
	private String nom;
	private String prenom;
	
	private Set<Cours> cours;
	
	@OneToMany(mappedBy="formateur")
	public Set<Cours> getCours() {
		if( cours == null ) cours = new HashSet<Cours>();
		return cours;
	}
	public void setCours(Set<Cours> cours) { this.cours = cours; }
	
	@Id @GeneratedValue
	public int getId() { return id; }
	public void setId(int id) {	this.id = id; }
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }
	public String getPrenom() {	return prenom; }
	public void setPrenom(String prenom) { this.prenom = prenom; }
	
	public Formateur(){ this(0, "", "");}
	public Formateur(int id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	
}
