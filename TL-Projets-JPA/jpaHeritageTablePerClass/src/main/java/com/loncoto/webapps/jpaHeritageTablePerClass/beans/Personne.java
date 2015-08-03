package com.loncoto.webapps.jpaHeritageTablePerClass.beans;
import javax.persistence.*;
@Entity
//on peut choisir ici la strategie d'heritage
//3 possibilités => SINGLE_TABLE, TABLE_PER_CLASS et JOINED
//jointures entre  
@Inheritance(strategy=InheritanceType.JOINED)
public class Personne {

	private int id;
	private String nom;
	private String prenom;
	
	@Id @GeneratedValue 
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }
	
	public String getPrenom() { return prenom; }
	public void setPrenom(String prenom) { this.prenom = prenom; }
	
	public Personne(){ this(0, "", ""); }
	public Personne(int id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	
	
	
}
