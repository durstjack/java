package com.loncoto.webapps.SpringexoIntervention.actions;

import java.util.Date;
import java.util.List;


import com.loncoto.webapps.SpringexoIntervention.metier.*;
import com.loncoto.webapps.SpringexoIntervention.models.IIntervenantDAO;
import com.loncoto.webapps.SpringexoIntervention.models.IInterventionDAO;
import com.loncoto.webapps.SpringexoIntervention.models.IMaterielDAO;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	
	
	private static final long serialVersionUID = 1L;
	
	private IIntervenantDAO intervenantDAO;
	private IInterventionDAO interventionDAO;
	private IMaterielDAO materielDAO;
	
	
	

	public IIntervenantDAO getIntervenantDAO() {
		return intervenantDAO;
	}
	public void setIntervenantDAO(IIntervenantDAO intervenantDAO) {
		this.intervenantDAO = intervenantDAO;
	}
	public IInterventionDAO getInterventionDAO() {
		return interventionDAO;
	}
	public void setInterventionDAO(IInterventionDAO interventionDAO) {
		this.interventionDAO = interventionDAO;
	}
	public IMaterielDAO getMaterielDAO() {
		return materielDAO;
	}
	public void setMaterielDAO(IMaterielDAO materielDAO) {
		this.materielDAO = materielDAO;
	}


	private String message;		

	private int idIntervention;
	private Date datePlanificationIntervention;
	private String memoIntervention;
	private String	statutsIntervention;
	
	private int	idIntervenant;
	private String	nomIntervenant;
	private String	emailIntervenant;

	private int	idMateriel;
	private String	noSerieMateriel;
	private String	nomMateriel;
	
	public String getMessage() { return message; }
	public void setMessage(String message) { this.message = message; }
	
	public int getIdIntervention() { return idIntervention; }
	public void setIdIntervention(int idIntervention) { this.idIntervention = idIntervention; }
	public Date getDatePlanificationIntervention() { return datePlanificationIntervention; }
	public void setDatePlanificationIntervention(Date datePlanificationIntervention) { this.datePlanificationIntervention = datePlanificationIntervention; }
	public String getMemoIntervention() { return memoIntervention; }
	public void setMemoIntervention(String memoIntervention) { this.memoIntervention = memoIntervention; }
	public String getStatutsIntervention() { return statutsIntervention; }
	public void setStatutsIntervention(String statutsIntervention) { this.statutsIntervention = statutsIntervention; }

	public int getIdIntervenant() { return idIntervenant; }
	public void setIdIntervenant(int idIntervenant) { this.idIntervenant = idIntervenant; }
	public String getNomIntervenant() {	return nomIntervenant; }
	public void setNomIntervenant(String nomIntervenant) { 	this.nomIntervenant = nomIntervenant; }
	public String getEmailIntervenant() { return emailIntervenant; }
	public void setEmailIntervenant(String emailIntervenant) { this.emailIntervenant = emailIntervenant; }
	
	public int getIdMateriel() { return idMateriel; }
	public void setIdMateriel(int idMateriel) {	this.idMateriel = idMateriel; }
	public String getNoSerieMateriel() { return noSerieMateriel; }
	public void setNoSerieMateriel(String noSerieMateriel) { this.noSerieMateriel = noSerieMateriel; }
	public String getNomMateriel() { return nomMateriel; }
	public void setNomMateriel(String nomMateriel) { this.nomMateriel = nomMateriel; }
	
	public String index() {
		message = "bonjour sur le site de loncoto";
		return SUCCESS;
	}

	
	//todo	
	//pour que la page jsp puisse recuperer les interventions
	private List<Intervention> interventions;

	public List<Intervention> getInterventions() { return interventions; }
	public void setInterventions(List<Intervention> interventions) { this.interventions = interventions; }
	
	public String listerInterventions(){
		interventions = interventionDAO.findAll();
		return SUCCESS;
	}
	
	private List<Intervenant> intervenants;
	
	public List<Intervenant> getIntervenants() { return intervenants; }
	public String listerIntervenants(){
		intervenants = intervenantDAO.findAll();
		return SUCCESS;
	}
	
	
	
	public String editerIntervention() {
		Intervention i = interventionDAO.findByID(getIdIntervention());
		if( i == null ) return "notfound";
		setIdIntervention(i.getId());		
		setDatePlanificationIntervention(i.getDatePlanification());
		setMemoIntervention(i.getMemo());
		setStatutsIntervention(i.getStatuts());
		return SUCCESS;
	}
	
	
	
	
	

	
	
}
