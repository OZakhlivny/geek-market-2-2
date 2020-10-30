package com.geekbrains.geek.market.dto;

import com.geekbrains.geek.market.entities.Order;

import java.util.List;
import java.util.stream.Collectors;

public class OrderDto {
    private Long id;
    private List<OrderItemDto> items;
    private Integer price;
    private String address;

    public OrderDto(Order order) {
        this.id = order.getId();
        this.price = order.getPrice();
        this.address = order.getAddress();
        this.items = order.getItems().stream().map(OrderItemDto::new).collect(Collectors.toList());
    }
}
