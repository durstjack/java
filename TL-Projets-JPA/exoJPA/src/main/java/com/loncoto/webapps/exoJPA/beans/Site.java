package com.loncoto.webapps.exoJPA.beans;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
@Entity
public class Site {

	private int id;
	private String nom;
	private String adresse;
	private Set<Service> services;
	
	@OneToMany(mappedBy="site")
	public Set<Service> getServices() { 
		if (services == null){ services = new HashSet<Service>(); }
		return services; 
	}
	public void setServices(Set<Service> services) { this.services = services; }

	
	@Id @GeneratedValue
	public int getId() { return id; }
	public void setId(int id) {	this.id = id; }
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }
	public String getAdresse() { return adresse; }
	public void setAdresse(String adresse) { this.adresse = adresse; }
	
	public Site(){this(0, "", "");}
	public Site(int id, String nom, String adresse) {
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
	}
	
	
	
	
}
