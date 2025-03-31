package enviando.email;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import javax.activation.DataHandler;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ObjetoEnviaEmail {

    private String userName = "magnoemailjava@gmail.com";
    private String password = "*********";
    private String listaDestinatarios = "";
    private String nomeRemetente = "";
    private String assuntoEmail = "";
    private String textoEmail = "";

    public ObjetoEnviaEmail(String listaDestinatarios, String nomeRemetente, String assuntoEmail, String textoEmail) {
        this.listaDestinatarios = listaDestinatarios;
        this.nomeRemetente = nomeRemetente;
        this.assuntoEmail = assuntoEmail;
        this.textoEmail = textoEmail;
    }

    public void enviarEmail(boolean envioHtml) throws Exception{

        Properties properties = new Properties();

        properties.put("mail.smtp.ssl.trust", "*"); //Autenticar com segurança
        properties.put("mail.smtp.auth", "true"); //Autorização
        properties.put("mail.smtp.starttls", "true"); //Autenticação
        properties.put("mail.smtp.host", "smtp.gmail.com"); //Servidor Gmail Google
        properties.put("mail.smtp.port", "465"); //Porta do Servidor
        properties.put("mail.smtp.socketFactory.port", "465"); //Declara a porta  a ser conectada pelo socket
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //Classe socket conexão

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });

        Address[] toUser = InternetAddress.parse(listaDestinatarios);

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(userName, nomeRemetente)); // email que está enviando
        message.setRecipients(Message.RecipientType.TO, toUser); // múltiplos emails destino
        message.setSubject(assuntoEmail); // Assunto do email

        if (envioHtml){
            message.setContent(textoEmail, "text/html; charset=utf-8");
        }else {
            message.setText(textoEmail); // Corpo do e-mail
        }

        Transport.send(message);

    }

    public void enviarEmailAnexo(boolean envioHtml) throws Exception{

        Properties properties = new Properties();

        properties.put("mail.smtp.ssl.trust", "*"); //Autenticar com segurança
        properties.put("mail.smtp.auth", "true"); //Autorização
        properties.put("mail.smtp.starttls", "true"); //Autenticação
        properties.put("mail.smtp.host", "smtp.gmail.com"); //Servidor Gmail Google
        properties.put("mail.smtp.port", "465"); //Porta do Servidor
        properties.put("mail.smtp.socketFactory.port", "465"); //Declara a porta  a ser conectada pelo socket
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //Classe socket conexão

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });

        Address[] toUser = InternetAddress.parse(listaDestinatarios);

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(userName, nomeRemetente)); // email que está enviando
        message.setRecipients(Message.RecipientType.TO, toUser); // múltiplos emails destino
        message.setSubject(assuntoEmail); // Assunto do email

        // Parte 1 do e-mail que é texto e a descrição do e-mail
        MimeBodyPart corpoEmail = new MimeBodyPart();

        if (envioHtml){
            corpoEmail.setContent(textoEmail, "text/html; charset=utf-8");
        }else {
            corpoEmail.setText(textoEmail); // Corpo do e-mail
        }

        List<FileInputStream> arquivos = new ArrayList<FileInputStream>();
        arquivos.add(simuladorDePDF());

        //Corpo do e-mail
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(corpoEmail);

        int index = 1;
        for (FileInputStream fileInputStream : arquivos) {

            // Parte 2 do e-mail que são os anexo em pdf
            MimeBodyPart anexoEmail = new MimeBodyPart();

            anexoEmail.setDataHandler(new DataHandler(new ByteArrayDataSource(fileInputStream, "application/pdf")));
            anexoEmail.setFileName("anexoemail" + index + ".pdf");
            // Juntando as duas partes do e-mail - Menssagem e anexo
            multipart.addBodyPart(anexoEmail);
            index++;
        }
        message.setContent(multipart);

        Transport.send(message);

    }
    // Esse método simula o PDF ou qualquer arquivo que possa ser enviado
    private FileInputStream simuladorDePDF() throws Exception {

        Document document = new Document();
        File file = new File("anexo.pdf");
        file.createNewFile();
        PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();
        document.add(new Paragraph("Conteúdo do PDF anexo com Java Mail"));
        document.close();

        return new FileInputStream(file);
    }
}
