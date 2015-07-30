package com.loncoto.webapps.SecondJPA.beans;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="TBLarticle")//
public class Article {
	
	
	private int id;
	private String nom;
	private Double prix;
	private Double poids;
	private Date dateCreation;
	
	@Id @GeneratedValue
	public int getId() { return id; }
	public void setId(int id) {	this.id = id; }
	
	@Column(length=100)
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }
	
	@Temporal(TemporalType.DATE)
	public Date getDateCreation() {	return dateCreation; }
	public void setDateCreation(Date dateCreation) { this.dateCreation = dateCreation; }
	
	@Column(precision=2, scale=2)
	public Double getPrix() { return prix; }
	public void setPrix(Double prix) { this.prix = prix; }
	
	@Column(name="poids_article")
	public Double getPoids() { return poids; }
	public void setPoids(Double poids) { this.poids = poids; }
	
	
	public Article() { this(0, "", 0.0, 0.0, new Date()); }
	
	public Article(int id, String nom, Double prix, Double poids, Date dateCreation) {
		super();
		this.setId(id);
		this.setNom(nom);
		this.setPrix(prix);
		this.setPoids(poids);
		this.setDateCreation(dateCreation);
	}

}
