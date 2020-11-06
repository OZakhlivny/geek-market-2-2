package com.geekbrains.geek.market.services;

import com.geekbrains.geek.market.dto.OrderDto;
import com.geekbrains.geek.market.entities.Order;
import com.geekbrains.geek.market.entities.Product;
import com.geekbrains.geek.market.repositories.OrderRepository;
import com.geekbrains.geek.market.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<OrderDto> findAllUserOrderDtosByUsername(String username) {
        return orderRepository.findAllOrdersByUsername(username).stream().map(OrderDto::new).collect(Collectors.toList());
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
