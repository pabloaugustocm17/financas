package com.example.financa.controller;

import com.example.financa.actions.BDOperations;
import com.example.financa.actions.Utils;
import com.example.financa.dtos.LoginDTO;
import com.example.financa.entities.User;
import com.example.financa.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class PageController {

    private final UserRepository userRepository;

    public PageController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO logindto){

        String response_validate_email = logindto.validateEmail();

        if(!response_validate_email.equals(Utils.SUCESS_REQUEST)){
            return ResponseEntity.ok().body(response_validate_email);
        }

        Long idUser = userRepository.loginUser(logindto.getEmail(), logindto.getPassword());

        System.out.println(idUser);

        if(idUser == null){
            return ResponseEntity.ok().body("Email or password incorrect");
        }

        return ResponseEntity.ok().body(Utils.SUCESS_REQUEST);

    }

    @RequestMapping("/registerNewUser")
    public ResponseEntity<?> registerNewUser(@RequestBody User newUser){

        String response_validate_user = newUser.validateUser();

        if(!response_validate_user.equals(Utils.SUCESS_REQUEST)){
            return ResponseEntity.badRequest().body(response_validate_user);
        }

        boolean isUserExist = BDOperations.isUserExist(userRepository, newUser);

        if(isUserExist){
            return ResponseEntity.badRequest().body("User exist in system");
        }

        BDOperations.saveNewUser(userRepository, newUser);

        return ResponseEntity.ok().body(Utils.SUCESS_REQUEST);


    }
}
