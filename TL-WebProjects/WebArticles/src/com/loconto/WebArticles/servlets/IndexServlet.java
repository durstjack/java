package com.loconto.WebArticles.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loconto.WebArticles.beans.Article;
import com.loconto.WebArticles.utils.ArticleDAO;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ArticleDAO articleDAO;

    public IndexServlet() {
        super();

    }


	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("passage dans init");
		//on recupere le DAO
		this.articleDAO = (ArticleDAO)getServletContext().getAttribute("articleDAO");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			//on recupere les url afin de voir si la requete get concerne un tri par prix ou par poids
			String uri = request.getRequestURI();
			String[] champs = uri.split("/");
			String orderBy = champs[champs.length - 1];
			
			int choix = ArticleDAO.ORDER_BY_DEFAULT;
			switch(orderBy){
			case "prix":
				choix = ArticleDAO.ORDER_BY_PRIX;
				break;
			case "poids":
				choix = ArticleDAO.ORDER_BY_POIDS;
				break;
			case "libelle":
				choix = ArticleDAO.ORDER_BY_LIBELLE;
				break;	
			
			}
			List<Article> articles = articleDAO.findAll(choix);
			request.setAttribute("articles", articles);			
			getServletContext().getRequestDispatcher("/liste-articles.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//quand on recoit la submission du formulaire
		//bouton editer		
		String action = request.getParameter("action");
		switch(action)
		{
		case "editer":
			
			int ID = Integer.parseInt(request.getParameter("id"));
			Article article = articleDAO.findByID(ID);
			request.setAttribute("article", article);			
			getServletContext().getRequestDispatcher("/editer-article.jsp").forward(request, response);			
			break;
		
		case "sauver":			
			Article a = new Article(Integer.parseInt(request.getParameter("id")),
													request.getParameter("libelle"),
													Double.parseDouble(request.getParameter("prix")),
													Double.parseDouble(request.getParameter("poids")));
			articleDAO.save(a);
			response.sendRedirect("IndexServlet");
			break;
		case "creer":			
			Article a2 = new Article();
			request.setAttribute("article", a2);
			getServletContext().getRequestDispatcher("/editer-article.jsp").forward(request, response);
			
			break;
			
		case "supprimer":
			int idAsupp = Integer.parseInt(request.getParameter("id"));
			articleDAO.delete(idAsupp);
			response.sendRedirect("IndexServlet");
			break;
			
		}
		
		
	}

}
