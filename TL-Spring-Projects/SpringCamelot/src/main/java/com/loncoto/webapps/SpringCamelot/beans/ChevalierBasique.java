package com.loncoto.webapps.SpringCamelot.beans;

public class ChevalierBasique implements IChevalier {
	
	private String nom;
	private IQuete quete;

	@Override
	public String getNom() { return nom; }

	@Override
	public void setNom(String nom) { this.nom = nom;}

	@Override
	public void setQuete(IQuete quete) { this.quete = quete;	}

	@Override
	public void partirEnQuete() { 
		System.out.println("je pars en quete :" + getNom() + " => " + quete.getDescription());
	
		if(quete.realiserQuete()){
			System.out.println("j'ai reussi ma quete");
		}
		else{
			System.out.println("ce sera pour une autre fois");
		}
	}

}
