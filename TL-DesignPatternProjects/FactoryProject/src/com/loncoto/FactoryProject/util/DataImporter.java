package com.loncoto.FactoryProject.util;

import java.io.File;
import java.util.Map;

//va servir de parent a plusieurs implementations
// l utilisateur n'a pas a se soucier du type de fichier a ouvrir
public abstract class DataImporter {

	//methode qui servira a importer les donnees 
	//en abstraite car chaque version devra la definir
	public abstract Map<String, String> importData();
	
	// la fonction fabrique, c'est elle qui choisira la classe concrete du dataImporter
	// et qui saura comment l'instancier. Renvoi un objet DataImporter
	public static DataImporter BuidDataImporter(String filename){
		String extension = filename.substring(filename.length() - 3);
		
		switch(extension){
		case "xml":
			return new XMLImporter(filename);
		case "csv":
			return new CSVImporter(filename);
		}
		//au cas ou il ne rentre dans aucune extension connue
		return null;
	}
	
	
	
}
