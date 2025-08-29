## 🖥️ Backend Overview

I used the concept of Microservices, so I created 4 Spring Boot apps that handle:

- User
- Order
- Product
- Cart

For the User backend, I implemented JWT authentication.
Note:
each user created from the frontend app has USER role by default . For ADMIN i created one admin 
for the system by using 
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

### ⚙️ Tech Stack
- Backend: Spring Boot (Java 17+)
- Database: H2
- API: REST
- Testing : Postman

### 🎬 Demo
- [Watch Backend Demo on Vimeo](https://vimeo.com/1114177029)
