package com.example.financa.controller;

import com.example.financa.actions.Utils;
import com.example.financa.dtos.LoginDTO;
import com.example.financa.entities.User;
import com.example.financa.service.TokenService;
import com.example.financa.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class PageController {

    private final UserService user_service;

    public PageController(UserService userService, TokenService tokenService) {
        this.user_service = userService;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO logindto){

        String response_validate_email = logindto.validateEmail();

        if(!response_validate_email.equals(Utils.SUCESS_REQUEST)){
            return ResponseEntity.ok().body(response_validate_email);
        }

        boolean login = user_service.loginUser(logindto.getEmail(), logindto.getPassword());

        if(!login){
            return ResponseEntity.ok().body("Email or password incorrect");
        }

        return ResponseEntity.ok().body(Utils.SUCESS_REQUEST);

    }

    @RequestMapping("/registerNewUser")
    public ResponseEntity<?> registerNewUser(@RequestBody User newUser){

        String response_validate_user = UserService.validateUser(newUser);

        if(!response_validate_user.equals(Utils.SUCESS_REQUEST)){
            return ResponseEntity.ok().body(response_validate_user);
        }

        boolean isUserExist = user_service.isUserExist(newUser.getEmail());

        if(isUserExist){
            return ResponseEntity.ok().body("User exist in system");
        }

        newUser.createToken();

        user_service.saveUser(newUser);

        return ResponseEntity.ok().body(Utils.SUCESS_REQUEST);


    }
}
