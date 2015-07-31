package com.loncoto.webapps.exo2JPA.beans;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Tag {
	
	public int id;
	public String libelle;
	
	private Set<Post> posts;
	
	@ManyToMany
	public Set<Post> getPosts() {
		if( posts == null  ) posts = new HashSet<Post>();
		return posts;
	}
	public void setPosts(Set<Post> posts) {	this.posts = posts;	}
	
	@Id @GeneratedValue
	public int getId() { return id;	}
	public void setId(int id) {	this.id = id; }
	public String getLibelle() { return libelle; }
	public void setLibelle(String libelle) { this.libelle = libelle; }
	
	public Tag(){this(0, "");}
	public Tag(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	
	

}
