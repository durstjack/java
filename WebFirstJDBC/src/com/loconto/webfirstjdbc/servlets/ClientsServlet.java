package com.loconto.webfirstjdbc.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loconto.webfirstjdbc.beans.Clients;
import com.loconto.webfirstjdbc.utils.ClientsDAO;

/**
 * Servlet implementation class ClientsServlet
 */
public class ClientsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ClientsDAO clientsDAO;

    public ClientsServlet() {
        super();

    }

    //attention quand on redefinit la lmethode init
    //eclipse oublie de mettre la reference au constructeur deu parent et cela poseer  probleme 
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		clientsDAO = (ClientsDAO)getServletContext().getAttribute("clientDAO");//on recupere le clientDAO mis dans le contexte
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//grace a la methode findall de la classe ClientsDAO
			//on aura ts les clients dans la variable "clients"
			List<Clients> clients = clientsDAO.findAll();
			request.setAttribute("clients", clients);
			
			getServletContext().getRequestDispatcher("/liste-clients.jsp").forward(request, response);;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//quand on recoit la submission du formulaire
		//bouton editer
		
		String action = request.getParameter("action");
		
		switch(action)
		{
		case "editer":
		//provient de de liste-clients.jsp
			int ID = Integer.parseInt(request.getParameter("id"));
			Clients client = clientsDAO.findClient(ID);
			request.setAttribute("client", client);			
			getServletContext().getRequestDispatcher("/editer-clients2.jsp").forward(request, response);
		break;
		
		case "enregistrer":
			Clients clientTemp = new Clients(Integer.parseInt(request.getParameter("id")),
																(request.getParameter("nom")),
																(request.getParameter("email")),
																Double.parseDouble(request.getParameter("solde")));
			clientsDAO.save(clientTemp);
			//puis on renvoi une redirection http pour eviter les pb apres le save
			//genre refresh de la page etc
			response.sendRedirect("ClientsServlet"); 
		break;
		
	
		}
	

	}

}
