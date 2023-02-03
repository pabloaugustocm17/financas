package com.example.financa.controller;

import com.example.financa.actions.BDOperations;
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

    private final UserService userService;

    private final TokenService tokenService;

    public PageController(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO logindto){

        String response_validate_email = logindto.validateEmail();

        if(!response_validate_email.equals(Utils.SUCESS_REQUEST)){
            return ResponseEntity.ok().body(response_validate_email);
        }

        boolean login = userService.loginUser(logindto.getEmail(), logindto.getPassword());

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

        boolean isUserExist = BDOperations.isUserExist(userService, newUser);

        if(isUserExist){
            return ResponseEntity.ok().body("User exist in system");
        }

        newUser.createToken();

        BDOperations.saveNewUser(userService, tokenService, newUser);

        return ResponseEntity.ok().body(Utils.SUCESS_REQUEST);


    }
}
