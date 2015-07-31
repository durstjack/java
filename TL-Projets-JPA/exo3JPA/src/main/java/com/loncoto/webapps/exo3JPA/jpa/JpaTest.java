package com.loncoto.webapps.exo3JPA.jpa;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.loncoto.webapps.exo3JPA.beans.*;

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
		
		System.out.println("---------------------- debut test 1 -----------------------");
		
		//construction et insertion de 8 matiere
		em.persist(new Matiere(0, "mathematiques"));
		em.persist(new Matiere(0, "francais"));
		em.persist(new Matiere(0, "anglais"));
		em.persist(new Matiere(0, "allemand"));
		em.persist(new Matiere(0, "sports"));
		em.persist(new Matiere(0, "physique"));
		
		//construction de cours
		Date aujourdhui = new Date();
		Date[] datesPost = { aujourdhui,
				new Date(aujourdhui.getYear(), aujourdhui.getMonth(), aujourdhui.getDate() - 2),
				new Date(aujourdhui.getTime()+ 4),
				new Date(aujourdhui.getTime()+ 6),
				new Date(aujourdhui.getTime()+ 8),
				new Date(aujourdhui.getTime()+ 10),
				new Date(aujourdhui.getTime()+ 12),
				
		};

		Date[] datesPre = { aujourdhui,
				new Date(aujourdhui.getTime()- 2),
				new Date(aujourdhui.getTime()- 4),
				new Date(aujourdhui.getTime()- 6),
				new Date(aujourdhui.getTime()- 8),
				new Date(aujourdhui.getTime()- 10),
				new Date(aujourdhui.getTime()- 12),
				
		};
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy");

		//System.out.println("la date d'aujourd'hui vaut " + formater.format(aujourdhui));
		//em.persist(new Cours(0, , dateFin, libelle));
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
			Cours c = new Cours(0, datesPre[random.nextInt(6)], datesPost[random.nextInt(6)], "cours n°" + random.nextInt(10));
			em.persist(c);
		}		
		
		
		
		
		
		
		//construction et insertion de 30 etudiants
		ArrayList<String> tabPrenoms = new ArrayList<String>();
		tabPrenoms.add("Thierry");
		tabPrenoms.add("Marc");
		tabPrenoms.add("Eric");
		tabPrenoms.add("Gaelle");
		tabPrenoms.add("Sophie");
		tabPrenoms.add("Eva");
		ArrayList<String> tabNoms = new ArrayList<String>();
		tabNoms.add("Dupond");
		tabNoms.add("Ayrault");
		tabNoms.add("Calestroupat");
		tabNoms.add("Courtalon");
		tabNoms.add("Altmann");
		tabNoms.add("Fadala");
		String[] domaines = {"@sfr.fr", "@gmail.com", "@yahoo.fr", "@orange.fr"}; 		
		Random rd = new Random();
		String nomTemp;
		//rd.nextInt(5) va tirer entre 0 et 4
		for (int i = 0; i < 30; i++) {
			nomTemp = tabPrenoms.get(rd.nextInt(6)) + " " + tabNoms.get(rd.nextInt(6));
			em.persist(new Etudiant(0, nomTemp , nomTemp + "-" + i + domaines[rd.nextInt(4)] ));
		}
		
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("voulez vous quitter le test 1 ?");
		String saisie = input.nextLine();
		System.out.println("---------------------- fin du test 1 -----------------------");
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
