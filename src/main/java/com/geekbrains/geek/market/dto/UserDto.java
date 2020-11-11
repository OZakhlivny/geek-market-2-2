package com.geekbrains.geek.market.dto;

import com.geekbrains.geek.market.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private String username;
    private String password;
    private String email;
    private String name;
    private String surname;
    private String phone;
    private UserProfileDto profile;

    public UserDto(User user){
        this.username = user.getUsername();
        //this.password = user.getPassword();
        this.email = user.getEmail();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.phone = user.getPhone();
        this.profile = new UserProfileDto(user.getProfile());
    }
}
