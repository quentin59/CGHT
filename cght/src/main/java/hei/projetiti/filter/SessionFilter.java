package hei.projetiti.filter;

import hei.projetiti.model.Adherent;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SessionFilter implements Filter{
    public void init(FilterConfig filterConfig) throws ServletException {}
    public void doFilter(ServletRequest request, ServletResponse response,    FilterChain chain) throws IOException, ServletException {
       
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        if(!req.getServletPath().equals("/connexion")){
            testIfAdherentConnecte(req,resp,chain);
        }
        else
        {	      
        	chain.doFilter(request, response);
        }
    }
  
    private void testIfAdherentConnecte(HttpServletRequest req,    HttpServletResponse resp,FilterChain chain) throws IOException, ServletException {
        Adherent adherentConnecte = getAdherentConnecte(req);
        if(adherentConnecte==null){
            resp.sendRedirect(req.getServletContext().getContextPath()+"/connexion");
        }else{
        chain.doFilter(req, resp);
        }
    }
    private Adherent getAdherentConnecte(HttpServletRequest req) {
        return (Adherent) req.getSession().getAttribute("adherentConnecte");
    }
    public void destroy() {    }
}



