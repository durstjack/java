package com.loncoto.webapps.FirstJPA.beans;

import javax.persistence.Entity;

//annotations qui viennent de javax persistence
//@Entity nous definit que c'est un EJB3 qui dit que cette classe doit etre mappé dans une table
//on ait obligé de définir la clé primaire @ID
//@GeneratedValue précide que c'est geré par MySQL
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Message {
	private int id;
	private String titre;
	private String corps;

	@Id
	@GeneratedValue	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getTitre() {return titre;}
	public void setTitre(String titre) {this.titre = titre;}
	public String getCorps() {return corps;}
	public void setCorps(String corps) {this.corps = corps;}


	//§§OBLIGATOIRE Constructeur sans argument
	public Message() {this(0,"","");}

	public Message(int id, String titre, String corps) {
		this.id = id;
		this.titre = titre;
		this.corps = corps;
	}
	

}
