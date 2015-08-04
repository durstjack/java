package com.loncoto.webapps.jpaHeritageExercice.beans;

import java.util.Date;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
@Entity
//classe parente de document & image
@Inheritance(strategy=InheritanceType.JOINED)
public class Content {
	
	private int id;
	private Date dateCreation;
	private Date dateModification; 
	private String nom;
	
	private Set<Tag> tags;
	
	//appelé auto avant une modification
	@PrePersist
	public void createContent(){
		Date d = new Date();
		setDateCreation(d);
		setDateModification(d);
	}
	//appelé auto avant une modification
	@PreUpdate
	public void updateContent(){
		Date d = new Date();
		setDateModification(d);
	}
	

	//est mettre de la relation avec tags	
	@ManyToMany
	public Set<Tag> getTags() {
		if( tags == null ) tags = new HashSet<Tag>();
		return tags;
	}
	public void setTags(Set<Tag> tags) { this.tags = tags; }
	
	
	@Id @GeneratedValue
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	@Temporal(TemporalType.DATE)
	public Date getDateCreation() { return dateCreation; }
	public void setDateCreation(Date dateCreation) { this.dateCreation = dateCreation; }
	
	@Temporal(TemporalType.DATE)
	public Date getDateModification() {	return dateModification; }
	public void setDateModification(Date dateModification) { this.dateModification = dateModification; }
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }

	public Content(){ this(0, null, null, ""); }
	public Content(int id, Date dateCreation, Date dateModification, String nom) {
		super();
		this.id = id;
		this.dateCreation = dateCreation;
		this.dateModification = dateModification;
		this.nom = nom;
	}
	
	
}
