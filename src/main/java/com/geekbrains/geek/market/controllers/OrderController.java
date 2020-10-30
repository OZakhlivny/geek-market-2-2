package com.geekbrains.geek.market.controllers;

import com.geekbrains.geek.market.dto.OrderDto;
import com.geekbrains.geek.market.dto.OrderItemDto;
import com.geekbrains.geek.market.entities.Order;
import com.geekbrains.geek.market.entities.Product;
import com.geekbrains.geek.market.entities.User;
import com.geekbrains.geek.market.services.OrderService;
import com.geekbrains.geek.market.services.ProductService;
import com.geekbrains.geek.market.services.UserService;
import com.geekbrains.geek.market.utils.Cart;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrderController {
    private UserService userService;
    private OrderService orderService;
    private Cart cart;

    @GetMapping
    public List<OrderDto> showOrders() {
        List<OrderDto> orderDtoList = new ArrayList<>(orderService.findAll().stream().map(OrderDto::new).collect(Collectors.toList()));
        return orderDtoList;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Order createNewOrder(@RequestBody Order o) {
        o.setId(null);
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        o.setUser(userService.findByUsername(name));
        o.setItemsFromCart(cart);
        o.setPrice(cart.getPrice());
        cart.clear();
        return orderService.save(o);
    }
}
