package com.loncoto.webapps.FirstJSF.managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
//indique a JSF2 qu'il doit instancier et gerer ces objets dans le s pages xhtml
//on peut nommer nos bean => @ManagedBean(name="beanA")
@ManagedBean
//environnement  request-session-webapp/
@RequestScoped
public class IndexBean 
{
	private String message;

	public IndexBean() {
		message = "bonjour monde!";
	}
	
	public String getMessage() { return message; }
	public void setMessage(String message) { this.message = message; }
	
	public String hello() {
		message="pleased to meet you!";
		return "index.xhtml";
	}
	
}
