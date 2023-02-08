package com.example.financa.controllers;

import com.example.financa.actions.Utils;
import com.example.financa.entities.dtos.LoginDTO;
import com.example.financa.entities.user.User;
import com.example.financa.entities.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class PageController {

    private final UserService USER_SERVICE;

    /* Constructor */

    public PageController(UserService userService) {
        this.USER_SERVICE = userService;
    }

    /* Requests */

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO logindto){

        String response_validate_email = logindto.validateEmail();

        if(!response_validate_email.equals(Utils.SUCESS_REQUEST)){
            return ResponseEntity.ok().body(response_validate_email);
        }

        boolean login = USER_SERVICE.loginUser(logindto.getEmail(), logindto.getPassword());

        if(!login){
            return ResponseEntity.ok().body("Email or password incorrect");
        }

        return ResponseEntity.ok().body(Utils.SUCESS_REQUEST);

    }

    @PostMapping("/registerNewUser")
    public ResponseEntity<?> registerNewUser(@RequestBody User newUser){

        String response_validate_user = UserService.validateUser(newUser);

        if(!response_validate_user.equals(Utils.SUCESS_REQUEST)){
            return ResponseEntity.ok().body(response_validate_user);
        }

        boolean isUserExist = USER_SERVICE.isUserExist(newUser.getEmail());

        if(isUserExist){
            return ResponseEntity.ok().body("User exist in system");
        }

        newUser.createToken();

        USER_SERVICE.saveUser(newUser);

        return ResponseEntity.ok().body(Utils.SUCESS_REQUEST);


    }
}
