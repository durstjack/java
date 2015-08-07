package com.loncoto.webapps.SpringexoIntervention.models;

import java.util.List;

import com.loncoto.webapps.SpringexoIntervention.metier.Intervenant;

public interface IIntervenantDAO {
	
	public List<Intervenant> findAll();
	public Intervenant findByID(int id);
	public Intervenant save(Intervenant i);
	public void delete(int id);

}
