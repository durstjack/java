package com.loncoto.webapps.SpringCamelot.beans;

import java.util.Random;

public class QueteEpique implements IQuete {
	
	private String description;
	private double niveau;
	
	
	public QueteEpique(String description, double niveau) {
		this.description = description;
		this.niveau = niveau;
	}

	@Override
	public String getDescription() { return description; }

	@Override
	public boolean realiserQuete() {
		Random rd = new Random();
		if(rd.nextDouble() > niveau){
			if(rd.nextDouble() > niveau){
			return true;
			}
		}
		return false;
	}

}
