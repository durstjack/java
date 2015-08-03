package com.loncoto.webapps.jpaHeritageSingleTableDisc.beans;

import java.util.Date;

import javax.persistence.*;
@Entity
@DiscriminatorValue("2")
public class Client extends Personne {

	private String noClient;
	private Date dateDernierAchat;
	private double solde;
	
	public String getNoClient() { return noClient; }
	public void setNoClient(String noClient) { this.noClient = noClient; }
	@Temporal(TemporalType.DATE)
	public Date getDateDernierAchat() { return dateDernierAchat; }
	public void setDateDernierAchat(Date dateDernierAchat) { this.dateDernierAchat = dateDernierAchat; }
	public double getSolde() { return solde; }
	public void setSolde(double solde) { this.solde = solde; }
	
	public Client(){ this(0, "", "", "", null, 0.0); }
	public Client(int id, String nom, String prenom, String noClient, Date dateDernierAchat, double solde) {
		super(id, nom, prenom);
		this.noClient = noClient;
		this.dateDernierAchat = dateDernierAchat;
		this.solde = solde;
	}
	
	
	
}
