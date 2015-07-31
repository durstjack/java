package com.loncoto.webapps.exo3JPA.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
@Entity
public class Matiere {
	
	private int id;
	private String denomination;
	
	private Set<Cours> cours;
	
	@OneToMany(mappedBy="matiere")
	public Set<Cours> getCours() {
		if( cours == null ) cours = new HashSet<Cours>();
		return cours;
	}
	public void setCours(Set<Cours> cours) { this.cours = cours; }
	@Id @GeneratedValue
	public int getId() { return id; }
	public void setId(int id) {	this.id = id; }
	public String getDenomination() { return denomination; }
	public void setDenomination(String denomination) { this.denomination = denomination; }
	
	public Matiere(){ this(0, "");}
	public Matiere(int id, String denomination) {
		super();
		this.id = id;
		this.denomination = denomination;
	}
	
	
	

}
