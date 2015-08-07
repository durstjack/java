package com.loncoto.webapps.SpringexoIntervention.metier;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
@Entity
public class Intervenant {
	
	private int id;
	private String nom;
	private String email;
	
	
	private Set<Intervention> interventions;
	@OneToMany(mappedBy="intervenant")
	public Set<Intervention> getInterventions() {
		if( interventions == null ){ interventions = new HashSet<Intervention>();  }
		return interventions;
	}
	public void setInterventions(Set<Intervention> interventions) { this.interventions = interventions; }

	@Id @GeneratedValue
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

}
