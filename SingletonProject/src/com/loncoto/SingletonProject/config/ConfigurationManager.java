package com.loncoto.SingletonProject.config;

public class ConfigurationManager {
	
	private String applicationName;
	private String applicationVersion;
	
	//attribut de qui represente l'instance ;)
	private static ConfigurationManager instance = null;
	
	public String getApplicationName() { return applicationName; }
	public void setApplicationName(String applicationName) { this.applicationName = applicationName; }
	public String getApplicationVersion() {	return applicationVersion;	}
	public void setApplicationVersion(String applicationVersion) { this.applicationVersion = applicationVersion; }

	//caracteristique du singleton, le constructeur est en private
	//on ne pourra pas instancier cette classe de l'exterieur, garantit que tt le monde est la même version
	private ConfigurationManager(){		
		applicationName = "Singleton Power";
		applicationVersion = "1.0";				
	}
	
	//on procure une methode pour instancier et retourner notre objet car notre constructeur est en private
	//cette méthode elle doit etre publique
	public static ConfigurationManager getInstance(){
		if( instance == null ){
			instance = new ConfigurationManager();
		}
		return instance;
	}
	
	
}
