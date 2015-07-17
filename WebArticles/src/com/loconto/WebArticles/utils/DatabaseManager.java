package com.loconto.WebArticles.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



public class DatabaseManager implements ServletContextListener {

    private Connection base;

    public DatabaseManager() {

    }



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
			System.out.println("connecté!!!!");
			
			//creation du client DAO
			ArticleDAO articleDAO = new ArticleDAO(base);
			
			//je met le clientDAO a disposition des servlets des JSP, des Listeners
			ce.getServletContext().setAttribute("articleDAO", articleDAO);
						
		} 
        catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        catch (SQLException e) {
			e.printStackTrace();
		}
        //! fin du chargement du driver mysql
    }


    public void contextDestroyed(ServletContextEvent ce)  { 
   	 try {
			base.close();//fermeture de la connection a la base de données
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
}
