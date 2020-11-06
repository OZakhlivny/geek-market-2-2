package com.geekbrains.geek.market.dto;

import com.geekbrains.geek.market.entities.UserProfile;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserProfileDto {
    private long user_id;
    private char gender;
    private int birthyear;
    private String hometown;

    public UserProfileDto(UserProfile profile){
        this.user_id = profile.getUser().getId();
        this.gender = profile.getGender();
        this.birthyear = profile.getBirthyear();
        this.hometown = profile.getHometown();
    }
}
