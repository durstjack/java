package com.loconto.webfirstjdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class DatabaseManager
 *
 */
public class DatabaseManager implements ServletContextListener {

    private Connection base;
	
	//constructor. 
    public DatabaseManager() {

    }

	// Initialisation de la WebApp - @see ServletContextListener#contextInitialized(ServletContextEvent)
    public void contextInitialized(ServletContextEvent ce)  { 
         System.out.println("demarrage de DatabaseManager");
         String driverclass = ce.getServletContext().getInitParameter("driverclass");
         String databaseurl = ce.getServletContext().getInitParameter("databaseurl");
         String login = ce.getServletContext().getInitParameter("login");
         String password = ce.getServletContext().getInitParameter("password");
         
         //chargement du driver mysql
         try 
         {        	 
			Class.forName(driverclass); // charge la classe dont on donne le nom en parametre
			base = DriverManager.getConnection(databaseurl, login, password);
			System.out.println("connect�!!!!");
						
		} 
         catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
         catch (SQLException e) {
			e.printStackTrace();
		}
         //! fin du chargement du driver mysql

         
    }
	// Fin de la WebApp - @see ServletContextListener#contextDestroyed(ServletContextEvent)
     public void contextDestroyed(ServletContextEvent arg0)  { 
    	 try {
			base.close();//fermeture de la connection a la base de donn�es
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }


	
}
