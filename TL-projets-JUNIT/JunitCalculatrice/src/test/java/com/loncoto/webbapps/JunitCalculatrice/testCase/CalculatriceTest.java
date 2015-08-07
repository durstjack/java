package com.loncoto.webbapps.JunitCalculatrice.testCase;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.loncoto.webbapps.JunitCalculatrice.beans.Calculatrice;

public class CalculatriceTest {
	
	
	@Test
	public void testMultiplication(){
		double expected = 6.0;
		double result = Calculatrice.multiplier(1.0, 2.0, 3.0);
		//ici l'assertion passe si les valeurs sont égales
		//sinon elle échoue et le test avec, le message sera affiché
		assertEquals("multiplier ne renvoie pas le bon resultat", expected, result, 0.001); //0.001 c'est le delta l amplitude
		
	}
	
	
	@Test(expected=ArithmeticException.class)
	public void testDivision(){
		Calculatrice.division(10, 0);
	
	}
	
	//on peut mettre deux asserts dans un test 
	//les deux doivent reussir pour valider le tests
	@Test
	public void testAccumulation(){
		double expected = 2.0;
		double result = Calculatrice.accumuler(1.0, 0.5, 0.5);
		assertEquals(expected, result, 0.5);
		result = Calculatrice.accumuler( -3.0, -1.0, 6);
		assertEquals(expected, result, 0.5);
	}
	

}
