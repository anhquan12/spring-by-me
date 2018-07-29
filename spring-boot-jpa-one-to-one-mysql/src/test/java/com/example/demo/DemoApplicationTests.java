package com.example.demo;

import com.example.demo.controller.UserProfileRepository;
import com.example.demo.controller.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.entity.UserProfile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testData() throws Exception {
        this.testEntityManager.persist(new User("Tran", "Van B", "def@gmail.com",
                "1234"));
        User user = this.userRepository.findByEmail("def@gmail.com");
        assertThat(user.getEmail()).isEqualTo("def@gmail.com");
        UserProfile userProfile = this.userProfileRepository.findByZipCode("1357");
        assertThat(userProfile.getZipCode()).isEqualTo("1357");

    }

}
