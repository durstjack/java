package com.loncoto.webapps.StrutsJSON.actions;

import java.util.ArrayList;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;

	private String message;
	private ArrayList<String> proverbes;
	
	public ArrayList<String> getProverbes() { return proverbes; }
	public String getMessage() { return message; }
	public void setMessage(String message) { this.message = message; }

	public String index() {
		message = "bonjour depuis index le " + new Date();
		return SUCCESS;
	}
	
	public String ajaxdata() {
		proverbes = new  ArrayList<String>();
		proverbes.add("Quand tout va bien on peut compter sur les autres, quand tout va mal on ne peut compter que sur sa famille.");
		proverbes.add("Il vaut mieux se disputer avec quelqu'un d'intelligent que parler à un imbécile.");
		proverbes.add("Souviens-toi qu'au moment de ta naissance tout le monde était dans la joie et toi dans les pleurs. Vis de manière qu'au moment de ta mort, tout le monde soit dans les pleurs et toi dans la joie.");
		proverbes.add("Le bonheur ne s'acquiert pas, il ne réside pas dans les apparences, chacun d'entre nous le construit à chaque instant de sa vie avec son coeur.");
		proverbes.add("Quand on achète une maison, on regarde les poutres ; quand on prend une femme, il faut regarder la mère.");
		proverbes.add("Mieux vaut vivre un jour comme un lion que cent ans comme un mouton.");
		proverbes.add("Parmi les hommes, le plus faible est celui qui ne sait pas garder un secret. Le plus fort, celui qui maîtrise sa colère, le plus patient, celui qui cache sa pauvreté, le plus riche, celui qui se contente de la part que dieu lui a faite.");
		proverbes.add("Ne dis pas tes peines à autrui ; l'épervier et le vautour s'abattent sur le blessé qui gémit.");
		proverbes.add("Qui veut faire quelque chose trouve un moyen, qui ne veut rien faire trouve une excuse.");
		return SUCCESS;
	}
	
	

}
