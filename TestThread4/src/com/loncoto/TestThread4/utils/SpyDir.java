package com.loncoto.TestThread4.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class SpyDir implements Runnable{

	private boolean mustStop;
	public void setMustStop(boolean mustStop) {
		this.mustStop = mustStop;
	}

	public String nom;
	private File directory;
	private LogManager logFile;
	private ArrayList<String> ListeFichiers;
	private ArrayList<String> ListeFichiersBuffer;

	
	public SpyDir(String nomRep, LogManager logfile){
		this.logFile = logfile;
		this.directory = new File(nomRep);
//		ListeFichiers = new ArrayList<String>();
//		ListeFichiersBuffer = new ArrayList<String>();
		this.nom = "SpyDir worker assigné au repertoire => " + nomRep;
		this.mustStop = false;
		this.ListeFichiers = listFile();
		logfile.write("demarrage du spydir");
		
	}

	//thread .sleep -- chaque thread doit tenir une liste de fichiers
	//pour voir ceux qui apparaissent et disparaissent
	@Override
	public void run() {
		while(!mustStop){
			System.out.println("execution de" + nom);
			this.ListeFichiersBuffer = listFile();
			
			//cas ajout
			//tester les fichiers qui sont dans la nouvelle et pas dans l'ancienne
			for( String file : ListeFichiersBuffer){
				if(!ListeFichiers.contains(file)){
					logFile.write("Le fichier " + file + " a été ajouté");
				}
			}
			
			//cas suppression
			//tester les fichiers qui sont dans l'ancienne et pas dans la nouvelle
			for( String file : ListeFichiers){
				if(!ListeFichiersBuffer.contains(file)){
					logFile.write("Le fichier " + file + " a été supprimé");
				}
			}		
			ListeFichiers = ListeFichiersBuffer;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) { e1.printStackTrace(); }
			
			
		}

				
	}
	
	//fonction qui liste les fichiers du rep
	public ArrayList<String> listFile(){
		ArrayList<String> fics  = new ArrayList<String>();
		fics.addAll(Arrays.asList(this.directory.list()));
		return fics;
		
	}
	
	
}
