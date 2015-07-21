package com.loncoto.InterfaceBuilder.windows;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class BorderWindow extends CommonWindow {
	

	
	public BorderWindow(Element el){
		super(el);
		//c'est une borderLayout donc :
		this.setLayout(new BorderLayout());
		
		JPanel panelNord = new JPanel();
		add(panelNord, BorderLayout.NORTH);
		JPanel panelEst = new JPanel();
		add(panelEst, BorderLayout.EAST);
		JPanel panelSud = new JPanel();
		add(panelSud, BorderLayout.SOUTH);
		JPanel panelOuest = new JPanel();
		add(panelOuest, BorderLayout.WEST);
		
		//boucler sur l'element window
        for (String balise: windowDetails.keySet()){
        	JComponent jc;
        	jc = this.createElement(balise, windowDetails.get(balise));
        	String jcPos = windowDetails.get(balise).get("pos");
        	this.addElement(jc, jcPos);
        } 
        	
	}

	@Override
	public void addElement(JComponent c, String position) {
	
		switch(position){
		
		case "north": this.panelNord.add(c);
		
		}
		
	}

}
