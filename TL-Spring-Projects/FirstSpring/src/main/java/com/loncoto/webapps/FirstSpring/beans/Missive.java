package com.loncoto.webapps.FirstSpring.beans;

public class Missive {

	private String destinataire;
	private String adresse;
	private Message contenu;
	
	public String getDestinataire() { return destinataire; }
	public void setDestinataire(String destinataire) { this.destinataire = destinataire; }
	public String getAdresse() { return adresse; }
	public void setAdresse(String adresse) { this.adresse = adresse; }
	public Message getContenu() { return contenu; }
	public void setContenu(Message contenu) { this.contenu = contenu; }
	
	@Override
	public String toString() {
		return "Missive [destinataire=" + destinataire + ", adresse=" + adresse	+ ", contenu=" + contenu + "]";
	}
	
	
	public Missive(String destinataire, String adresse) {
		super();
		this.destinataire = destinataire;
		this.adresse = adresse;

	}
	
	
	
	
	
	
}
