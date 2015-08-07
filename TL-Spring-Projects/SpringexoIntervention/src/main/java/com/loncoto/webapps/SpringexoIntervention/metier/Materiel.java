package com.loncoto.webapps.SpringexoIntervention.metier;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Materiel {
	
	private int id;
	private String noSerie;
	private String nom;
	
	
	private Set<Intervention> interventions;
	@OneToMany(mappedBy="materiel")
	public Set<Intervention> getInterventions() {
		if( interventions == null ){ interventions = new HashSet<Intervention>();  }
		return interventions;
	}
	public void setInterventions(Set<Intervention> interventions) { this.interventions = interventions; }
	
	@Id @GeneratedValue
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getNoSerie() { return noSerie; }
	public void setNoSerie(String noSerie) { this.noSerie = noSerie; }
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }
	
	

}
