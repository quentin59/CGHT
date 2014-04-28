package hei.projetiti.controllers;

import hei.projetiti.metier.Manager;
import hei.projetiti.model.Mail;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.mail.smtp.SMTPTransport;

public class ContactServlet extends HttpServlet{

	private static final long serialVersionUID = 5001758692639294978L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/contact.jsp");
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String mail=request.getParameter("mail");
		String sujet=request.getParameter("sujet");
		String message=request.getParameter("message");
		
		Mail email = new Mail(nom, prenom, mail, sujet, message);
		Manager.getInstance().envoyerMailContact(email);
        request.setAttribute("acknowledge", "Le message a bien été envoyé");
	    RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/contact.jsp");
		view.forward(request, response);
	}
	
}
