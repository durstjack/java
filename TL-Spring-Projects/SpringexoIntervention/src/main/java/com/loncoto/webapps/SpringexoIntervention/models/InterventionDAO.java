package com.loncoto.webapps.SpringexoIntervention.models;

import java.util.List;






import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.loncoto.webapps.SpringexoIntervention.metier.Intervention;

public class InterventionDAO implements IInterventionDAO {
	
	//dis a spring (transaction manager)
	//d'injecter dans cet attribut l'entity mananger qu on utilisera dans nos fonctions
	@PersistenceContext
	private EntityManager em;	
	public void setEm(EntityManager em) { this.em = em; }

	@Transactional
	public List<Intervention> findAll() {
		return em.createQuery("from Intervention",Intervention.class).getResultList();
	}

	@Transactional
	public Intervention findByID(int id) {
		return em.find(Intervention.class, id);
	}

	@Transactional
	public Intervention save(Intervention i) {
		if(i.getId() >0){ i = em.merge(i); }
		else{ em.persist(i); }		
		return i;
	}

	@Transactional
	public void delete(int id) {
		Intervention i = em.find(Intervention.class, id);
		if( i != null ){ em.remove(i);}
		
	}

}
