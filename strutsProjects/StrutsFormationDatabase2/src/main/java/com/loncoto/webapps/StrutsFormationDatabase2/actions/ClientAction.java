package com.loncoto.webapps.StrutsFormationDatabase2.actions;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.loncoto.webapps.StrutsFormationDatabase2.beans.Client;
import com.loncoto.webapps.StrutsFormationDatabase2.utils.ClientDAO;
import com.opensymphony.xwork2.ActionSupport;
//on implemente ServletContextAware pour apres avoir la methode a implementer setServletContext(ServletContext arg0)
public class ClientAction extends ActionSupport implements ServletContextAware
{
		
	private List<Client> clients;	
	public List<Client> getClients() { return clients; 	}

	private ClientDAO clientDAO;
	private ServletContext ctx;
	
	private int clientID;
	private String ClientNom;
	private String ClientEmail;
	private double ClientSolde;
	
	public String getClientNom() { return ClientNom; }
	public void setClientNom(String clientNom) { ClientNom = clientNom;	}
	public String getClientEmail() { return ClientEmail; }
	public void setClientEmail(String clientEmail) { ClientEmail = clientEmail; }
	public double getClientSolde() {	return ClientSolde; }
	public void setClientSolde(double clientSolde) { ClientSolde = clientSolde; }
	public int getClientID() { return clientID;	}
	public void setClientID(int clientID) {	this.clientID = clientID; }

	@Override
	public void setServletContext(ServletContext arg0) {
		ctx = arg0;
		clientDAO = (ClientDAO)ctx.getAttribute("clientDAO");
	}

	public String liste(){		
		clients = clientDAO.findAll();
		return SUCCESS;		
	}
	
	public  String edit(){
		//on recupere clientID grâce a struts2 dans struts xml on a <param name="clientID">{1}</param>
		Client c = clientDAO.findByID(clientID);
		if( c == null ){
			//en retournant "not found" on redirigera vers liste voir dans struts xml
			return "not found";
		}
		//on va setter la valeur des inputs dans edit.jsp
		setClientNom(c.getNom());
		setClientEmail(c.getEmail());
		setClientSolde(c.getSolde());
		return SUCCESS;
	}
	
	
	public String save(){
		//on ajoute un controle, en retorunant "input" on renverra vers edit.jsp voir dans struts xml
		//on ajoute un fieldError personnalisé sur le champ "clientNom" de notre formulaire
		if(getClientNom().equals("toto")){
			addFieldError("clientNom", "vous ne pouvez pas rentre le le nom toto est réservé");
			return INPUT;			
		}
		Client c = new Client(getClientID(), getClientNom(), getClientEmail(), getClientSolde());
		clientDAO.save(c);
		return SUCCESS;
		
	}
	

}
