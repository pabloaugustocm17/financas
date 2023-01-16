package com.example.financa.controller;

import com.example.financa.actions.BDOperations;
import com.example.financa.entities.User;
import com.example.financa.repository.UserRepository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @RequestMapping("/loadBD")
    private void loadBdByRequest(){
        BDOperations.loadBD(this.userRepository);
    }

    @PutMapping("/saveBD")
    private void saveBdByRequest(@RequestBody User user){
        BDOperations.saveBD(this.userRepository, user);
    }

}
