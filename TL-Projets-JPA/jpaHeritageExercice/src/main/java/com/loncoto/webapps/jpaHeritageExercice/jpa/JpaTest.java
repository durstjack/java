package com.loncoto.webapps.jpaHeritageExercice.jpa;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.loncoto.webapps.jpaHeritageExercice.beans.*;

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
		//test2(emf);

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
		
		em.persist(new Tag(0, "mathematiques"));
		em.persist(new Tag(0, "francais"));
		em.persist(new Tag(0, "anglais"));
		em.persist(new Tag(0, "allemand"));
		em.persist(new Tag(0, "sports"));
		em.persist(new Tag(0, "physique"));
		
		
		HashMap<String, String> imagesTypes = new HashMap<String, String>();
		imagesTypes.put(".jpg", "images/jpg");
		imagesTypes.put(".png", "images/png");
		imagesTypes.put(".gif", "images/gif");
		
		String[] imagesKey = {".jpg",".png",".gif"};
		
		
		Random rd = new Random();
		String k;
		for(int i =1; i <=15 ; i++){
			em.persist(new Content(0, new Date(),  new Date(), "content-n°-"+i));
			em.persist(new Document(0, new Date(), new Date(), "document-n°-"+i, "titre n° "+i, "blablabla-"+i));
			k = imagesKey[rd.nextInt(3)];
			em.persist(new Image(0, new Date(), new Date(), "image-n°-"+i, "DSC" + rd.nextInt(50) + k , imagesTypes.get(k)));
		}

		
		System.out.println("----------------- fin du test1 -----------------------");
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
		

		
		//----------------------------------------------------
		tx.commit();
		em.close();
	}

}
