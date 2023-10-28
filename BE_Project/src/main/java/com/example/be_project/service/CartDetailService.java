package com.example.be_project.service;

import com.example.be_project.model.Cart;
import com.example.be_project.model.CartDetails;

import java.util.List;

public interface CartDetailService {
    List<CartDetails> getListByCartId(Long cartId);

    CartDetails saveCartDetail(CartDetails cartDetails);

    void deleteCartDetail(Long cartDetailId);

    CartDetails getById(Long id);
}
