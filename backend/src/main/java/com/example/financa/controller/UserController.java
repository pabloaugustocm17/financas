package com.example.financa.controller;

import com.example.financa.actions.BDOperations;
import com.example.financa.entities.User;
import com.example.financa.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
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
        BDOperations.saveUser(this.userRepository, user);
    }

}
