package com.loncoto.InterfaceBuilder.factory;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.loncoto.InterfaceBuilder.windows.*;

public class WindowFactory {
	
	private File xmlFile;
	//on cree un tableau qui recevra les associations "nom" => "noeud(type window)"
	private HashMap<String, Element> TabWindows;
	
	//constructeur de windowfactory
	public WindowFactory( String configFile ){
		
		TabWindows = new HashMap<String, Element>();
		xmlFile = new File(configFile);
		//permet de parser un document xml
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(xmlFile);
			//on affecte la liste de noeuds window a la variable nl
			NodeList nl = doc.getElementsByTagName("window");			
			
			for( int i = 0 ; i < nl.getLength(); i++){
				Element balise = (Element)nl.item(i);
				//System.out.println("window trouvé " + balise.getAttribute("name"));
				//on remplit le tableau
				TabWindows.put(balise.getAttribute("name"), balise);
			}
			
		} catch (ParserConfigurationException | SAXException | IOException e) {	e.printStackTrace(); }

		
		
	}
	
	// la fonction fabrique, c'est elle qui choisira la classe
	// et qui saura comment l'instancier. Renvoi un objet JFrame
	public JFrame BuildWindow(String windowName){
		
		//on recupere notre noeud window et son type
		Element el = TabWindows.get(windowName);
		String type = el.getAttribute("type");
		
		//switch case selon le type de fenetre		
		switch(type){
			case "BorderWindow": 
				return new BorderWindow(el);
			case "FlowWindow":
				return new FlowWindow(el);				
			case "GridWindow": 
				return new GridWindow(el);		
		}
		return null;

	}
	

}
