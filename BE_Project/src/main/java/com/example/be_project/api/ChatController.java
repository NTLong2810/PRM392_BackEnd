package com.example.be_project.api;

import com.example.be_project.model.Message;
import com.example.be_project.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChatController {

    @Autowired
    private ChatService chatService;

    // REST endpoint để gửi tin nhắn từ khách hàng đến cửa hàng
    @PostMapping("/send")
    public void sendMessage(@RequestBody Message message) {
        chatService.sendMessageToStore(message);
    }

    // REST endpoint để lấy tất cả tin nhắn trong cuộc trò chuyện giữa khách hàng và cửa hàng
    @GetMapping("/messages")
    public List<Message> getChatMessages(@RequestParam("customerId") Long customerId,
                                         @RequestParam("sellerId") int sellerId) {
        return chatService.getChatMessages(customerId, sellerId);
    }
}