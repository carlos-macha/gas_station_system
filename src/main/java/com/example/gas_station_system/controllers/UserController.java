package com.example.gas_station_system.controllers;

import com.example.gas_station_system.models.User;
import com.example.gas_station_system.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-user")
    public ResponseEntity<Map<String, String>> createUser(@RequestBody User userModel) {
        Map<String, String> response = userService.createUser(userModel);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/index")
    public ResponseEntity<List<User>> index() {
        return ResponseEntity.ok(userService.indexService());
    }

    @PostMapping("/find-by-Id/{id}")
    public  ResponseEntity<User> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.findByIdService(id));
    }

    @PostMapping("/login")
    public ResponseEntity<String> findByEmail(@RequestBody User user) {
        return ResponseEntity.ok(userService.findByEmailService(user.getEmail(), user.getPassword()));
    }
}
