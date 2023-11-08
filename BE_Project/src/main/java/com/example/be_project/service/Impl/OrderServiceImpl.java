package com.example.be_project.service.Impl;

import com.example.be_project.DTO.OrderDTO;
import com.example.be_project.DTO.OrderDetailDTO;
import com.example.be_project.model.Book;
import com.example.be_project.model.Order;
import com.example.be_project.model.OrderDetails;
import com.example.be_project.repository.BookCartRepository;
import com.example.be_project.repository.OrderDetailRepository;
import com.example.be_project.repository.OrderRepository;
import com.example.be_project.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final BookCartRepository bookCartRepository;
    private final OrderDetailRepository orderDetailRepository;
    private Order order;
    private double totalPrice;
    List<OrderDetails> orderDetailsList;
    @Override
    public Order saveOrder(OrderDTO orderDTO) {
        ZoneId zoneId = ZoneId.systemDefault();
        List<OrderDetailDTO> detailDTOList = orderDTO.getDetailDTOList();
        orderDetailsList = new ArrayList<>();
        totalPrice = 0;
         order = Order.builder()
                .paymentMethodId(orderDTO.getPaymentMethodId())
                .sellerId(3)
                .customerId(orderDTO.getCustomerId())
                .orderStatusId(1)
                .orderDatetime(Date.from(LocalDateTime.now().atZone(zoneId).toInstant()))
                .shippedDatetime(Date.from(LocalDateTime.now().plusDays(3).atZone(zoneId).toInstant()))
                .shippingMethodId(orderDTO.getShippingMethodId())
                .address(orderDTO.getAddress())
                .build();

        order = orderRepository.save(order);

        detailDTOList.stream().forEach(orderDetailDTO -> {
            Book book = bookCartRepository.getById(orderDetailDTO.getBookId());
            OrderDetails orderDetails = OrderDetails.builder()
                    .orderId(order.getOrderId())
                    .bookId(orderDetailDTO.getBookId())
                    .quantity(orderDetailDTO.getQuantity())
                    .unit_price(book.getBookPrice())
                    .build();
            totalPrice += book.getBookPrice() * orderDetailDTO.getQuantity();
            orderDetailsList.add(orderDetails);
        });

        order.setPrice(totalPrice);
        order = orderRepository.save(order);

        orderDetailsList = orderDetailRepository.saveAll(orderDetailsList);
        order.setOrderDetailsList(orderDetailsList);

        return order;
    }

    @Override
    public Order getById(int orderId) {
        order = orderRepository.getById(orderId);
        orderDetailsList = orderDetailRepository.findAllByOrder(orderId);
        order.setOrderDetailsList(orderDetailsList);
        return order;
    }

    @Override
    public void deleteOrderById(int orderId) {
        orderDetailRepository.deleteAllByOrderId(orderId);
        orderRepository.deleteById(orderId);

    }

    @Override
    public void updateStatusById(int orderId, int statusId) {
        orderRepository.updateOrderStatusById(orderId, statusId);
    }
}
