package com.loncoto.TestThread4.principal;

import com.loncoto.TestThread4.utils.SpyDirManager;

public class Program {

	public static void main(String[] args) {

		//SpuFabrique est un spydirmanager c'est lui qui gere  le nb de spydir
		//et parametre les workers selon le fichier xml
		SpyDirManager SpyFabrique = new SpyDirManager("config.xml");
		
		SpyFabrique.runSpyDir();

	}

}
