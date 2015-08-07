package com.loncoto.webapps.FirstJunit.testCase;

//les assertions sont des essais, essais réussi essai echoué etc etc
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.loncoto.webapps.FirstJunit.beans.Message;

public class MessageTest {

	@BeforeClass
	public static void initTest() {
		//init avant de faire les tests
        System.out.println("configuration avant la suite de tests");
	}

	@Before
	public void beforeEachTest() {
		System.out.println("avant chaque test");
	}

	@After
	public void afterEachTest() {
		System.out.println("après chaque test");
	}

	@Test
	public void testTitre() {
        Message m1 = new Message();
        String expected = "bonjour";
        m1.setTitre(expected);
        String result = m1.getTitre();
		assertEquals("titre should be the same", expected, result);
	}

    @Test(expected=Exception.class)
	public void testNull() {
		
        Message m1 = new Message();
        int length = m1.getTitre().length();
    }
    
    
    @Test(expected=Exception.class)
	public void testNullcorps() {
		
        Message m1 = new Message();
        int length = m1.getTitre().length();
    }
    

	@Ignore
	@Test
	public void testEqual() {
        /// test ingnoré temporairement
	}

}
