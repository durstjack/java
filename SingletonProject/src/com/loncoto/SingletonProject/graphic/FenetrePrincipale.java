package com.loncoto.SingletonProject.graphic;

import java.awt.FlowLayout;

import javax.swing.*;

import com.loncoto.SingletonProject.config.ConfigurationManager;

public class FenetrePrincipale extends JFrame {

		private JLabel label1;
		private JLabel label2;
		private JTextField champ1;
		private JTextField champ2;
		
		public FenetrePrincipale(){
			//imaginons que le titre et le nom de l'application
			//le nom de l'appli doit etre accessible pour tout le monde peut importe l'endroit
			//creation d un objet config avec le design pattern Singleton
						
			super(ConfigurationManager.getInstance().getApplicationName() + " : " + "principale");
			
			label1 = new JLabel("nom application");
			label2 = new JLabel("version application");
			champ1 = new JTextField();
			champ2 = new JTextField();
			
			setLayout(new FlowLayout());
			setSize(400,300);
			setLocationRelativeTo(null);
			
			add(label1);
			add(champ1);	
			add(label2);
			add(champ2);
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			champ1.setText(ConfigurationManager.getInstance().getApplicationName());
			champ2.setText(ConfigurationManager.getInstance().getApplicationVersion());
			
			
		}

		
		
}
