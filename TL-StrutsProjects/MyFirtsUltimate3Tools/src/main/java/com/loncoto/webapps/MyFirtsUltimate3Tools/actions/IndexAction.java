package com.loncoto.webapps.MyFirtsUltimate3Tools.actions;

import java.util.Date;
import java.util.List;

import org.aspectj.bridge.IMessage;

import com.loncoto.webapps.MyFirtsUltimate3Tools.metier.Message;
import com.loncoto.webapps.MyFirtsUltimate3Tools.models.IMessageDAO;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	
	
	private static final long serialVersionUID = 1L;

	private IMessageDAO messageDAO;
	
	public int messageID;
	public String messageTitre;
	public String messageCorps;
	
	public int getMessageID() {	return messageID; }
	public void setMessageID(int messageID) { this.messageID = messageID; }
	public String getMessageTitre() { return messageTitre; }
	public void setMessageTitre(String messageTitre) { this.messageTitre = messageTitre; }
	public String getMessageCorps() { return messageCorps; }
	public void setMessageCorps(String messageCorps) { this.messageCorps = messageCorps; }
	
	
	public IMessageDAO getMessageDAO() { return messageDAO; }
	public void setMessageDAO(IMessageDAO messageDAO) {
		System.out.println("injection du DAO par Spring....");
		this.messageDAO = messageDAO;
	}
	
	//pour que la page jsp puisse recuperer
	private List<Message> messages;
	public List<Message> getMessages() {
		return messages;
	}
	public String index() {
		messages = messageDAO.findAll(); //ici requetage de la base via le DAO
		return SUCCESS;
	}
	public String edit() {
		Message m = messageDAO.findByID(getMessageID());
		if( m == null ) return "notfound";
		setMessageTitre(m.getTitre());;
		setMessageCorps(m.getCorps());
		return SUCCESS;
	}
	public String save() {
		Message m = new Message();
		m.setId(getMessageID());
		m.setTitre(getMessageTitre());
		m.setCorps(getMessageCorps());
		messageDAO.save(m);
		return "success";
	}

}
