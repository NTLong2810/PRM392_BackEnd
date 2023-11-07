package com.example.be_project.service;

import com.example.be_project.DTO.OrderDTO;
import com.example.be_project.model.Order;
import com.example.be_project.model.OrderDetails;

public interface OrderDetailsService {
    OrderDetails saveOrderDetails(OrderDetails orderDetails);

}
