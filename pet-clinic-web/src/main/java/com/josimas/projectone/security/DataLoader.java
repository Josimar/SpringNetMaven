package com.josimas.projectone.security;

import com.josimas.projectone.model.Role;
import com.josimas.projectone.model.User;
import com.josimas.projectone.repository.RoleRepository;
import com.josimas.projectone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));

        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userRole = roleRepository.findByRole("USER");

        User user = new User("josimar@gmail.com", passwordEncoder.encode("mar1976"), "Josimar", "Silva", true, "josimarb");
        user.setRoles(List.of(adminRole));
        userRepository.save(user);

        user = new User("josimas@gmail.com", passwordEncoder.encode("mar1976"), "Josimar", "Silva", true, "josimas");
        user.setRoles(List.of(userRole));
        userRepository.save(user);
    }
}
