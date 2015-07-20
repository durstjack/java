package com.loncoto.WebCustomTag.utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Selector extends SimpleTagSupport {

	private String items;
	private String keyProperty;
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}

	private String valueProperty;
	
	
	public String getKeyProperty() {return keyProperty;	}
	public void setKeyProperty(String keyProperty) { this.keyProperty = keyProperty; }
	public String getValueProperty() { return valueProperty; }
	public void setValueProperty(String valueProperty) { this.valueProperty = valueProperty; }

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		PageContext pc = (PageContext)getJspContext();
		JspWriter writer = pc.getOut();
		
		ServletRequest req = pc.getRequest();//pour recuperer items
		
		List data = (List)req.getAttribute(items);

		writer.println("<select name='choix'>");
		
		for(Object obj : data){
			
			try {
			//on genere les options
			//je recupere la classe de l'objet parcouru, car on ne connait pas le type d objet
			Class cls = obj.getClass();
			System.out.println("classe = " + cls.getCanonicalName());
			
			// on va recupere le getter de keyProperty
			String methodName = "get" + keyProperty.toUpperCase().charAt(0) + keyProperty.substring(1);
			System.out.println("getter key = " + methodName);			
			//je recupere le getter de keyproperty
			Method 	mkey = cls.getMethod(methodName);
			//j'appelle le getter de key property
			Object key = mkey.invoke(obj);
			
			
			// on va recupere le getter de valueProperty
			String methodName2 = "get" + valueProperty.toUpperCase().charAt(0) + valueProperty.substring(1);
			System.out.println("getter value = " + methodName2);			
			//je recupere le getter de valueproperty
			Method 	mvalue = cls.getMethod(methodName2);
			//j'appelle le getter de valueProperty
			Object value = mvalue.invoke(obj);
			
			
			//ca y est !! construction des options
			writer.println("<option value='" + key + "'>" + value + "</option>");
			
			
			
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
		
		writer.println("</select>");
		
	}

}
