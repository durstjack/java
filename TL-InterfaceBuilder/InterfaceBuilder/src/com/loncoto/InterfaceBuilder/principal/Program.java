package com.loncoto.InterfaceBuilder.principal;

import javax.swing.JFrame;

import com.loncoto.InterfaceBuilder.factory.WindowFactory;

public class Program {

	public static void main(String[] args) {

			// on instancie notre usine a fenetre
			WindowFactory wf  = new WindowFactory("fenetre1.xml");
			
			JFrame f1 = wf.BuildWindow("window1");
			JFrame f2 = wf.BuildWindow("window2");
			JFrame f3 = wf.BuildWindow("window3");
			//f1.setVisible(true);
	
		
	}

}
