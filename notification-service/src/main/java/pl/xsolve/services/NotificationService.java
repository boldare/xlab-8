package pl.xsolve.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.xsolve.clients.UserAccountClient;
import pl.xsolve.model.TransactionDTO;
import pl.xsolve.model.UserAccountDTO;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class NotificationService {

    protected final JavaMailSender javaMailSender;
    protected final UserAccountClient userAccountClient;
    protected final CoinService coinService;
    protected final MessageFormatterService formattedMessage;

    @Autowired
    public NotificationService(UserAccountClient userAccountClient, JavaMailSender javaMailSender, CoinService coinService, MessageFormatterService formattedMessage) {
        this.userAccountClient = userAccountClient;
        this.javaMailSender = javaMailSender;
        this.coinService = coinService;
        this.formattedMessage = formattedMessage;
    }

    public TransactionDTO sendNotification(Long accountId) {
        TransactionDTO transactionDTO = coinService.payForEmail(accountId);
        UserAccountDTO userAccountDTO = userAccountClient.getUserAccount(accountId);

        if (transactionDTO.isStatusFlag()) {
            String preparedEmailMessage = prepareEmailMessageForUser(userAccountDTO);
            sendMail(userAccountDTO, preparedEmailMessage);
        }

        return transactionDTO;
    }

    private String prepareEmailMessageForUser(UserAccountDTO userAccountDTO) {
        return formattedMessage.getPreparedWeatherMessage(userAccountDTO);
    }

    private void sendMail(UserAccountDTO userAccountDTO, String emailMessage) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(userAccountDTO.getEmail());
            helper.setText(emailMessage, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mimeMessage);
    }
}
