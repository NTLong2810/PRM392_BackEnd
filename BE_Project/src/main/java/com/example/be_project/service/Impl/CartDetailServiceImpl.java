package com.example.be_project.service.Impl;

import com.example.be_project.model.Book;
import com.example.be_project.model.CartDetails;
import com.example.be_project.repository.CartDetailRepository;
import com.example.be_project.service.CartDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartDetailServiceImpl implements CartDetailService {
    private final CartDetailRepository cartRepository;

    @Override
    public List<CartDetails> getListByCustomer(Long customertId) {
        return cartRepository.getListByCustomer(customertId);
    }

    @Override
    public CartDetails saveCartDetail(CartDetails cartDetails) {
        return cartRepository.saveAndFlush(cartDetails);
    }

    @Override
    public void deleteCartDetail(Long cartDetailId) {
        cartRepository.deleteById(cartDetailId);
    }

    @Override
    public CartDetails getById(Long id) {
        return cartRepository.getById(id);
    }

    @Override
    public Book getCartByCustomer(Long customerId) {
        return null;
    }

}
