package com.loncoto.webapps.SpringCamelot.beans;

import java.util.Random;

public class QueteStandard implements IQuete {
	
	private String description;
	private double niveau;

	@Override
	public String getDescription() { return description; }
	public double getNiveau() { return niveau; }

	@Override
	public boolean realiserQuete() {
		Random rd = new Random();
		if(rd.nextDouble() > niveau){ return true;}
		return false;
	}
	
	public QueteStandard(String description, double niveau) {
		this.description = description;
		this.niveau = niveau;
	}

	
	
}
