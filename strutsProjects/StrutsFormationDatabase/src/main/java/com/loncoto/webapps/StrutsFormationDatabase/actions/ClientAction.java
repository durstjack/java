package com.loncoto.webapps.StrutsFormationDatabase.actions;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

import com.loncoto.webapps.StrutsFormationDatabase.beans.Client;
import com.loncoto.webapps.StrutsFormationDatabase.utils.ClientDAO;
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
		Client c = clientDAO.findByID(clientID);
		if( c == null ){
			return "not found";
		}
		setClientNom(c.getNom());
		setClientEmail(c.getEmail());
		setClientSolde(c.getSolde());
		return SUCCESS;
	}
	
	
	public String save(){
		
		Client c = new Client(getClientID(), getClientNom(), getClientEmail(), getClientSolde());
		clientDAO.save(c);
		return SUCCESS;
		
	}
	

}
