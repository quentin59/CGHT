package hei.projetiti.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

import hei.projetiti.dao.MailDao;
import hei.projetiti.model.Mail;
import hei.projetiti.model.Paiement;

public class MailDaoImpl implements MailDao{

	@Override
	public void envoyerMailInscription(Mail mail) {
		// TODO Auto-generated method stub
		Properties props = System.getProperties();
        props.put("mail.smtps.host","smtp.gmail.com");
        props.put("mail.smtps.auth","true");
        Session session = Session.getInstance(props, null);
        Message msg = new MimeMessage(session);
        try {
			msg.setFrom(new InternetAddress("cghtcontact@gmail.com"));
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
        try {
			msg.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(mail.getEmail(), false));
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			msg.setSubject("Inscription au CGHT");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        try {
			msg.setText("Bonjour,\n\nMerci de votre inscription au Club Green Haubourdin Tennis.\nPour vous connecter sur notre site, utilisez les identifiants de connexion suivants : \n"+mail.getEmail()+"\nMot de passe : "+mail.getMessage()+"\n\nVous pourrez bien sur changer votre mot de passe.\n\nCordialement,\n\nL'équipe du CGHT");
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
        try {
			t.close();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void envoyerMailContact(Mail mail) {
		
		// TODO Auto-generated method stub
		Properties props = System.getProperties();
        props.put("mail.smtps.host","smtp.gmail.com");
        props.put("mail.smtps.auth","true");
        Session session = Session.getInstance(props, null);
        Message msg = new MimeMessage(session);
        try {
			msg.setFrom(new InternetAddress("cghtcontact@gmail.com"));
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
			msg.setSubject(mail.getSujet());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        try {
			msg.setText("Message envoyé par : "+mail.getNom()+" "+mail.getPrenom()+"\nAdresse mail : "+mail.getEmail()+"\n\n"+mail.getMessage());
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
        try {
			t.close();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
        
        public void envoyerMailPaiementAEncaisser(Mail mail, List<Paiement> listePaiements) {
    		
    		// TODO Auto-generated method stub
    		Properties props = System.getProperties();
            props.put("mail.smtps.host","smtp.gmail.com");
            props.put("mail.smtps.auth","true");
            Session session = Session.getInstance(props, null);
            Message msg = new MimeMessage(session);
            try {
    			msg.setFrom(new InternetAddress("cghtcontact@gmail.com"));
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
    			msg.setSubject("Paiements à encaisser");
    		} catch (MessagingException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            
            String contenu = "Liste des paiements à encaisser :\n\n";
            for (Paiement paiement : listePaiements) {
				contenu = contenu+paiement.getNumCheque()+"\t"+paiement.getBanque()+"\t"+paiement.getMontant()+"€\t"+paiement.getEcheance()+"\n";	
			}
            try {
    			msg.setText(contenu);
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
            try {
    			t.close();
    		} catch (MessagingException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
	}
	
	
}