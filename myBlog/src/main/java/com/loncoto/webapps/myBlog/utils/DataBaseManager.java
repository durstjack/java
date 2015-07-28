package com.loncoto.webapps.myBlog.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



public class DataBaseManager implements ServletContextListener {
	
	private Connection base;
	
    /**
     * Default constructor. 
     */
    public DataBaseManager() {
        // TODO Auto-generated constructor stub
    }


	@Override
	public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("demarrage de databaseManager");
        String driverclass = arg0.getServletContext().getInitParameter("driverclass");
        String databaseurl = arg0.getServletContext().getInitParameter("databaseurl");
        String login = arg0.getServletContext().getInitParameter("login");
        String password = arg0.getServletContext().getInitParameter("password");
        
        try {
       	 // chargement du driver mysql
            Class.forName(driverclass);
            base = DriverManager.getConnection(databaseurl, login, password);
            System.out.println("connecté à la base");
            // creation du postDAO
            PostDAO postDAO = new PostDAO(base);
            // je met le clientDAO a disposition des servlets
            arg0.getServletContext().setAttribute("postDAO", postDAO);
            
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}


}
