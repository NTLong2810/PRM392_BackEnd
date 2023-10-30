package com.example.be_project.service.Impl;

import com.example.be_project.DTO.CartDetailDTO;
import com.example.be_project.model.Book;
import com.example.be_project.model.CartDetails;
import com.example.be_project.repository.BookCartRepository;
import com.example.be_project.repository.CartDetailRepository;
import com.example.be_project.service.CartDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartDetailServiceImpl implements CartDetailService {
    private final CartDetailRepository cartRepository;
    private final BookCartRepository bookCartRepository;
    private Book book;
    private CartDetailDTO cartDetailDTO;
    @Override
    public List<CartDetails> getListByCustomer(int customertId) {
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
    public List<CartDetailDTO> getCartByCustomer(int customerId) {
        List<CartDetails> cartDetailsList = getListByCustomer(customerId);
        List<CartDetailDTO> dtoList = new ArrayList<>();

        cartDetailsList.stream().forEach(cartDetails -> {
            book = bookCartRepository.getById(cartDetails.getBookId());
            cartDetailDTO = CartDetailDTO.builder()
                    .customerId(customerId)
                    .bookId(book.getBookId())
                    .bookImage(book.getBookImage())
                    .bookTitle(book.getBookTitle())
                    .bookPrice(book.getBookPrice())
                    .amount(cartDetails.getQuantity()).build();
            dtoList.add(cartDetailDTO);
        });

        return dtoList;
    }

}
