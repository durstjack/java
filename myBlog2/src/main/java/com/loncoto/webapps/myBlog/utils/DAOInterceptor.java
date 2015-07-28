package com.loncoto.webapps.myBlog.utils;

import java.lang.reflect.Method;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class DAOInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		ActionContext actx = arg0.getInvocationContext();
		//je recupere une map contenant tt les attributs du servletcontext
		//c'est a dire, ce qui aura été initialisé par notre dataBaseManager(listener de la webapp)
		Map<String, Object> webAppctx = actx.getApplication();
		//je recupere l'action qui sera appelée au final
		Object action = arg0.getAction();
		
		//REFLEXION
	
		Class cls = action.getClass();
		Method[] methods = cls.getMethods();
		for(Method m : methods){
			if(m.getName().startsWith("set") && m.getName().endsWith("DAO") && m.getParameterCount() == 1){
				//je suis sur une methode qui a nom set*DAO et qui prend un  parametre
				//je recherche le nom du DAO clients articles post etc
				String daoName = m.getName().substring(3,4).toLowerCase() + m.getName().substring(4);
				System.out.println("setter DAO détécté => " + daoName);
				
				//test si on a ca dans la map				
				if(webAppctx.containsKey(daoName)){
					Object dao = webAppctx.get(daoName);
					//verifier le type de l object corresponde avec le setter dans blogAction
					if( dao.getClass().isAssignableFrom(m.getParameterTypes()[0]) ){
						m.invoke(action, dao);// lobjet action va executer la methode Set avec 
					}
				}
				
			}
			
		}
		
		//chainage - passage de témoin au prochain intercepteur
		String result = arg0.invoke();
		return result;
	}

}
