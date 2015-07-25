package com.loncoto.FactoryProject.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//cette classe herite de DataImporter


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class XMLImporter extends DataImporter {

	private File xmlFile;	
	
	//constructeur
	public XMLImporter( String fileName) {
		xmlFile = new File(fileName);
	}
	
	@Override
	//methode du parent a redefinir (parent abstrait)
	public Map<String, String> importData() {
		
		HashMap<String, String> data = new HashMap<String, String>();
		
		//permet de parser un document xml
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(xmlFile);
			NodeList nl = doc.getElementsByTagName("entry");
			
			for( int i = 0 ; i < nl.getLength(); i++){
				Element balise = (Element)nl.item(i);
				//methode sur l element pour avoir att et val
				data.put(balise.getAttribute("cle"), balise.getAttribute("valeur"));
			}
			
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}
