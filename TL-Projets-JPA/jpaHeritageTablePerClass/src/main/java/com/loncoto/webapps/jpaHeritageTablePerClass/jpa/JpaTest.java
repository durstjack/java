package com.loncoto.webapps.jpaHeritageTablePerClass.jpa;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.loncoto.webapps.jpaHeritageTablePerClass.beans.*;

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
		
		
		Random rd = new Random();
		
		String matricule = "GDRET";
		//pas de autoinc dans table per class
		//donc ajout de j pour generer le id 
		//int j = 1;
		for( int i = 1; i <= 10; i++){
			
			
			em.persist(new Personne(0 /*j++*/, "doe-"+i, "john"+i));
			em.persist(new Employe(0 /*j++*/, "eponge"+i, "bob"+i, "bob"+i+"@gmail.com", rd.nextDouble()*1000 + 1500.0, new Date()));
			em.persist(new Client(0 /*j++*/, "star"+i, "patrick"+i, matricule+i, new Date(), rd.nextDouble()*500 + 50.0));
		}
		

		System.out.println(" --------------------  fin du test 1 -------------------- ");
		
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

		System.out.println(" --------------------  liste des clients -------------------- ");
		List<Client> clients = em.createQuery("from Client", Client.class).getResultList();
		
		for(Client client : clients){
			System.out.println("client : " + client.getNom() + ", solde de : " + client.getSolde());
		}
		System.out.println(" ----------------------------------------- -------------------- ");
		System.out.println(" --------------------  liste des personnes -------------------- ");
		List<Personne> personnes = em.createQuery("from Personne", Personne.class).getResultList();
		
		for(Personne personne : personnes){
			System.out.println("personne : " + personne.getNom() + " " + personne.getPrenom());
		}
		
		
		//----------------------------------------------------
		tx.commit();
		em.close();
	}

}
