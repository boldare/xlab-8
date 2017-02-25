package com.xsolve.xlab.email.sender;

public class MessageDTO {

    private String mailMessage;

    public MessageDTO() {
    }

    public MessageDTO(String mailMessage) {
        this.mailMessage = mailMessage;
    }

    public String getMailMessage() {
        return mailMessage;
    }

    public void setMailMessage(String mailMessage) {
        this.mailMessage = mailMessage;
    }
}
