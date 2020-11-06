package com.geekbrains.geek.market.controllers;

import com.geekbrains.geek.market.dto.UserDto;
import com.geekbrains.geek.market.entities.User;
import com.geekbrains.geek.market.entities.UserProfile;
import com.geekbrains.geek.market.exceptions.ResourceNotFoundException;
import com.geekbrains.geek.market.services.UserProfileService;
import com.geekbrains.geek.market.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/cabinet")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserProfileService userProfileService;

    @GetMapping
    public UserDto getUserData(Principal principal) {
        return new UserDto(userService.findByUsername(principal.getName()).orElseThrow(() -> new ResourceNotFoundException("Unable to load data for user: " + principal.getName() + ". User doesn't exist")));
    }

    @PostMapping
    public void updateUserData(Principal principal, @RequestBody UserDto userData){
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new ResourceNotFoundException("Unable to load data for user: " + principal.getName() + ". User doesn't exist"));
        user.setName(userData.getName());
        user.setSurname(userData.getSurname());
        user.setEmail(userData.getEmail());
        user.setPhone(userData.getPhone());
        userService.saveOrUpdate(user);
        UserProfile userProfile = user.getProfile();
        userProfile.setGender(userData.getProfile().getGender());
        userProfile.setBirthyear(userData.getProfile().getBirthyear());
        userProfile.setHometown(userData.getProfile().getHometown());
        userProfileService.saveOrUpdate(userProfile);
    }
}
