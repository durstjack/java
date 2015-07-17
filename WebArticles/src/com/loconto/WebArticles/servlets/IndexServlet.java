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
		System.out.println("toto1");
			List<Article> articles = articleDAO.findAll();
			System.out.println("toto2");
			
			for(Article a : articles){
				System.out.println("article avec ID: " + a.getId() );
					
			}
			
			request.setAttribute("articles", articles);
			
			getServletContext().getRequestDispatcher("/liste-articles.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
