package com.example.be_project.repository;


import com.example.be_project.model.CartDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetails, Long> {
    @Query(value = "select * from CartDetails where customer_id = :customerId", nativeQuery = true)
    List<CartDetails> getListByCustomer(int customerId);

    CartDetails save(CartDetails cartDetails);

    void deleteById(Long cartDetailId);

    CartDetails getById(Long cartDetailId);


}
