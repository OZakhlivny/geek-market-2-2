package com.geekbrains.geek.market.dto;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}
