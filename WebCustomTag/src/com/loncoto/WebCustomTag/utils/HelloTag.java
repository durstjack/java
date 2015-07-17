package com.loncoto.WebCustomTag.utils;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class HelloTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		
		//recupere le contexte de la page jsp qui appel le tag
		PageContext pc = (PageContext)getJspContext();
		
		//renvoi un JSP writer
		JspWriter writer = pc.getOut();
		
		//on ecrit le code qui sera imprimé dans la page jsp
		writer.println("<h3>Bonjour nous sommes le " + new Date() + "</h3>");
		
	}

	
	
}
