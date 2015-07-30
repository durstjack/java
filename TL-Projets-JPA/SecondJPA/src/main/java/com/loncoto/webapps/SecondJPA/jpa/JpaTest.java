package com.loncoto.webapps.SecondJPA.jpa;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.loncoto.webapps.SecondJPA.beans.Article;

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
		
        input.nextLine();
		System.out.println("--------------------------------------");
		test4(emf);
		
        input.nextLine();
		System.out.println("--------------------------------------");
		test5(emf);

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

			
			for(int i =1; i <20; i++){
				em.persist(new Article(0,
										"article_num_" + i, 15.0 + rd.nextDouble() *100,
										0.5 + rd.nextDouble() * 20,
										new Date())); 
				System.out.println("rd vaut => " + rd.nextDouble());
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
		
		//je recupere l'article avec l'id a 4
		Article a1 = em.find(Article.class, 4);
		System.out.println("Article  avec nom => "+ a1.getNom() + " , vaut "+ a1.getPrix() + "€");
		
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
		
		TypedQuery<Article> queryArticles = em.createQuery("from Article", Article.class);
		List<Article> Liste = queryArticles.getResultList();
		for(Article a : Liste){
			System.out.println("Article  avec nom => "+ a.getNom() + " , vaut "+ a.getPrix() + "€");		
		}

		
		//----------------------------------------------------
		tx.commit();
		em.close();
	}
	
	public static void test4(EntityManagerFactory emf)
	{
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		
		TypedQuery<Article> queryArticles = em.createQuery("select art from Article as art where art.prix > :prix_min", Article.class);
		queryArticles.setParameter("prix_min", 50.0);
		List<Article> Liste = queryArticles.getResultList();
		for(Article a : Liste){
			System.out.println("Article  avec nom => "+ a.getNom() + " , vaut "+ a.getPrix() + "€");		
		}

		
		//----------------------------------------------------
		tx.commit();
		em.close();
	}
	
	public static void test5(EntityManagerFactory emf)
	{
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		System.out.println("-------------- test 5 ------------------------");
		
		Query req = em.createQuery("select art.nom, art.prix from Article as art where art.prix > :prix_min");
		req.setParameter("prix_min", 50.0);
		List<Object[]> Liste = req.getResultList();
		for(Object[] ligne : Liste){
			System.out.println("Article  avec nom => "+ ligne[0] + " , vaut "+ ligne[1] + "€");		
		}

		
		//----------------------------------------------------
		tx.commit();
		em.close();
	}
	
	
	
	

}
