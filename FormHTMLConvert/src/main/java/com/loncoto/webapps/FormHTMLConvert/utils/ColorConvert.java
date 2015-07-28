package com.loncoto.webapps.FormHTMLConvert.utils;

import java.awt.Color;
import java.util.Map;

import javassist.expr.NewArray;

import org.apache.struts2.util.StrutsTypeConverter;

public class ColorConvert extends StrutsTypeConverter {

	@Override
	//convertit de la chaine à l'objet
	public Object convertFromString(Map context, String[] values, Class toClass) {
		//si pas de saisie renvooi noir - Color.black = new Color(0, 0, 0)
		if(values.length < 1 ){ return Color.black;}
		
		System.out.println("couleur à convertir => " + values[0]);
		int red = Integer.parseInt(values[0].substring(1,3), 16);
		int green = Integer.parseInt(values[0].substring(3,5), 16);
		int blue = Integer.parseInt(values[0].substring(5,7), 16);
		return new Color(red, green, blue);
	}

	@Override
	//convertit de l'objet à la chaine
	public String convertToString(Map context, Object couleur) {
		if( couleur == null ) return "#0000000";
		Color c = (Color)couleur;
		// %02X%02X%02X => chaine de format pour le String.format
		return String.format("#%02X%02X%02X", c.getRed(), c.getGreen(), c.getBlue());
	}

}
