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

	}

}
