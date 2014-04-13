package hei.projetiti.controllers;

import hei.projetiti.metier.Manager;
import hei.projetiti.model.Adherent;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ParametresServlet extends HttpServlet{

	private static final long serialVersionUID = 6682297944195128797L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		String licence= (String) session.getAttribute("licence");
		String newmail=request.getParameter("newmail");
		String newmdp=request.getParameter("newmdp");
		String vieuxmail=request.getParameter("vieuxmail");
		String vieuxmdp=request.getParameter("vieuxmdp");
		
		try {
			if (Manager.getInstance().adherentExiste(vieuxmail, Manager.getInstance().crypterPassword(vieuxmdp)))
			{
				try {
					Adherent adherent= new Adherent (licence, newmail, Manager.getInstance().crypterPassword(newmdp));
					Manager.getInstance().mettreAJourIdentifiantsAdherent(adherent);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				request.setAttribute("identifiantsErreur", "Identifiants actuels mauvais !!!");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/parametres.jsp");
		view.forward(request, response);
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/parametres.jsp");
		view.forward(request, response);
	}
}
