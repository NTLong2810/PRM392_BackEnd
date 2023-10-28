package com.example.be_project.api;

import com.example.be_project.DTO.CartDetailDTO;
import com.example.be_project.model.Book;
import com.example.be_project.model.CartDetails;
import com.example.be_project.service.CartDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart-detail/")
public class CartDetailController {
    private final CartDetailService cartDetailService;
    @GetMapping
    public ResponseEntity<?> getCartByCustomer(@RequestParam Long CustomerId){
        List<CartDetails> list = cartDetailService.getListByCustomer(CustomerId);
        return new ResponseEntity<>(list, HttpStatusCode.valueOf(200));
    }
    @PutMapping
    public ResponseEntity<?> updateCartDetail(@RequestParam Long cartDetailId, @RequestParam int amount ){
        CartDetails cartDetails = cartDetailService.getById(cartDetailId);
        cartDetails.setQuantity(amount);
        cartDetails = cartDetailService.saveCartDetail(cartDetails);
        return new ResponseEntity<>(cartDetails, HttpStatusCode.valueOf(200));
    }
    @PostMapping
    public ResponseEntity<?> createCartDetail(@RequestBody CartDetailDTO dto){
        CartDetails cartDetails = CartDetails.builder()
                .bookId(dto.getBookId())
                .customerId(dto.getCustomerId())
                .quantity(dto.getAmount())
                .build();
        cartDetails = cartDetailService.saveCartDetail(cartDetails);
        return new ResponseEntity<>(cartDetails, HttpStatusCode.valueOf(200));
    }
    @DeleteMapping
    public ResponseEntity<?> deleteCartDetail(@RequestParam Long cartDetailId){
        cartDetailService.deleteCartDetail(cartDetailId);
        return new ResponseEntity<>(null, HttpStatusCode.valueOf(200));
    }
}
