package com.loncoto.webapps.SpringAOPexo.spring;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.loncoto.webapps.SpringAOPexo.beans.*;

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
        System.out.println(itu.inverse("test d'inversion"));
        System.out.println(itu.inverse("encore une inversion"));
        System.out.println(itu.inverse("test d'inversion"));

        ITextSaluer its = ctx.getBean("ts", ITextSaluer.class);
        System.out.println(its.saluer("thierry"));
        System.out.println(its.saluer("marc"));
        System.out.println(its.saluer("cyril"));
        System.out.println(its.saluer("antoine"));
        System.out.println(its.saluer("marc"));
        
        
        
        input.nextLine();
		System.out.println("--------------------------------------");

		System.out.println("done...");
	}





}
