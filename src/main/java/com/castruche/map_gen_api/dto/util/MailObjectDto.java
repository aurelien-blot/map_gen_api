package com.castruche.map_gen_api.dto.util;


import com.google.gson.JsonObject;

public class MailObjectDto {

    String senderEmail;
    String senderName;
    String receiverEmail;
    String receiverName;
    Integer templateId;
    JsonObject variables;

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public JsonObject getVariables() {
        return variables;
    }

    public void setVariables(JsonObject variables) {
        this.variables = variables;
    }
}
