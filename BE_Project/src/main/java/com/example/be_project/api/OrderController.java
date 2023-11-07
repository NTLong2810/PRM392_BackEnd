package com.example.be_project.api;

import com.example.be_project.DTO.OrderDTO;
import com.example.be_project.model.Order;
import com.example.be_project.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/order/")
public class OrderController {
    private final OrderService orderService;
    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody OrderDTO orderDTO){
        Order order = orderService.saveOrder(orderDTO);
        System.out.println("CREATE_ORDER: " + order);
        return new ResponseEntity<>(order, HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public ResponseEntity<?> getOrder(@RequestParam int orderId){
        Order order = orderService.getById(orderId);
        return new ResponseEntity<>(order, HttpStatusCode.valueOf(200));
    }
    @DeleteMapping
    public ResponseEntity<?> deleteOrder(@RequestParam int orderId){
        orderService.deleteOrderById(orderId);
        return new ResponseEntity<>(null, HttpStatusCode.valueOf(200));
    }
}
