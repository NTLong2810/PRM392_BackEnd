package com.example.be_project.service;


import com.example.be_project.DTO.CartDetailDTO;
import com.example.be_project.model.Book;
import com.example.be_project.model.CartDetails;

import java.util.List;

public interface CartDetailService {
    List<CartDetails> getListByCustomer(int customerId);

    CartDetails saveCartDetail(CartDetails cartDetails);

    void deleteCartDetail(Long cartDetailId);

    CartDetails getById(Long id);

    List<CartDetailDTO> getCartByCustomer(int customerId);
}
