package com.example.be_project.service;


import com.example.be_project.model.Book;
import com.example.be_project.model.CartDetails;

import java.util.List;

public interface CartDetailService {
    List<CartDetails> getListByCustomer(Long customerId);

    CartDetails saveCartDetail(CartDetails cartDetails);

    void deleteCartDetail(Long cartDetailId);

    CartDetails getById(Long id);

    Book getCartByCustomer(Long customerId);
}
