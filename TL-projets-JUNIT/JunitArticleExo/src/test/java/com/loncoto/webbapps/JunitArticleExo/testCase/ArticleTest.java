package com.loncoto.webbapps.JunitArticleExo.testCase;

//les assertions sont des essais, essais réussi essai echoué etc etc
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;




import com.loncoto.webbapps.JunitArticleExo.beans.*;

public class ArticleTest {
	
	/*	
	liste des test
	- qu'un prix ne peut être négatif (0.0 minimum)
	- qu'un poids ne peut etre négatif (0.0) ou supérieur à 20.0
	- qu'un nom doit faire entre 2 et 50 caracteres
	*/
	
	@Test
	public void testPrixNegatif() {
		Article a = new Article(0, "chaise", 63.0, 23.0);
		a.setPrix(-30.0);
		double prix = a.getPrix();
		assertEquals("on a reussi a prix negatif, echec !", 0.0, prix, 0.0001);
		
	}

	
	@Test(expected=RuntimeException.class)
	public void testPoids() {
		Article a = new Article(0, "table basse", 29.0, 10.0);
		double expected = 15.0;
		a.setPoids(expected);
		double result = a.getPoids();
		//on met le poids a 15 : doit etre ok
		assertEquals(expected, result, 0.00001);
		
		//on met le poids a 30 doit faire un fail 
		expected = 30.0;
		a.setPoids(expected);
		
		fail("aurait du déclencher une exception pour le poids trop important");		
	}	
	
	@Test(expected=RuntimeException.class)
	public void testPoids2() {
		Article a = new Article(0, "table basse", 29.0, 10.0);
		double expected = -15.0;
		
		//on met le poids a -15 doit faire un fail 
		a.setPoids(expected);
		
		fail("aurait du déclencher une exception pour le poids inférieur à 0 !!");		
	}	
	
	
	@Test(expected=RuntimeException.class)
	public void testNom() {
		Article a = new Article(0, "table basse", 29.0, 10.0);
		String expected = "a";
		a.setNom(expected);
	
		fail("aurait du déclencher une exception nom trop court");		
	}	
	
	
	@Test(expected=RuntimeException.class)
	public void testNom2() {
		Article a = new Article(0, "table basse", 29.0, 10.0);
		String expected = "jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjja";
		a.setNom(expected);
	
		fail("aurait du déclencher une exception nom trop long");		
	}	

}
