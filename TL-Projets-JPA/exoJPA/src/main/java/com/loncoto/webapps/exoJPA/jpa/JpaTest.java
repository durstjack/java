package com.loncoto.webapps.exoJPA.jpa;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.loncoto.webapps.exoJPA.beans.*;

public class JpaTest {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testHibernate");
        Scanner input = new Scanner(System.in);

        input.nextLine();
        System.out.println("--------------------------------------");
		test1(emf);

        input.nextLine();
		System.out.println("--------------------------------------");
		test2(emf);

        input.nextLine();
		System.out.println("--------------------------------------");		

	    emf.close();
		System.out.println("done...");
	}


	public static void test1(EntityManagerFactory emf)
	{
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		
			//definition des employés
			em.persist( new Site(0, "clermont ferrand", "2 rue allée alan turing"));
			em.persist( new Site(0, "toulouse", " rue de l aerodrome"));
			em.persist( new Site(0, "lille", "14 rue du lac"));
			em.persist( new Site(0, "paris", "94 grande arche"));
			
			//definition des employes
			em.persist( new Employe(0, "lalandre thierry", "thierry@gmail.com", 3200.0));
			em.persist( new Employe(0, "lalandre marc", "marc@gmail.com", 1200.0));
			em.persist( new Employe(0, "frdalic jose", "jose88@gmail.com", 1600.0));
			em.persist( new Employe(0, "Pelusa marie", "marie@gmail.com", 1580.0));
			em.persist( new Employe(0, "Malvic eric", "eric@gmail.com", 1560.0));
			
			//definition des services
			em.persist(new Service(0, "consulting"));
			em.persist(new Service(0, "MCR"));
			em.persist(new Service(0, "aerospatial"));
			
			//definition d'un service pour chaque employé
			Random rd = new Random();
			//rd.nextInt(5) va tirer entre 0 et 4
			for( int i = 1; i < 6; i++){
				Employe e = em.find(Employe.class, i);
				e.setService(em.find(Service.class, (rd.nextInt(3) + 1) ));
			}

			
			//definition pour chaque service, d'un manager et d'un site
			rd = new Random();
			//rd.nextInt(5) va tirer entre 0 et 4
			for( int i = 1; i < 4; i++){
				Service s = em.find(Service.class, i);
				s.setManager(em.find(Employe.class, (rd.nextInt(5) + 1)));	
				s.setSite(em.find(Site.class, (rd.nextInt(3) + 1)));	
			}
			
			
		//----------------------------------------------------
		tx.commit();
		em.close();
	}


	public static void test2(EntityManagerFactory emf)
	{
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		

		//tt les employes avec les details
		TypedQuery<Employe> query = em.createQuery("select emp from Employe as emp", Employe.class);
		System.out.println("--------------- Liste de tous les employés -------------------");
		List<Employe> resultats = query.getResultList();
		for(Employe e : resultats) {
			System.out.println("id=> "+ e.getId() + ", nom=> " + e.getNom() + ", email=> " + e.getEmail() + ", salaire=> " + e.getSalaire() + "€ , serviceID=> " + e.getService().getId() );
		}
		
		//tt les employes d un service
		query = em.createQuery("select emp from Employe as emp where emp.service.id= :service_id", Employe.class);
		query.setParameter("service_id", 1);
		resultats = query.getResultList();
		System.out.println("--------------- Employé(s) du service avec => id=1  -------------------");
		for(Employe e : resultats) {
			System.out.println("nom de l'employé => " + e.getNom());
		}

		//----------------------------------------------------
		tx.commit();
		em.close();
	}

}
