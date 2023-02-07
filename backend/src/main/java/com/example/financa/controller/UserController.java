package com.example.financa.controller;

import com.example.financa.actions.BDOperations;
import com.example.financa.entities.User;
import com.example.financa.service.TokenService;
import com.example.financa.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    private final UserService user_service;
    private final TokenService token_service;

    public UserController(UserService userService,TokenService tokenService){
        this.user_service = userService;
        this.token_service = tokenService;
    }

    @RequestMapping("/loadBD")
    private void loadDBByRequest(){
        BDOperations.loadBD(this.user_service, this.token_service);
    }

    @RequestMapping("/api/listAllUser")
    private ResponseEntity<?> listAllUsers(){

        HashMap<String, User> hash_users = new HashMap<>();

        List<User> users = user_service.listAllUser();

        if(users.isEmpty()){
            return ResponseEntity.badRequest().body("No users in system");
        }

        users.forEach(user -> {

            hash_users.put(user.getName(), user);

        });

        return ResponseEntity.ok(hash_users);

    }

}
