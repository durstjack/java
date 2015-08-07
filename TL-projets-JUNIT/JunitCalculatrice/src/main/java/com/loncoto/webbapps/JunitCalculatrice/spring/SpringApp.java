package com.loncoto.webbapps.JunitCalculatrice.spring;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.loncoto.webbapps.JunitCalculatrice.beans.Calculatrice;
import com.loncoto.webbapps.JunitCalculatrice.beans.Message;

public class SpringApp {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
        Scanner input = new Scanner(System.in);
        

        input.nextLine();
        System.out.println("--------------------------------------");
        

        System.out.println(Calculatrice.division(5, 2));
        System.out.println(Calculatrice.accumuler(1,2,3));
        System.out.println(Calculatrice.multiplier(1,2,3));
        
        
        input.nextLine();
		System.out.println("--------------------------------------");

		System.out.println("done...");
	}





}
