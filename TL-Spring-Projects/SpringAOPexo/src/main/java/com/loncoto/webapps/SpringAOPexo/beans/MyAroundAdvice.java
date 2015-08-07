package com.loncoto.webapps.SpringAOPexo.beans;

import java.util.Arrays;
import java.util.HashMap;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


//AOP en around 
public class MyAroundAdvice implements MethodInterceptor {
	
	private HashMap cache;
	private String identifiant;

	
	//memento
	//on garde en cache les resultats sur des appels de methode deterministes et repetitives
	//on a besoin de tester la class et la methode appelé (contatenation) et l'argument

	@Override
	//mi contiendra ttes les infos sur l'appel de la methode intercepté
	//c'est aussi par lui que l'on pourra rappeler la méthode originale
	public Object invoke(MethodInvocation mi) throws Throwable {
		
		System.out.println("----------------- debut interception --------------");
		System.out.println("interception de l'appel");
		System.out.println("class = " + mi.getThis().getClass().getName());
		System.out.println("method = " + mi.getMethod().getName() );
		System.out.println("arguments = " + Arrays.toString(mi.getArguments()));
		System.out.println("type de retour = " + mi.getMethod().getReturnType().getName());
		
		//ici on va recuperer l argument et le modifier avant de le passer 
		
		
		Object[] args = mi.getArguments();
		//si on a un argument et qu'il est de type string
		if( args.length == 1 && args[0].getClass() == String.class){
			
			identifiant = mi.getThis().getClass().getName() + mi.getMethod().getName() + (String) args[0];
			
			
			if(!cache.containsKey(identifiant)){
				//on a jamais fait cette appel
				Object returnvalue = mi.proceed();
				cache.put(identifiant, returnvalue);
				System.out.println("On avait jamais fait cette requete, resultat hors du cache");
				return returnvalue;
				
			}
			else{
				//on a déjà fait cette appel
				Object returnFromCache = cache.get(identifiant);
				System.out.println("On avait déja fait cette requete, retour grace au cache");
				return returnFromCache;
			}
			
		}
		
		
		
		
		
		else{
			return mi.proceed();
		}
		

	}

	public MyAroundAdvice(){ this( new HashMap<String, Object>()); }
	public MyAroundAdvice(HashMap cache) {
		super();
		this.cache = cache;
	}
	
	

}
