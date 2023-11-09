package com.example.be_project.repository;

import com.example.be_project.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order save(Order order);

    Order getById(Integer orderId);
    @Modifying
    @Transactional
    void deleteById(int orderId);


    @Modifying
    @Transactional
    @Query(value = "update Orders set order_status_id = :statusId where order_id = :orderId", nativeQuery = true)
    void updateOrderStatusById(int orderId, int statusId);
}
