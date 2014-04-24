package hei.projetiti.controllers;

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
		
		Properties props = System.getProperties();
        props.put("mail.smtps.host","smtp.gmail.com");
        props.put("mail.smtps.auth","true");
        Session session = Session.getInstance(props, null);
        Message msg = new MimeMessage(session);
        try {
			msg.setFrom(new InternetAddress("vendevillequentin@gmail.com"));
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
        try {
			msg.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse("vendevillequentin59@free.fr", false));
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			msg.setSubject(sujet);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        try {
			msg.setText("Message envoyé par : "+nom+" "+prenom+"\nAdresse mail : "+mail+"\n\n"+message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        try {
			msg.setSentDate(new Date());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SMTPTransport t=null;
		try {
			t = (SMTPTransport)session.getTransport("smtps");
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			t.connect("smtp.gmail.com", "contactcght@gmail.com", "motdepassetoutpourri");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			t.sendMessage(msg, msg.getAllRecipients());
		} catch (SendFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Response: " + t.getLastServerResponse());
        try {
			t.close();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        request.setAttribute("acknowledge", "Le message a bien été envoyé");
	    RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/contact.jsp");
		view.forward(request, response);
	}
	
}
