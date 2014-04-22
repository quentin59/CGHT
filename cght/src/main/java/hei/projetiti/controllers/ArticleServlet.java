package hei.projetiti.controllers;

import hei.projetiti.metier.Manager;
import hei.projetiti.model.Actualite;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ArticleServlet extends HttpServlet {

	private static final long serialVersionUID = -8830849795476708949L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getParameter("id") != null){
			Actualite actualite = Manager.getInstance().getActualite(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("titre", actualite.getTitre());
			request.setAttribute("contenu", actualite.getContenu());
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/article.jsp");
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String texte = request.getParameter("texte");
		String titre = request.getParameter("titre");
		Calendar cal = GregorianCalendar.getInstance();
		System.out.println(cal.getTime());
		HttpSession session = request.getSession(true);
		String licence= (String) session.getAttribute("licence");
		
		Actualite actualite = new Actualite(null,titre, texte, licence, cal.getTime());
		Manager.getInstance().ajouterActualite(actualite);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/index.jsp");
		view.forward(request, response);
		
	}

}
