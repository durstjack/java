package com.loconto.webfirstjdbc.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class DatabaseManager
 *
 */
public class DatabaseManager implements ServletContextListener {

    // Default constructor. 
    public DatabaseManager() {
        // TODO Auto-generated constructor stub
    }

	// Initialisation de la WebApp - @see ServletContextListener#contextInitialized(ServletContextEvent)
    public void contextInitialized(ServletContextEvent arg0)  { 
         System.out.println("demarrage de DatabaseManager");
         

    }
	// Fin de la WebApp - @see ServletContextListener#contextDestroyed(ServletContextEvent)
     public void contextDestroyed(ServletContextEvent arg0)  { 

    }


	
}
