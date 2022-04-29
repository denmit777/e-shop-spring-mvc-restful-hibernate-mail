package homework28.service.mail;

import org.thymeleaf.context.Context;

import javax.mail.MessagingException;

public interface EmailService {

    void sendEmail(String email, String subject, Context context, String template) throws MessagingException;
}
