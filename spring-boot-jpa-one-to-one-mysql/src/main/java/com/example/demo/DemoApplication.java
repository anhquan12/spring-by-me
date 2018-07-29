package com.example.demo;

import com.example.demo.controller.UserProfileRepository;
import com.example.demo.controller.UserRepository;
import com.example.demo.entity.Gender;
import com.example.demo.entity.User;
import com.example.demo.entity.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Clean up database tables
        userProfileRepository.deleteAllInBatch();
        userRepository.deleteAllInBatch();

        //=========================================
//        User user = new User();
//        UserProfile userProfile = new UserProfile();
//         Create a User instance
        User user = new User("Nguyen", "Van A", "abc@gmail.com",
                "1234");

        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(1992, 7, 21);

//         Create a UserProfile instance
        UserProfile userProfile = new UserProfile("+91-98755", Gender.MALE, dateOfBirth.getTime(),
                "2412", "2nd ", " HD", "HN",
                "Katana", "VN", "123131");


        user.setUserProfile(userProfile);

        userProfile.setUser(user);

        userRepository.save(user);

    }
}