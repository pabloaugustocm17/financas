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

    private final UserService userService;
    private final WalletService walletService;

    public WalletController(UserService userService,
                            WalletService walletService){
        this.userService = userService;
        this.walletService = walletService;
    }

    @PostMapping("/api/createWallet/{id_user}")
    public ResponseEntity<?> createWallet(@PathVariable Long id_user){

        HashMap<String, Object> json_return = new HashMap<>();

        User response = userService.returnUserById(id_user);

        if(response == null){
            json_return.put("error", "user no exist");
            return ResponseEntity.badRequest().body(json_return);
        }

        Wallet wallet = walletService.createWallet(response);

        json_return.put("wallet", wallet.toString());

        return ResponseEntity.ok().body(json_return);

    }

    @PostMapping("/api/createWalletWithName/{name_wallet}/{id_user}")
    public ResponseEntity<?> createWalletWithName(@PathVariable String name_wallet, @PathVariable Long id_user){

        HashMap<String, Object> json_return = new HashMap<>();

        User response = userService.returnUserById(id_user);

        if(response == null){
            json_return.put("error", "user no exist");
            return ResponseEntity.badRequest().body(json_return);
        }

        Wallet wallet = walletService.createWallet(name_wallet, response);

        json_return.put("wallet", wallet.toString());

        return ResponseEntity.ok().body(json_return);

    }

}
