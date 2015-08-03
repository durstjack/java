package com.loncoto.webapps.SpringCamelot.beans;

public interface IChevalier {

	String getNom();
	void setNom(String nom);
	void setQuete(IQuete quete);
	void partirEnQuete();
	
}
