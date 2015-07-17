package com.loncoto.WebCustomTag.utils;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class Jackpot  extends SimpleTagSupport {
	
	private String message;
	

	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		
		//recupere le contexte de la page jsp qui appel le tag
		PageContext pc = (PageContext)getJspContext();
		
		//renvoi un JSP writer
		JspWriter writer = pc.getOut();

		//on ecrit le code qui sera imprimé dans la page jsp
		writer.println("<h3>Jackpot " + message +" </h3>");
		
	}

	
	
}
