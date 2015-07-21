package com.loncoto.InterfaceBuilder.windows;

import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
//classe commune a tte les windows

public abstract class CommonWindow extends JFrame {
	
	//window details contiendra le nom d'une balise et ses attributs(tagsDetails)
	protected HashMap<String, HashMap<String, String>> windowDetails;
	
	//tags details contiendra le nom d'un attributs et sa valeur
	protected HashMap<String, String> tagsDetails;
	
	public HashMap<String, String> getTagsDetails() { return tagsDetails; 	}
	public void setTagsDetails(HashMap<String, String> tagsDetails) { this.tagsDetails = tagsDetails; }
	
	//constructeur
	public CommonWindow(Element el){
		
		//parcours l'element el pour voir les noeuds enfants
	    Node childNode = el.getFirstChild();
	    
	    while( childNode.getNextSibling()!= null ){          
	        childNode = childNode.getNextSibling();         
	        if (childNode.getNodeType() == Node.ELEMENT_NODE) {         
	            Element childElement = (Element)childNode;             
	            //System.out.println("NODE num:-" + childElement.getTagName() + "\n" );
	            //pour l'element on parcours les attributs

	            windowDetails = new HashMap<String, HashMap<String, String>>(); 
	            String nomBalise = childElement.getNodeName();            
	            NamedNodeMap attributs = childElement.getAttributes();
	            for(int i = 0; i < attributs.getLength(); i++){
	            	
	            	//System.out.println("nom de l attribut " + nom);	            	
		            //System.out.println(attributs.item(i));
		            tagsDetails = new HashMap<String, String>();		            
		            tagsDetails.put(attributs.item(i).getNodeName(), attributs.item(i).getNodeValue());
		            
		            
		            for (String name: tagsDetails.keySet()){
		                String key = name.toString();
		                String value = tagsDetails.get(name).toString();  
		                System.out.println("clé: " + key + " a pour valeur => " + value);
		            } 
		            windowDetails.put(nomBalise, tagsDetails);		            
		            
	            }

	        }       
	    }
		
	}
	
	
	public JComponent createElement( String nomBalise, HashMap<String, String> detailsBalise ){
	
		switch( nomBalise ){
		
		case "JtextField":			
			JTextField j1 = new JTextField(Integer.parseInt(detailsBalise.get("colum")));
			return j1;			
		case "JButton":
			JButton j2 = new JButton(detailsBalise.get("text"));
			return j2;
		case "JLabel":
			JLabel j3 = new JLabel(detailsBalise.get("text"));
			return j3;		
		}
		return null;
		
	}
	
	public abstract void addElement(JComponent c, String position);
	
	



}
