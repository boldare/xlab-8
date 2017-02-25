package pl.xsolve.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
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
