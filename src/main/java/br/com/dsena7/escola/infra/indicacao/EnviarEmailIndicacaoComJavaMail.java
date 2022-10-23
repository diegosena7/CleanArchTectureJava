package br.com.dsena7.escola.infra.indicacao;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import br.com.dsena7.escola.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.dsena7.escola.dominio.aluno.Aluno;
import br.com.dsena7.escola.dominio.aluno.EmailNaoEnviadoException;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {

	@Override
	public void enviarPara(Aluno aluno) {
		
//		String to = aluno.getEmail();// change accordingly
//		String from = "sonoojaiswal1987@gmail.com";
//		String host = "localhost";// or IP address
		
		String username = "diego.tjdosantos@gmail.com";
		String password = "Santosfc@1912";

		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.mailtrap.io");
		prop.put("mail.smtp.port", "25");
		prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
		
		Session session = Session.getInstance(prop, new Authenticator() {
		    @Override
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(username, password);
		    }
		});

		// compose the message
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from@gmail.com"));
			message.setRecipients(
			  Message.RecipientType.TO, InternetAddress.parse("to@gmail.com"));
			message.setSubject("Mail Subject");

			String msg = "This is my first email using JavaMailer";

			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);

			message.setContent(multipart);

			Transport.send(message);
			System.out.println("message sent successfully....");

		} catch (EmailNaoEnviadoException | MessagingException mex) {
			mex.printStackTrace();
			throw new EmailNaoEnviadoException(aluno.getEmail());
		}
	}
}