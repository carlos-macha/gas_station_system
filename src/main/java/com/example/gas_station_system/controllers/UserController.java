package com.example.gas_station_system.controllers;

import com.example.gas_station_system.models.User;
import com.example.gas_station_system.services.UserService;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        String result = userService.loginService(user.getEmail(), user.getPassword());

        if (result == null || result.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }

        return ResponseEntity.ok(result);
    }

    @PostMapping("/create-user")
    public ResponseEntity<Map<String, String>> createUser(@RequestBody User userModel) {
        Map<String, String> response = userService.createUser(userModel);
        if (!"200".equals(response.get("status"))) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/index")
    public ResponseEntity<List<User>> index() {
        return ResponseEntity.ok(userService.indexService());
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        User user = userService.findByIdService(id);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }

    @GetMapping("/find-by-email/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable("email") String email) {
        User user = userService.findByEmailService(email);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }

    @GetMapping("/find-by-email/{name}")
    public ResponseEntity<User> findByName(@PathVariable("name") String name) {
        User user = userService.findByNameService(name);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);
    }
}
