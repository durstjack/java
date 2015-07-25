package com.loncoto.TestThread4.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LogManager {
	
	public String nomFichierLog;
	public File fichierLog;
	private PrintWriter writer;
	private Scanner reader;
	
	public LogManager(){		
		this("log.txt");		
	}	
	public LogManager(String nomFichierLog){		
		fichierLog = new File(nomFichierLog);
		try {
			reader = new Scanner(fichierLog);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			writer = new PrintWriter(fichierLog);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void write(String texte){		
		writer.println(texte);
		writer.flush();
	}

	public void read(){
		
		while (reader.hasNext()) {
			System.out.println(reader.nextLine());
		}
		
	}
	

}
