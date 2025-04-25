package com.example.gas_station_system.services;

import com.example.gas_station_system.models.User;
import com.example.gas_station_system.repositories.UserRepository;
import com.example.gas_station_system.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    public Map<String, String> createUser(User user) {
        Map<String, String> response = new HashMap<>();

        try {
            String hashedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashedPassword);
            userRepository.save(user);

            response.put("message", "User created successfully");
            return response;
        } catch (Exception error) {
            response.put("error", error.getMessage());
            return response;
        }

    }

    public List<User> indexService() {
        return userRepository.getAllUsers();
    }

    public User findByIdService(Long id) {
        return  userRepository.FindUserById(id);
    }

    public String findByEmailService(String email, String password) {
        User user = userRepository.FindUserByEmail(email);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {

            return jwtUtil.generateToken(email);
        } else {
            return null;
        }
    }
}
