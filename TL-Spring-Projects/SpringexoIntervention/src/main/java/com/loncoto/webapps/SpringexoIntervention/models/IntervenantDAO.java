package com.loncoto.webapps.SpringexoIntervention.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.loncoto.webapps.SpringexoIntervention.metier.*;

public class IntervenantDAO implements IIntervenantDAO {

	@PersistenceContext
	private EntityManager em;	
	public void setEm(EntityManager em) { this.em = em; }

	@Transactional
	public List<Intervenant> findAll() {
		return em.createQuery("from Intervenant",Intervenant.class).getResultList();
	}

	@Transactional
	public Intervenant findByID(int id) {
		return em.find(Intervenant.class, id);
	}
	
	@Transactional
	public Intervenant save(Intervenant i) {
		if(i.getId() >0){ i = em.merge(i); }
		else{ em.persist(i); }		
		return i;
	}

	@Transactional
	public void delete(int id) {
		Intervenant i = em.find(Intervenant.class, id);
		if( i != null ){ em.remove(i);}
	}

}
