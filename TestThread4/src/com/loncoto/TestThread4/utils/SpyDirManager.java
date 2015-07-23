package com.loncoto.TestThread4.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;



public class SpyDirManager {
	
	public ArrayList<String> rep_desc;
	public ArrayList<SpyDir> tab_SpyDir;
	public int nbSpyDir;
	public  ArrayList<Thread> tab_Threads;
	
	//constructeur
	public SpyDirManager(String configFile){
		
		this.nbSpyDir = 0;
		tab_SpyDir = new ArrayList<SpyDir>();
		rep_desc = new ArrayList<String>();
		
		//on parse le xml et on rempli un tableau our connaitre la liste des repertoires
		//on créé autant de workers que de repertoires
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(configFile);			
			NodeList nl = doc.getElementsByTagName("rep");
			
			for (int i =0; i < nl.getLength(); i++) {
				if (nl.item(i) instanceof Element) {
					Element rep = (Element)nl.item(i);
					rep_desc.add(rep.getTextContent());
					nbSpyDir++;
				}
			}
		}
		catch (ParserConfigurationException e) { e.printStackTrace();}
		catch (SAXException e) { e.printStackTrace(); }
		catch (IOException e) { e.printStackTrace(); }
		
		tab_Threads = new ArrayList<Thread>();
		LogManager lm = new LogManager();
		int numeroSpyDir = 1;
		//regarde si rep sont bien des rep
		//et construit des spydir en leur passant chacun un rep
		for( String rep : rep_desc){
			
			File directory = new File(rep);			
			
			if( directory.exists() && directory.isDirectory()){				
				tab_SpyDir.add(this.buildSpyDir(rep, lm));
				System.out.println("construction d un spydir pour le rep " + rep);
			}
			
		}		
		
	}	
	
	//fonction qui creera les spydir en fonction du tableau rep_desc
	public SpyDir buildSpyDir(String nomRep, LogManager lm){
		return new SpyDir(nomRep, lm);
	}

	//fonction qui lancera les spydir stockés dans tableau tab_SpyDir
	public void runSpyDir(){
		for(SpyDir worker : tab_SpyDir){			
			Thread t = new Thread(worker);
			tab_Threads.add(t);
			t.start();			
		}
	}
	
	

}
