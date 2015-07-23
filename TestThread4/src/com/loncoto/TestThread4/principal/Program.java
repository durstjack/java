package com.loncoto.TestThread4.principal;

import com.loncoto.TestThread4.utils.SpyDirManager;

public class Program {

	public static void main(String[] args) {

		
		SpyDirManager SpyFabrique = new SpyDirManager("config.xml");
		
		SpyFabrique.runSpyDir();

	}

}
