package com.example.be_project.service;

import com.example.be_project.DTO.OrderDTO;
import com.example.be_project.model.Order;

public interface OrderService {
    Order saveOrder(OrderDTO orderDTO);

    Order getById(int orderId);

    void deleteOrderById(int orderId);
    void updateStatusById(int orderId, int statusId);
}
