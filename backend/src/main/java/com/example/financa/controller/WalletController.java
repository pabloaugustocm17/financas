package com.example.financa.controller;

import com.example.financa.entities.User;
import com.example.financa.entities.Wallet;
import com.example.financa.service.UserService;
import com.example.financa.service.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class WalletController {

    private final UserService user_service;
    private final WalletService wallet_service;

    public WalletController(UserService user_service,
                            WalletService wallet_service){
        this.user_service = user_service;
        this.wallet_service = wallet_service;
    }

    @PostMapping("/api/createWallet/{id_user}")
    public ResponseEntity<?> createWallet(@PathVariable Long id_user){

        HashMap<String, Object> json_return = new HashMap<>();

        User response = user_service.returnUserById(id_user);

        if(response == null){
            json_return.put("error", "user no exist");
            return ResponseEntity.badRequest().body(json_return);
        }

        Wallet wallet = wallet_service.createWallet(response);

        json_return.put("wallet", wallet.toString());

        return ResponseEntity.ok().body(json_return);

    }

    @PostMapping("/api/createWalletWithName/{name_wallet}/{id_user}")
    public ResponseEntity<?> createWalletWithName(@PathVariable String name_wallet, @PathVariable Long id_user){

        HashMap<String, Object> json_return = new HashMap<>();

        User response = user_service.returnUserById(id_user);

        if(response == null){
            json_return.put("error", "user no exist");
            return ResponseEntity.badRequest().body(json_return);
        }

        Wallet wallet = wallet_service.createWallet(name_wallet, response);

        json_return.put("wallet", wallet.toString());

        return ResponseEntity.ok().body(json_return);

    }

}
