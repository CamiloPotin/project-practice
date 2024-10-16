package com.project.spring_jwt.Service;


import com.project.spring_jwt.Model.User;
import com.project.spring_jwt.Repository.UserRepository;
import com.project.spring_jwt.dto.LoginUserDto;
import com.project.spring_jwt.dto.RegisterUserDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public User signup(RegisterUserDto input) {
        User user = new User();
        user.setName(input.getName());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setEmail(input.getEmail());
        user.setRoles(" ");
        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getName(),
                        input.getPassword()
                )
        );

        return userRepository.findByName(input.getName())
                .orElseThrow();
    }
    public List<User> allUsers() {

        return userRepository.findAll();
    }
}
