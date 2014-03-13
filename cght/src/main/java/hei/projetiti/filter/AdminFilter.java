package hei.projetiti.filter;

import hei.projetiti.metier.Manager;
import hei.projetiti.model.Adherent;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AdminFilter implements Filter{
    public void init(FilterConfig filterConfig) throws ServletException {}
    public void doFilter(ServletRequest request, ServletResponse response,    FilterChain chain) throws IOException, ServletException {
       
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if(!req.getServletPath().equals("/connexion"))
        {
            testIfAdherentIsAdmin(req,resp,chain);
        }
        else
        {	      
        	chain.doFilter(request, response);
        }
    }
  
    private void testIfAdherentIsAdmin(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
        Adherent adherentConnecte = getAdherentConnecte(req);
        String statut = adherentConnecte.getStatut();
        if(!statut.equalsIgnoreCase("administrateur"))
        {
        	resp.sendRedirect(req.getServletContext().getContextPath()+"/erreur");
        }
        else
        {
        	chain.doFilter(req, resp);
        }
    }
    private Adherent getAdherentConnecte(HttpServletRequest req) {
    	HttpSession session = req.getSession(true);
		String licence= (String) session.getAttribute("licence");
		Adherent adherent = Manager.getInstance().getAdherent(licence);
        return (Adherent) adherent;
    }
    public void destroy() {    }
}


