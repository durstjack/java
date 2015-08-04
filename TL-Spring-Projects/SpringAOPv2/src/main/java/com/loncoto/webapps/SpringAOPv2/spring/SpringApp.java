package com.loncoto.webapps.SpringAOPv2.spring;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.loncoto.webapps.SpringAOPv2.beans.*;

public class SpringApp {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
        Scanner input = new Scanner(System.in);
        

        input.nextLine();
        System.out.println("--------------------------------------");

        ItextUtils itu = ctx.getBean("tu",  ItextUtils.class);
        System.out.println(itu.inverse(" bonjour toi        "));

        ItextUtils itu2 = ctx.getBean("tu",  ItextUtils.class);
        System.out.println(itu2.inverse("bonjour toi comment ça va"));
        
        
        
        input.nextLine();
		System.out.println("--------------------------------------");

		System.out.println("done...");
	}





}
