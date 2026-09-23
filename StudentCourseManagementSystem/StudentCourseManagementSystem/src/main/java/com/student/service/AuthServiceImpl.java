package com.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.student.dto.*;
import com.student.entity.User;
import com.student.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public String register(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()) != null)
            throw new RuntimeException("Email already registered");

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        userRepository.save(user);
        return "Registration successful";
    }

    @Override
    public String login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail());
        if (user == null || !user.getPassword().equals(request.getPassword()))
            throw new RuntimeException("Invalid email or password");
        return "Login successful";
    }
}
