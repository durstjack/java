package com.loncoto.webapps.SpringCamelot.spring;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.loncoto.webapps.SpringCamelot.beans.*;

public class SpringApp {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
        Scanner input = new Scanner(System.in);
        

        input.nextLine();
        System.out.println("--------------------------------------");
        
        IChevalier c1 = ctx.getBean("jacquot",IChevalier.class);
        System.out.println("--------------------------------------");
        c1.partirEnQuete();
        System.out.println("--------------------------------------");
        
        IChevalier c2 = ctx.getBean("charlot",IChevalier.class);
        System.out.println("--------------------------------------");
        c2.partirEnQuete();
        System.out.println("--------------------------------------");
        
        IChevalier c3 = ctx.getBean("bernardot",IChevalier.class);
        System.out.println("--------------------------------------");
        c3.partirEnQuete();
        System.out.println("--------------------------------------");
        
        
        IChevalier c4 = ctx.getBean("caradoc",IChevalier.class);
        System.out.println("--------------------------------------");
        c4.partirEnQuete();
        System.out.println("--------------------------------------");
       
        
        
        input.nextLine();
		System.out.println("--------------------------------------");

		System.out.println("done...");
	}





}
