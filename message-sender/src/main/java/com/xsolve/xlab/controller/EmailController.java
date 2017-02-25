package com.xsolve.xlab.controller;

import com.xsolve.xlab.email.sender.EmailSender;
import com.xsolve.xlab.email.sender.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/senders")
public class EmailController {

    private final EmailSender emailSender;

    @Value("${recipient.email}")
    private String recipientEmail;

    @Value("${email.title}")
    private String emailTitle;

    @Autowired
    public EmailController(EmailSender emailSender){
        this.emailSender = emailSender;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/mail")
    public ResponseEntity<?> sendMail(@RequestBody MessageDTO message) {

        emailSender.sendEmail(recipientEmail, emailTitle, message.getMailMessage());

        return new ResponseEntity<>(HttpStatus.OK);

    }
}