package com.geekbrains.geek.market.services;

import com.geekbrains.geek.market.entities.UserProfile;
import com.geekbrains.geek.market.repositories.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    UserProfileRepository userProfileRepository;

    public UserProfile saveOrUpdate(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }
}
