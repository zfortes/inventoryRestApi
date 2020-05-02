package com.vtex.inventory.web.rest;

import com.vtex.inventory.service.UserService;
import com.vtex.inventory.service.dtos.UserClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserResource {
    @Autowired
    private UserService userService;

    @PostMapping
    ResponseEntity<UserClientDTO> insertUser(@RequestBody UserClientDTO user){
        return userService.insertUser(user);
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getUserWithId(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping
    ResponseEntity<List<UserClientDTO>> getAllUsers(){
        return userService.getAllUsers();
    }
}
