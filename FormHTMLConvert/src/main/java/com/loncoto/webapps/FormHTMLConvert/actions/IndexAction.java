package com.loncoto.webapps.FormHTMLConvert.actions;

import java.awt.Color;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	
	
	private static final long serialVersionUID = 1L;

	private String message;	
	private String colorString;
	
	private Color colorRGB;
	
	public Color getColorRGB() { return colorRGB; }
	public void setColorRGB(Color colorRGB) { this.colorRGB = colorRGB;	}
	
	public String getColorString() { return colorString; }
	public void setColorString(String colorString) { this.colorString = colorString; }
	public String getMessage() { return message; }
	public void setMessage(String message) { this.message = message; }

	public String index() {
		colorRGB = Color.cyan;
		return SUCCESS;
	}
	
	public String save() {
		System.out.println("recu colorString =>" + colorString);
		System.out.println("recu colorRGB =>" + colorRGB);
		return SUCCESS;
	}

}
