package com.example.financa.controller;

import com.example.financa.actions.BDOperations;
import com.example.financa.entities.User;
import com.example.financa.service.TokenService;
import com.example.financa.service.UserService;
import com.example.financa.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    private final UserService USER_SERVICE;

    private final TokenService TOKEN_SERVICE;

    private final WalletService WALLET_SERVICE;


    /* Constructor */

    public UserController(UserService USER_SERVICE, TokenService TOKEN_SERVICE, WalletService WALLET_SERVICE) {
        this.USER_SERVICE = USER_SERVICE;
        this.TOKEN_SERVICE = TOKEN_SERVICE;
        this.WALLET_SERVICE = WALLET_SERVICE;
    }

    /* Requests */

    @RequestMapping("/loadBD")
    private void loadDBByRequest(){
        BDOperations.loadBD(this.USER_SERVICE, this.TOKEN_SERVICE, this.WALLET_SERVICE);
    }

    @RequestMapping("/api/listAllUser")
    private ResponseEntity<?> listAllUsers(){

        HashMap<String, User> hash_users = new HashMap<>();

        List<User> users = USER_SERVICE.listAllUser();

        if(users.isEmpty()){
            return ResponseEntity.badRequest().body("No users in system");
        }

        users.forEach(user ->
            hash_users.put(user.getName(), user)
        );

        return ResponseEntity.ok(hash_users);

    }

}
