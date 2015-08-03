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
        c1.partirEnQuete();
        
        IChevalier c2 = ctx.getBean("charlot",IChevalier.class);
        c2.partirEnQuete();
        
        
        input.nextLine();
		System.out.println("--------------------------------------");

		System.out.println("done...");
	}





}
