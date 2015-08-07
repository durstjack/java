package com.loncoto.webapps.SpringexoIntervention.models;

import java.util.List;

import com.loncoto.webapps.SpringexoIntervention.metier.Intervention;


public interface IInterventionDAO {
	
	public List<Intervention> findAll();
	public Intervention findByID(int id);
	public Intervention save(Intervention i);
	public void delete(int id);

}
