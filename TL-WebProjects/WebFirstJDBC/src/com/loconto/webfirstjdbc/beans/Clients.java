package com.loconto.webfirstjdbc.beans;

//classe de l'objet métier Clients, 
//les objets qui seront instanciés représenterons un client

public class Clients {
	private int id;
	private String nom;
	private String email;
	private double solde;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	
	public Clients() { this(0, "","",0.0); }
	
	public Clients(String nom, String email) { this(0, nom , email ,0.0); }
	
	public Clients(String nom, String email, double solde) { this(0, nom , email , solde); }

	public Clients(int id, String nom, String email, double solde) {
		super();
		this.setId(id);		
		this.setNom(nom);
		this.setEmail(email);
		this.setSolde(solde);
	}
	
	
	
	

}
