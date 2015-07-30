package com.loncoto.webapps.JPA_association.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Categorie {
	
	private int id;
	private String libelle;
	
	private Set<Post> posts;
	
	@OneToMany(mappedBy="categorie")	
	public Set<Post> getPosts() {
		if(posts == null){ posts = new HashSet<Post>();	}
		return posts;
	}
	public void setPosts(Set<Post> posts) { this.posts = posts;	}
	
	@Id @GeneratedValue
	public int getId() { return id; }
	public void setId(int id) {	this.id = id; }
	public String getLibelle() { return libelle; }
	public void setLibelle(String libelle) { this.libelle = libelle; }
	
	public Categorie() { this(0,""); }
	public Categorie(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	

}
