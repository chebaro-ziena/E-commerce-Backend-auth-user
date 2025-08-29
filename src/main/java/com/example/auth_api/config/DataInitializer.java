package com.example.auth_api.config;

import com.example.auth_api.entities.Role;
import com.example.auth_api.entities.User;
import com.example.auth_api.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.count() == 0) {
                User admin = new User()
                        .setFullName("Admin User")
                        .setEmail("admin@system.com")
                        .setPassword(passwordEncoder.encode("admin123"))
                        .setRole(Role.ADMIN);

                userRepository.save(admin);
                System.out.println("✅ Admin user created: admin@system.com / admin123");
            }
        };
    }
}