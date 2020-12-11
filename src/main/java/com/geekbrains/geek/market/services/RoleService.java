package com.geekbrains.geek.market.services;


import com.geekbrains.geek.market.entities.Role;
import com.geekbrains.geek.market.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findRoleByName("ROLE_USER");
    }
}