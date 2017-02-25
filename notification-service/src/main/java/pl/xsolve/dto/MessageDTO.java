package pl.xsolve.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MessageDTO {

    private String smsMessage;
    private String mailMessage;

    public MessageDTO() {

    }

    public MessageDTO(String smsMessage, String mailMessage) {
        this.smsMessage = smsMessage;
        this.mailMessage = mailMessage;
    }

    public String getSmsMessage() {
        return smsMessage;
    }

    public void setSmsMessage(String smsMessage) {
        this.smsMessage = smsMessage;
    }

    public String getMailMessage() {
        return mailMessage;
    }

    public void setMailMessage(String mailMessage) {
        this.mailMessage = mailMessage;
    }
}