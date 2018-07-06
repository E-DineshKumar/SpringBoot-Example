package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")

public class UserController {

    @Autowired
    UserRepository userRepository;

    // Get All Notes
    @GetMapping("/user")
    public List<Users> getAllNotes() {
        return userRepository.findAll();
    }

    // Create a new Note
    @PostMapping("/user")
    public Users createNote(@Valid @RequestBody Users user) {
        return userRepository.save(user);
    }

    // Get a Single Note
    @GetMapping("/user/{id}")
    public Users getNoteById(@PathVariable(value = "id") Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", userId));
    }

    // Update a Note

    // Delete a Note
}
