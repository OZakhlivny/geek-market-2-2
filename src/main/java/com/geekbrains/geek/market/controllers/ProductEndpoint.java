package com.geekbrains.geek.market.controllers;

import com.geekbrains.geek.market.services.ProductService;
import com.geekbrains.geek.market.soap.products.GetProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class ProductEndpoint {
    private static final String NAMESPACE_URL = "http://localhost/market/products";
    private final ProductService productService;

    @Autowired
    public ProductEndpoint(ProductService productService) {
        this.productService = productService;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getProductRequest")
    @ResponsePayload
    public GetProductResponse getProducts() {
        GetProductResponse response = new GetProductResponse();
        response.getProduct().addAll(productService.findAllSOAP());
        return response;
    }
}