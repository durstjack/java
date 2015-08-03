package com.loncoto.webapps.jpaHeritageTablePerClass.beans;
import javax.persistence.*;
@Entity
//on peut choisir ici la strategie d'heritage
//3 possibilités => SINGLE_TABLE, TABLE_PER_CLASS et JOINED
//ici une table par classe
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Personne {

	private int id;
	private String nom;
	private String prenom;
	
	//on va regler notre table compteur
	//pour permettre l'auto incremente
	//mecanisme puisssant permet d'allouer un bloc de 50 insertions
	@TableGenerator(name="myGenerator",
					table="Table_key",
					pkColumnName="nom_cle",
					valueColumnName="valeur_cle",
					pkColumnValue="cle_personne",
					initialValue=1)	
	
	@Id @GeneratedValue(strategy=GenerationType.TABLE, generator="myGenerator")
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
