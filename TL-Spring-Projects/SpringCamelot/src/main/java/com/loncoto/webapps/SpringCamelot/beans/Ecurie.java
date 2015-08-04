package com.loncoto.webapps.SpringCamelot.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ecurie {

	private List<Cheval> chevaux;
	
	public Cheval fournirCheval(){
		System.out.println("appel de forunir cheval dans l'ecurie");
		Random rd = new Random();
		return chevaux.get(rd.nextInt(chevaux.size()));
	}

	public Ecurie() {
		chevaux = new ArrayList<Cheval>();
		Cheval c = new Cheval();
		c.setNom("tonnerre");
		chevaux.add(c);
		/*-------------------*/
		c = new Cheval();
		c.setNom("tonnerre");
		chevaux.add(c);
		/*-------------------*/
		c = new Cheval();
		c.setNom("fanfan du moulin");
		chevaux.add(c);
		/*-------------------*/
		c = new Cheval();
		c.setNom("RPZ17");
		chevaux.add(c);
		/*-------------------*/
		c = new Cheval();
		c.setNom("UlysseC14");
		chevaux.add(c);
		/*-------------------*/
		
	}
	
	//2eme constructeur avec en argument une liste de nom de chevaux
	public Ecurie(List<String> nomChevaux) {
		chevaux = new ArrayList<Cheval>();
		for(String nom : nomChevaux){
			Cheval c = new Cheval();
			c.setNom(nom);
			chevaux.add(c);
		}
		
	}
	
	
	
	
}
