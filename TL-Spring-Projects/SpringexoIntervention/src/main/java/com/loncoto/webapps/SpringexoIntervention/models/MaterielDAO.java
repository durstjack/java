package com.loncoto.webapps.SpringexoIntervention.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.loncoto.webapps.SpringexoIntervention.metier.Intervention;
import com.loncoto.webapps.SpringexoIntervention.metier.Materiel;

public class MaterielDAO implements IMaterielDAO{
	
	@PersistenceContext
	private EntityManager em;	
	public void setEm(EntityManager em) { this.em = em; }

	@Transactional
	public List<Materiel> findAll() {
		return em.createQuery("from Materiel",Materiel.class).getResultList();
	}

	@Transactional
	public Materiel findByID(int id) {
		return em.find(Materiel.class, id);
	}

	@Transactional
	public Materiel save(Materiel m) {
		if(m.getId() >0){ m = em.merge(m); }
		else{ em.persist(m); }		
		return m;
	}

	@Transactional
	public void delete(int id) {
		Materiel m  = em.find(Materiel.class, id);
		if( m != null ){ em.remove(m);}	
	}

}
