package principal;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class Program {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// je récupere la fabrique de document builder
		DocumentBuilderFactory dbf
			= DocumentBuilderFactory.newInstance();
		
		try {
			// definition du schema utilisé
			File fschema = new File("baseexport.xsd");
			SchemaFactory sfactory = SchemaFactory
					.newInstance("http://www.w3.org/2001/XMLSchema");
			Schema schema = sfactory.newSchema(fschema);
			
			// j'associe le schema a ma document builder factory
			dbf.setSchema(schema);
			
			DocumentBuilder db = dbf.newDocumentBuilder();
			File f = new File("baseexport.xml");
			// lecture du fichier xml
			// et construction de la représentation objet
			// de celui-ci
			Document doc = db.parse(f);
			
			NodeList ln = doc.getElementsByTagName("column");
			for (int i = 0; i < ln.getLength(); i++)
			{
				// je reconverti(cast) le noeud en element
				// pour acceder a ses caracteristiques plus détaillées
				Element e = (Element)ln.item(i);
				System.out.println(e.getAttribute("name")
						+ " -> " + e.getAttribute("type"));
				// ajout d'un attribut a la balise column
				e.setAttribute("bob", "i:" + i);
			}
			
			// sauvegardons nos modifications
			DOMSource domSource = new DOMSource(doc);
			TransformerFactory tfactory =
					TransformerFactory.newInstance();
			Transformer tf = tfactory.newTransformer();
			StreamResult result = new StreamResult(
					new File("baseexport2.xml"));
			
			// ecriture du xml resultat
			tf.transform(domSource, result);
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
