package com.loncoto.webapps.SpringCamelot.beans;

public class ChevalierTableRonde implements IChevalier {
	
	private String nom;
	private IQuete quete;
	private Cheval monture;

	public void setMonture(Cheval monture) { this.monture = monture; }

	@Override
	public String getNom() { return nom; }

	@Override
	public void setNom(String nom) { this.nom = nom;}

	@Override
	public void setQuete(IQuete quete) { this.quete = quete;}

	@Override
	public void partirEnQuete() {
		System.out.println("sir " + getNom() + " part en quete " + this.quete.getDescription() + " sur son fidele destrier " + this.monture.getNom());
		
		if(this.quete.realiserQuete()){
			System.out.println("sir " + getNom() + ", chevalier de type: " + ChevalierTableRonde.class.getName() + " est encore victorieux");
		}
		else{
			System.out.println("sir " + getNom() + ", chevalier de type: " + ChevalierTableRonde.class.getName() + " a eu un contre temps");			
		}
	}

}
