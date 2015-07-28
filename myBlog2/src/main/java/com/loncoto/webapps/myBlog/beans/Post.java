package com.loncoto.webapps.myBlog.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {
	
	public static final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private int id;
	private String titre;
	private String corps;
	private Date date;
	
	//getters and setters
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getTitre() { return titre; }
	public void setTitre(String titre) { this.titre = titre; }
	public String getCorps() { return corps; }
	public void setCorps(String corps) { this.corps = corps; }
	public Date getDate() {	return date; }
	public void setDate(Date date) {this.date = date; }
	
	
	//constructeurs
	public Post() {this(0, "", "", new Date());}
	public Post(int id, String titre, String corps, Date date) {
		this.id = id;
		this.titre = titre;
		this.corps = corps;
		this.date = date;
	}
	
	
}