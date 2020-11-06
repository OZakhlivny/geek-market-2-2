package com.geekbrains.geek.market.repositories;

import com.geekbrains.geek.market.entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
}
