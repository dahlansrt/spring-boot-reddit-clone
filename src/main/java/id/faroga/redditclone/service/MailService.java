package id.faroga.redditclone.service;

import id.faroga.redditclone.exception.SpringRedditException;
import id.faroga.redditclone.model.NotificationEmail;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class MailService {
    private final JavaMailSender javaMailSender;
    private final MailContentBuilder mailContentBuilder;

    @Async
    void sendMail(NotificationEmail notificationEmail){
        MimeMessagePreparator messagePreparatory = mimeMessage -> {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setFrom("springboot@redditclone.id");
            mimeMessageHelper.setTo(notificationEmail.getRecipient());
            mimeMessageHelper.setSubject(notificationEmail.getSubject());
            mimeMessageHelper.setText(mailContentBuilder.build(notificationEmail.getBody()));
        };

        try{
            javaMailSender.send(messagePreparatory);
            log.info("Activation email sent.");
        }catch (MailException mailException){
            log.error("Exception occurred when sending mail", mailException);
            log.info(notificationEmail.getRecipient());
            log.info(notificationEmail.getSubject());
            throw new SpringRedditException("Exception occurred when sending mail to " + notificationEmail.getRecipient());
        }

    }
}
