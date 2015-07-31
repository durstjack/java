package com.loncoto.webapps.exo3JPA.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
@Entity
public class Etudiant {
	
	
	private int id;
	private String nom;
	private String email;
	
	private Set<Cours> cours;
	@ManyToMany(mappedBy="etudiants")
	public Set<Cours> getCours() {
		if( cours == null ) cours = new HashSet<Cours>();
		return cours;
	}
	public void setCours(Set<Cours> cours) { this.cours = cours; }
	
	
	@Id @GeneratedValue
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	public Etudiant(){ this(0, "", "");}
	public Etudiant(int id, String nom, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
	}

	
	
	
}
