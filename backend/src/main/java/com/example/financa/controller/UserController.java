package com.example.financa.controller;

import com.example.financa.actions.BDOperations;
import com.example.financa.entities.User;
import com.example.financa.repository.TokenRepository;
import com.example.financa.repository.UserRepository;
import com.example.financa.service.TokenService;
import com.example.financa.service.UserService;
import org.springframework.web.bind.annotation.*;

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
    private void loadBdByRequest(){
        BDOperations.loadBD(this.user_service, this.token_service);
    }

}
