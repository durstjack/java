package com.loncoto.webapps.exoJPA.beans;
import java.util.Set;

import javax.persistence.*;
@Entity
public class Service {
	
	private int id;
	private String denomination;
	private Set<Employe> employes;
	
	@OneToMany(mappedBy="service")
	public Set<Employe> getEmployes() {	return employes; }
	public void setEmployes(Set<Employe> employes) { this.employes = employes; }
	
	private Employe manager;
	private Site site;
	
	@ManyToOne
	public Employe getManager() { return manager; }
	public void setManager(Employe manager) { this.manager = manager; }

	@ManyToOne
	public Site getSite() {	return site; }
	public void setSite(Site site) { this.site = site; }
	
	
	@Id @GeneratedValue
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getDenomination() { return denomination; }
	public void setDenomination(String denomination) { this.denomination = denomination; }
	
	public Service(){this(0, "");}
	public Service(int id, String denomination) {
		this.id = id;
		this.denomination = denomination;
	}
	
	

}
