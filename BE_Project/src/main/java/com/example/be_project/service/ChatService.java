package com.example.be_project.service;

import com.example.be_project.model.Message;
import com.example.be_project.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ChatService {

    @Autowired
    private MessageRepository messageRepository;

    // Phương thức để gửi tin nhắn từ khách hàng đến cửa hàng
    public void sendMessageToStore(Message message) {
        Message entity = new Message();
        entity.setCustomerId(message.getCustomerId());
        entity.setSellerId(message.getSellerId());
        entity.setMessageContent(message.getMessageContent());
        entity.setType(message.getType());
        entity.setMessageDatetime(new Date());

        messageRepository.save(entity);
    }

    // Phương thức để lấy tất cả tin nhắn trong cuộc trò chuyện giữa khách hàng và cửa hàng
    public List<Message> getChatMessages(Long customerId, int sellerId) {
        return messageRepository.findMessageByCustomerIdAndSellerIdOrderByMessageDatetime(customerId, sellerId);
    }
}