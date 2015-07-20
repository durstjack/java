package com.loncoto.SingletonProject.graphic;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.loncoto.SingletonProject.config.ConfigurationManager;

public class FenetrePrincipale extends JFrame implements ActionListener {

		private JLabel label1;
		private JLabel label2;
		private JTextField champ1;
		private JTextField champ2;
		private JButton boutonSave;
		private JButton boutonOpen;
		
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
			
			boutonSave = new JButton("save config");
			boutonSave.addActionListener(this);
			add(boutonSave);
			
			boutonOpen = new JButton("nouvelle fentere");
			//pas this ici on ne peut avoir que 1 actionPerormed pour le listener this
			//on met alors une fonction anonyme pour le bouton Open
			boutonOpen.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					FenetrePrincipale f = new FenetrePrincipale();
					f.setVisible(true);
					
				}
			});
			add(boutonOpen);
			
			
		}

		@Override
		//apres un clic sur boutonSave
		public void actionPerformed(ActionEvent e) {
			ConfigurationManager cm = ConfigurationManager.getInstance();
			cm.setApplicationName(champ1.getText());
			cm.setApplicationVersion(champ2.getText());
				
			
		}

		
		
}
