package com.loncoto.FactoryProject.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//cette classe herite de DataImporter

public class CSVImporter extends DataImporter {
	
	private File csvFile;	
	
	//constructeur
	public CSVImporter( String fileName) {
		csvFile = new File(fileName);
	}
	
	@Override
	//methode du parent a redefinir (parent abstrait)
	public Map<String, String> importData() {
		
		HashMap<String, String> data = new HashMap<String, String>();		
		try {
			Scanner reader = new Scanner(csvFile);
			while(reader.hasNext()){
					String champs[] = reader.nextLine().split(";");
					data.put(champs[0], champs[1]);				
			}
		} catch (FileNotFoundException e) { e.printStackTrace(); }
		return data;
	}
	

}
