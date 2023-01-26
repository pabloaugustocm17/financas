package com.example.financa.controller;

import com.example.financa.actions.BDOperations;
import com.example.financa.entities.User;
import com.example.financa.repository.TokenRepository;
import com.example.financa.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;

    public UserController(UserRepository userRepository, TokenRepository tokenRepository){
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }

    @RequestMapping("/loadBD")
    private void loadBdByRequest(){
        BDOperations.loadBD(this.userRepository, this.tokenRepository);
    }

    @PutMapping("/saveBD")
    private void saveBdByRequest(@RequestBody User user){
        BDOperations.saveUser(this.userRepository, user);
    }

}
