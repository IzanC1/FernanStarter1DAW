package biblioteca;

import java.util.Scanner;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * La clase <code>FuncionesCorreo</code> proporciona funcionalidades para enviar correos de
 * verificación y validar códigos de verificación introducidos por el usuario.
 * Esta clase incluye métodos para enviar un correo con un código de verificación y
 * para validar dicho código.
 */
public class FuncionesCorreo {

    private static final Scanner sc = new Scanner(System.in);

    /**
     * Envia un correo de verificación al usuario con un código generado aleatoriamente.
     * El usuario debe introducir el código recibido para confirmar su identidad.
     * Si el código introducido es correcto, el proceso de verificación finaliza con éxito.
     *
     * @see #enviarConGMail(String, String, String)
     */
    public static void verificacionCorreo() {
        Scanner sc = new Scanner(System.in);

        System.out.println("VERIFICACIÓN. Revisa el código que hemos enviado a tu gmail.");
        int codigoVerificacion = (int) (Math.random() * 8999 + 1000);

        String destinatario = "isalexis.design@gmail.com";
        String asunto = "Correo de verificación";
        String cuerpo = "<h1>" + codigoVerificacion + "</h1>" + "<p>IMPORTANTE: <strong>NO COMPARTAS ESTE CÓDIGO</strong></p>";

        // Enviar el correo con el código de verificación
        enviarConGMail(destinatario, asunto, cuerpo);

        // Solicitar el código de verificación al usuario
        for (int i = 3; i > 0; i--) {
            System.out.println("Introduce el código de verificación:");
            int codigoIntroducidoPorUsuario = sc.nextInt();

            if (codigoIntroducidoPorUsuario == codigoVerificacion) {
                System.out.println("Bienvenido al sistema.");
                break;
            } else {
                System.out.println("\033[31mCódigo de verificación incorrecto.\033[0m");
                System.out.println("Te quedan " + (i - 1) + " intentos.");
            }
        }
    }

    /**
     * Envía un correo electrónico a través de Gmail utilizando las credenciales especificadas.
     * El correo enviado contiene un asunto y un cuerpo definidos por los parámetros.
     *
     * @param destinatario La dirección de correo electrónico del destinatario.
     * @param asunto       El asunto del correo.
     * @param cuerpo       El cuerpo del correo, en formato HTML.
     * @throws Exception Si ocurre un error durante el envío del correo.
     */
    public static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
        final String remitente = "alexis.lopez.1506@fernando3martos.com";
        final String clave = "gphj dsbt qryu ugvs";

        // Configuración de propiedades para enviar el correo
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", clave);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");

        // Creación de la sesión y el mensaje
        Session session = Session.getDefaultInstance(props);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setContent(cuerpo, "text/html; charset=utf-8");

            // Enviar el mensaje
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (Exception me) {
            me.printStackTrace();
        }
    }
}