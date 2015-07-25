package com.loncoto.FactoryProject.principal;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.loncoto.FactoryProject.util.DataImporter;

public class Program {

	public static void main(String[] args) {

		
		Scanner reader = new Scanner(System.in);
		System.out.println("nom du fichier a importer");
		String name = reader.nextLine();
		
		//exemple concret de factory, peut importe le nom saisie 
		//on va charger l'objet adequat, sans que le user ait a s'en soucier
		
		DataImporter di = DataImporter.BuidDataImporter(name);
		Map<String, String> data = di.importData();
		
		for( Entry<String, String> entree : data.entrySet() ){
			System.out.println(entree);
		}

	}

}
