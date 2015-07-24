package com.loncoto.basic.StrutsFormulaire.actions;
import java.util.ArrayList;
import java.util.List;

import com.loncoto.basic.StrutsFormulaire.bean.Article;
import com.opensymphony.xwork2.ActionSupport;

public class FormAction extends ActionSupport {
	

	private static final long serialVersionUID = 1L;
	private String libelle;
	private double prix;
	private double poids;
	private int articleID;
	
	
	public int getArticleID() {
		return articleID;
	}


	private List<Article> articles;	
	public List<Article> getArticles() { return articles; }
	
	
	public String getLibelle() { return libelle; }
	public void setLibelle(String libelle) { this.libelle = libelle; }
	public double getPrix() { return prix; }
	public void setPrix(double prix) { this.prix = prix; }
	public double getPoids() { return poids; }
	public void setPoids(double poids) { this.poids = poids; }

	public String index(){
		return SUCCESS;
	}
	
	//reception du formulaire
	public String enregistrer(){
		System.out.println("reçu un article de libelle: " + getLibelle() + " de poids : " + getPoids() + ", il coute " + getPrix() +"€");
		
		return SUCCESS;
	}

	
	//reception du formulaire
	public String list(){
		articles = new ArrayList<Article>();
		articles.add(new Article(1, "table teck noir", 20.90, 17));
		articles.add(new Article(2, "table teck blanche", 50.90, 13));
		articles.add(new Article(3, "table teck verte", 80.90, 12));
		articles.add(new Article(4, "table teck avec insert ceramique", 120.90, 27));
		articles.add(new Article(4, "thierry", 120.90, 27));
		articleID = 2;
		return SUCCESS;
	}
	
	

}
