package com.loncoto.webapps.jpaHeritageSingleTable.beans;

import java.util.Date;

import javax.persistence.*;
@Entity
public class Employe extends Personne {
	
	private String email;
	private double salaire;
	private Date dateEmbauche;
	
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public double getSalaire() { return salaire; }
	public void setSalaire(double salaire) { this.salaire = salaire; }
	@Temporal(TemporalType.DATE)
	public Date getDateEmbauche() { return dateEmbauche; }
	public void setDateEmbauche(Date dateEmbauche) { this.dateEmbauche = dateEmbauche; }
	
	public Employe(){ this(0, "", "", "", 0.0, null); }
	public Employe(int id, String nom, String prenom, String email,	double salaire, Date dateEmbauche) {
		super(id, nom, prenom);
		this.email = email;
		this.salaire = salaire;
		this.dateEmbauche = dateEmbauche;
	}
	
	
	
	

}
