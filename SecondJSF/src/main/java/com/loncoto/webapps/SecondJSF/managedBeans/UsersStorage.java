package com.loncoto.webapps.SecondJSF.managedBeans;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="userStore")
@ApplicationScoped
public class UsersStorage {
	
	private Map<String, String> users;
	
	public UsersStorage(){
		users = new HashMap<String, String>();
		users.put("vincent", "1234");
		users.put("thierry", "azerty");
		users.put("franck", "password");
			
	}
	
	public boolean verifyLogin(String login, String password) {
		if(!users.containsKey(login)) return false;
		return password.equals(users.get(login));
	}

}
