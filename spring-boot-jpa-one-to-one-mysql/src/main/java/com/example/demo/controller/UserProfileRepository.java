package com.example.demo.controller;

import com.example.demo.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile , Long> {
    UserProfile findByFirstName(String nguyen);

    UserProfile findByZipCode(String nguyen);
}
