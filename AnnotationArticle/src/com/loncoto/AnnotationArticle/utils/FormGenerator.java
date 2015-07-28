package com.loncoto.AnnotationArticle.utils;

import java.io.IOException;
import java.lang.reflect.Field;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.loncoto.AnnotationArticle.bean.Article;

public class FormGenerator extends SimpleTagSupport{
	
	private String action;
	private String item;
	

	public String getAction() {	return action; }
	public void setAction(String action) { this.action = action; }
	public String getItem() { return item; }
	public void setItem(String item) { this.item = item; }

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		PageContext pc = (PageContext)getJspContext();
		JspWriter writer = pc.getOut();
		
		ServletRequest req = pc.getRequest();
		
		Article item = (Article)req.getAttribute("item");
		
		Class cls = item.getClass();
		Field[] champs = cls.getFields();
		
		writer.println("<form action='" + action + "'>");
		
		for ( Field f : champs ){
			FormAnnotation fa =  f.getAnnotation(FormAnnotation.class);
			if (fa != null) {
				writer.println();
				writer.println(fa.label() + " : <input type='text' name='"+ fa.name()+ "' />");
			}
			
			
		}
		
		writer.println("</form>");	
		
	
	}
	
	
	
	

}
