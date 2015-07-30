package com.loncoto.webapps.JPA_association.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
@Entity
public class Auteur {
	
	private int id;
	private String nom;
	private String prenom;
	
	
	//on met "set" car c'est plus cohérent avec la bdd on a un set de posts, sans ordre on a pas une liste avec un ordre par ex;
	private Set<Post> posts;
	
	@OneToMany(mappedBy="auteur")
	public Set<Post> getPosts() { 
		if(posts == null){ posts = new HashSet<Post>();	}
		return posts;
	}
	public void setPosts(Set<Post> posts) { this.posts = posts;	}
	
	
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
