package com.loncoto.webstruts.firstStruts.actions;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	
	
	private static final long serialVersionUID = 1L;

	private String message;
	private String nom;
	private String password;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * actions
	 * 
	 */
	public String index() {
		message = "bonjour depuis index le " + new Date();
		return SUCCESS;
	}
	
	public String tryConnect() {
		if(password.length() < 3){
			message = "Désolé " + nom + " le mot de passe saisi est trop court";			
			return ERROR;
		}
		else{
			message = "bienvenue " + nom + " sur dans votre espace personnel";
			return SUCCESS;
		}
		
	}

	
	

}
