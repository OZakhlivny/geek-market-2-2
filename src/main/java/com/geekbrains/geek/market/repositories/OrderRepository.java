package com.geekbrains.geek.market.repositories;

import com.geekbrains.geek.market.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("select o from Order o where o.user.username = ?1")
    List<Order> findAllOrdersByUsername(String username);
}
