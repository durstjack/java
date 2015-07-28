package com.loncoto.webapps.myBlog.utils;

import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.util.ValueStack;

public class RSSResult implements Result {
	
	private String channelTitre;
	private String channelDescription;
	private String channelLink;
	private String itemsCollectionName;
	private String itemTitle;
	private String itemDescription;
	
	//getters n setters
	public String getChannelTitre() { return channelTitre; }
	public void setChannelTitre(String channelTitre) { this.channelTitre = channelTitre; }
	public String getChannelDescription() { return channelDescription; }
	public void setChannelDescription(String channelDescription) {  this.channelDescription = channelDescription; }
	public String getChannelLink() { return channelLink; }
	public void setChannelLink(String channelLink) { this.channelLink = channelLink; }
	public String getItemsCollectionName() { return itemsCollectionName; }
	public void setItemsCollectionName(String itemsCollectionName) { this.itemsCollectionName = itemsCollectionName; }
	public String getItemTitle() { return itemTitle; }
	public void setItemTitle(String itemTitle) { this.itemTitle = itemTitle; }
	public String getItemDescription() { return itemDescription; }
	public void setItemDescription(String itemDescription) { this.itemDescription = itemDescription; }

	
	

	@Override
	public void execute(ActionInvocation invocation) throws Exception {
		//je recupere la value stack qui contiendra les données préparées par l'action
		ValueStack vs = invocation.getStack();
		//je recupere l'objet reponse via  lequel je genererai mon flux rss
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/xml");
		
		//construction du flux RSS
		PrintWriter pw = response.getWriter();
		pw.println("<?xml version='1.0' encoding='UTF-8'?>");
		pw.println("<rss version='2.0'>");
		pw.println("<channel>");
		pw.println("<title> " + getChannelTitre() + "</title>");		
		pw.println("<description> " + getItemDescription() + "</description>");
		pw.println("<link> " + getChannelLink() + "</link>");
		
		Iterable items = (Iterable)vs.findValue(getItemsCollectionName());
		for(Object item : items){
			pw.println("<item>");
			
			//REFLEXION
			Class cls = item.getClass();
			//itemTitle="titre" -> getMethod: "get + "T" +"itre"
			Method mTitle = cls.getMethod("get" + itemTitle.substring(0,1).toUpperCase() + itemTitle.substring(1));
			Object titleValue = mTitle.invoke(item);
			
			Method mDescription = cls.getMethod("get" + itemDescription.substring(0,1).toUpperCase() + itemDescription.substring(1));
			Object descriptionValue = mDescription.invoke(item);
			pw.println("<title> " + titleValue + "</title>");				
			pw.println("<description> " + descriptionValue + "</description>");
			pw.println("<link>http://www.google.fr?q="+ titleValue + "</link>");
			
			pw.println("</item>");
		}
		pw.println("</channel>");
		pw.println("</rss>");
		pw.close();
	}

}
