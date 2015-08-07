package com.loncoto.webapps.MyFirtsUltimate3Tools.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.loncoto.webapps.MyFirtsUltimate3Tools.metier.Message;

public class MessageDAO implements IMessageDAO {

	//dis a spring (transaction manager)
	//d'injecter dans cet attribut l'entity mananger qu on utilisera dans nos fonctions
	@PersistenceContext
	private EntityManager em;	
	public void setEm(EntityManager em) { this.em = em; }

	//le transaction manager va voir cet methode et il va automatiquement effectuer l'AOP
	// catte annotation indique au transaction manager de spring
	//que cette methode aura besoin de l'entity manager et d'une transaction deja ouverte
	//une fois la fonction terminée, le transaction manager commit automatiquement la transaction et ferme l'entitymanager
	
	@Transactional
	public List<Message> findAll() {
		return em.createQuery("from Message",Message.class).getResultList();
	}

	@Transactional
	public Message findByID(int id) {
		return em.find(Message.class, id);
	}

	@Transactional
	public Message save(Message m) {
	
		if(m.getId() >0){
			m = em.merge(m); //renvoie un objet traqué | on passe d'un objet inconnu de l'entity manager à un objet suivi par l'entity manager
		}
		else{
			em.persist(m);//persist est une insertion l'entity manager suit imediatement l objet traqué
		}
		return m;
	}

	@Transactional
	public void delete(int id) {
		Message msg = em.find(Message.class, id);
		if( msg != null ){ em.remove(msg);}
		
	}

}
