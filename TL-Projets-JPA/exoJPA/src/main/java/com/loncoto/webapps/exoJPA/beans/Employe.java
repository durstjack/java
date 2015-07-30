package com.loncoto.webapps.exoJPA.beans;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.loncoto.webapps.exoJPA.beans.*;
@Entity
public class Employe {

	private int id;
	private String nom;
	private String email;
	private Double salaire;
	
	private Service service;	
	
	@ManyToOne
	public Service getService() {	return service;	}
	public void setService(Service service) { this.service = service; }	
	
	
	private Set<Service> servicesManageds;
	
	@OneToMany(mappedBy="manager")
	public Set<Service> getServicesManageds() {
	
		if( servicesManageds == null){ servicesManageds = new HashSet<Service>();	}
		return servicesManageds;
	}
	public void setServicesManageds(Set<Service> servicesManageds) { this.servicesManageds = servicesManageds; }
	
	
	
	@Id @GeneratedValue
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public Double getSalaire() { return salaire; }
	public void setSalaire(Double salaire) { this.salaire = salaire; }
	
	public Employe(){this(0, "", "", 0.0);}
	public Employe(int id, String nom, String email, Double salaire) {
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.salaire = salaire;
	}
	
	
	
}
