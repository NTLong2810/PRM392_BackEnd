package com.example.be_project.repository;

import com.example.be_project.model.OrderDetails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetails, Integer> {
    OrderDetails save(OrderDetails orderDetails);

    @Override
    <S extends OrderDetails> List<S> saveAll(Iterable<S> entities);

    @Query(value = "select * from OrderDetails where order_id = :orderId", nativeQuery = true)
    List<OrderDetails> findAllByOrder(int orderId);

    @Modifying
    @Transactional
    void deleteAllByOrderId(int orderId);
}
