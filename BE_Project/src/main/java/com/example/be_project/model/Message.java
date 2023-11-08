package com.example.be_project.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private int messageId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "message_content")
    private String messageContent;

    @Column(name = "message_datetime")
    private Date messageDatetime;

    @Column(name = "seller_id")
    private int sellerId;
    @Column(name = "type")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

// Getter and setter methods

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public Date getMessageDatetime() {
        return messageDatetime;
    }

    public void setMessageDatetime(Date messageDatetime) {
        this.messageDatetime = messageDatetime;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }
}