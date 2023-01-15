package com.example.financa.controller;

import com.example.financa.actions.BDOperations;
import com.example.financa.repository.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @RequestMapping("/loadBD")
    private void loadBdByRequisition(){

        BDOperations.loadBD(this.userRepository);

    }



}
