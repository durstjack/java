package com.loncoto.webapps.SpringAOPv2.beans;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


//AOP en around 
public class MyAroundAdvice implements MethodInterceptor {

	@Override
	//mi contiendra ttes les infos sur l'appel de la methode intercepté
	//c'est aussi par lui que l'on pourra rappeler la méthode originale
	public Object invoke(MethodInvocation mi) throws Throwable {
		System.out.println("----------------- debut interception --------------");
		System.out.println("interception de l'appel");
		System.out.println("method = " + mi.getMethod().getName() );
		System.out.println("arguments = " + Arrays.toString(mi.getArguments()));
		System.out.println("type de retour = " + mi.getMethod().getReturnType().getName());
		
		//ici on va recuperer l argument et le modifier avant de le passer 
		Object[] args = mi.getArguments();
		if( args.length == 1 && args[0].getClass() == String.class){
			args[0] =((String) args[0]).trim();
		}
		
		
		//appel la methode interceptée
		//puis stockage du retour de la methode originale		
		Object returnvalue = mi.proceed();
		System.out.println("valeur renvoyée = " + returnvalue);
		
		System.out.println("----------------- fin interception --------------");
		System.out.println("----------------- on revoit le retour générée par la method originale --------------");		
		return returnvalue;
	}
	
	

}
