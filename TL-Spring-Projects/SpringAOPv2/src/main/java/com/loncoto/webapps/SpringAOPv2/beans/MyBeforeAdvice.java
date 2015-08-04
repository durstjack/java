package com.loncoto.webapps.SpringAOPv2.beans;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class MyBeforeAdvice implements MethodBeforeAdvice {

	@Override
	//o est l'objet sur lequel la méthode est appelé 
	public void before(Method m, Object[] arguments, Object o)	throws Throwable {
		//o est l'objet sur lequel la méthode est appelé 
		
	}

	
	
}
