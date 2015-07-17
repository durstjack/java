package com.loncoto.WebCustomTag.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loncoto.WebCustomTag.bean.Article;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Article> articles = new ArrayList<Article>();
		articles.add(new Article(1, "chaise design", 36.63, 3.20));
		articles.add(new Article(2, "chaise design bleu", 37.63, 3.20));
		articles.add(new Article(3, "chaise design rouge ", 38.63, 3.20));
		articles.add(new Article(4, "chaise design rose", 39.63, 3.20));
		
		//on passe notre set articles dans la request pour tester notre tag
		request.setAttribute("articles", articles);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
