//package com.example.be_project.api;
//
//import com.example.be_project.model.Message;
//import com.example.be_project.repository.MessageRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/chat")
//public class ChatController {
//    @Autowired
//    private MessageRepository messageRepository;
//
//    // API endpoint để gửi tin nhắn
//    @PostMapping("/send")
//    public Message sendMessage(@RequestBody Message message) {
//        // Lưu tin nhắn vào cơ sở dữ liệu
//        return messageRepository.save(message);
//    }
//
//    // API endpoint để lấy lịch sử tin nhắn giữa khách hàng và cửa hàng
//    @GetMapping("/history")
//    public List<Message> getChatHistory(@RequestParam int customerId, @RequestParam int sellerId) {
//        // Truy vấn cơ sở dữ liệu để lấy lịch sử tin nhắn
//        return messageRepository.findByCustomerAndSeller(customerId, sellerId);
//    }
//}