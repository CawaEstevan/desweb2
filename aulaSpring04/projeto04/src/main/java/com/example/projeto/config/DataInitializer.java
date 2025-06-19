// src/main/java/com/example/projeto/config/DataInitializer.java
package com.example.projeto.config;

import com.example.projeto.model.Role;
import com.example.projeto.model.User;
import com.example.projeto.repository.RoleRepository;
import com.example.projeto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        
        // Criar roles se não existirem
        if (roleRepository.count() == 0) {
            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
            roleRepository.save(adminRole);
            
            Role userRole = new Role();
            userRole.setName("ROLE_USER");
            roleRepository.save(userRole);
        }
        
        // Criar usuários se não existirem
        if (userRepository.count() == 0) {
            Role adminRole = roleRepository.findByName("ROLE_ADMIN").orElseThrow();
            Role userRole = roleRepository.findByName("ROLE_USER").orElseThrow();
            
            // Criar usuário admin
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("123456"));
            admin.setRoles(Set.of(adminRole));
            userRepository.save(admin);
            
            // Criar usuário comum
            User user = new User();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("123456"));
            user.setRoles(Set.of(userRole));
            userRepository.save(user);
            
            System.out.println("Usuários criados:");
            System.out.println("Admin - Username: admin, Password: 123456");
            System.out.println("User - Username: user, Password: 123456");
        }
    }
}