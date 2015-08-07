package com.loncoto.webapps.SpringexoIntervention.metier;

import java.util.Date;

import javax.persistence.*;
@Entity
public class Intervention {
	
	private int id;
	private Date datePlanification;
	private String memo;
	private String statuts;
	
	private Materiel materiel;
	@ManyToOne	
	public Materiel getMateriel() {	return materiel; }
	public void setMateriel(Materiel materiel) { this.materiel = materiel; }
	
	private Intervenant intervenant;
	@ManyToOne
	public Intervenant getIntervenant() { return intervenant; }
	public void setIntervenant(Intervenant intervenant) { this.intervenant = intervenant; }
	
	@Id @GeneratedValue
	public int getId() { return id; }
	public void setId(int id) {	this.id = id; }
	public Date getDatePlanification() { return datePlanification; }
	public void setDatePlanification(Date datePlanification) { this.datePlanification = datePlanification; }
	public String getMemo() { return memo; }
	public void setMemo(String memo) { this.memo = memo; }
	public String getStatuts() { return statuts; }
	public void setStatuts(String statuts) { this.statuts = statuts; }
	

}
