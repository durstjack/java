package com.loncoto.webapps.exo2JPA.jpa;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.loncoto.webapps.exo2JPA.beans.*;

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
		
		System.out.println("---------------- debut du test 1 -----------------------");
		
		Random rd = new Random();
		//ajout des tags
		for(int i=0; i < 6; i++){
			em.persist(new Tag(0, "Tag n°" + i));
		}
		
		//ajout des posts
		for(int i=0; i < 30; i++){
			Post p = new Post(0, "titre " + i , "blebleble" +i);
			//ajout de tags a chaque post
			for(int j = 1; j <= 4; j++){
				if(rd.nextBoolean()){
					p.getTags().add(em.find(Tag.class, j));
				}
			em.persist(p);
			}
		}
		
		System.out.println("---------------- fin du test 1 -----------------------");	
		
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
		
		System.out.println("---------------- debut du test 2 -----------------------");		
		
//		Scanner input = new Scanner(System.in);
//		System.out.println("identifiant message? ");
//		int id = Integer.parseInt(input.nextLine());
		
		Tag t = new Tag(0, "nouveau tag");
		Post p = new Post(0, "nv titre ", "nouveaucorps");
		p.getTags().add(em.find(Tag.class, 1));
		//p.getTags().add(t); provoque une erreur le tag n'a pas ete sauvegarde en base !!! il faut faire un persist du tag
		//em.persist(t);
		em.persist(p);
		
		
		System.out.println("---------------- fin du test 2 -----------------------");		

		//----------------------------------------------------
		tx.commit();
		em.close();
	}

}
