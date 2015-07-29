package com.loncoto.webapps.FirstJSF.managedBeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class CompteurBean {
	private int compteur;

	public int getCompteur() { return compteur; }
	public void setCompteur(int compteur) { this.compteur = compteur; }

	public CompteurBean() {
		this.compteur = 0;
	}
	
	public String incremente(){
		compteur++;
		if(compteur > 5){
			return "index2.xhtml";
		}
		else{
			return "index.xhtml";
		}
			
	}
	
}
