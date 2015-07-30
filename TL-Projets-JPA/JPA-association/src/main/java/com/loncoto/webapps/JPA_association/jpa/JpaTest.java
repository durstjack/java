package com.loncoto.webapps.JPA_association.jpa;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.loncoto.webapps.JPA_association.beans.*;
 
import com.sun.org.apache.bcel.internal.generic.NEW;

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
		
        input.nextLine();
		System.out.println("--------------------------------------");
		test3(emf);


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
		for( int i = 0; i < 4; i++){
			em.persist(new Auteur(0, "Corwin", "Bryan" ));
			em.persist(new Auteur(0, "Corwin", "Lisa" ));
			em.persist(new Auteur(0, "Corwin", "Mickael" ));
		}
		
		em.persist( new Categorie(0, "policier"));
		em.persist( new Categorie(0, "roman"));
		em.persist( new Categorie(0, "bibliographie"));
		
		
		Random rd = new Random();
		for (int i =0; i < 40; i++) {
			Post p = new Post(0, "post" + i, "blahblahabmala" + i);
			// je tire au hasard un auteur d'id entre 1 et 3
			p.setAuteur(em.find(Auteur.class, rd.nextInt(3) + 1));
			// je tire au hasard une categorie d'id entre 1 et 3
			p.setCategorie(em.find(Categorie.class, rd.nextInt(3) + 1));
			em.persist(p);
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
		System.out.println("avant find -------------------------");
		Post p = em.find(Post.class, 1);
		System.out.println("apres find -------------------------");		
		
		System.out.println(p.getTitre() + " => " + p.getAuteur().getNom() + " : " + p.getCategorie().getLibelle());
		System.out.println("------------------ fin de l afichage -----");			
		

		//----------------------------------------------------
		tx.commit();
		em.close();
	}
	
	public static void test3(EntityManagerFactory emf)
	{
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		

		
		//----------------------------------------------------
		tx.commit();
		em.close();
	}

	
	
	
	

}
