package com.loncoto.webapps.MyFirtsUltimate3Tools.models;

import java.util.List;

import com.loncoto.webapps.MyFirtsUltimate3Tools.metier.Message;

public interface IMessageDAO {
	
	public List<Message> findAll();
	public Message findByID(int id);
	public Message save(Message m);
	public void delete(int id);

}
