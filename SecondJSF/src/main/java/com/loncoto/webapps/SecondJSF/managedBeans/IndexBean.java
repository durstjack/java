package com.loncoto.webapps.SecondJSF.managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class IndexBean 
{
	private String nom;
	private String password;
	
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
	//CDI Content Depency Injection
	@ManagedProperty(value="#{userStore}")
	private UsersStorage myStore;
	
	public UsersStorage getMyStore() { return myStore; }
	public void setMyStore(UsersStorage myStore) { this.myStore = myStore; }

	public String login() {
//		if(getPassword().length() < 3 || getPassword().length() > 12 ){
//			return "error";
//		}
//		else{
//			return "success";
//		}
		if( myStore.verifyLogin(getNom(), getPassword()) ){	return "success"; }
		else{ return "error"; }
	
	}
	
}
