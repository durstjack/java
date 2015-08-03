package com.loncoto.webapps.FirstSpring.spring;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.loncoto.webapps.FirstSpring.beans.Message;
import com.loncoto.webapps.FirstSpring.beans.Missive;

public class SpringApp {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//un peu comme l entity manager de JPA
		//charge le fichier de configuration
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
        Scanner input = new Scanner(System.in);
        

        input.nextLine();
        System.out.println("--------------------------------------");
        
        //Message msg = (Message)ctx.getBean("msg1");
        Missive mv1 = (Missive)ctx.getBean("lettre1");
        
        
        System.out.println(mv1);
        
        
        
        input.nextLine();
		System.out.println("--------------------------------------");

		System.out.println("done...");
	}





}
