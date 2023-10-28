package com.example.be_project.repository;

import com.example.be_project.model.Cart;
import com.example.be_project.model.CartDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetails, Long> {
    @Query(value = "select * from CartDetails where cart_details_id = :id", nativeQuery = true)
    List<CartDetails> getListByCartId(Long id);

    CartDetails saveAndFlush(CartDetails cartDetails);
    @Query(value = "delete from CartDetails where cart_details_id = :cartDetailId", nativeQuery = true)
    void deleteById(Long cartDetailId);

    CartDetails getReferenceById(Long cartDetailId);
}
