package com.loncoto.webapps.SpringexoIntervention.models;

import java.util.List;

import com.loncoto.webapps.SpringexoIntervention.metier.Materiel;

public interface IMaterielDAO {
	
	public List<Materiel> findAll();
	public Materiel findByID(int id);
	public Materiel save(Materiel m);
	public void delete(int id);

}
