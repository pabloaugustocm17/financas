package com.example.financa.controllers;

import com.example.financa.entities.user.User;
import com.example.financa.entities.wallet.Wallet;
import com.example.financa.entities.user.UserService;
import com.example.financa.entities.wallet.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class WalletController {

    private final UserService USER_SERVICE;

    private final WalletService WALLET_SERVICE;


    /* Constructor */

    public WalletController(UserService USER_SERVICE,
                            WalletService WALLET_SERVICE){
        this.USER_SERVICE = USER_SERVICE;
        this.WALLET_SERVICE = WALLET_SERVICE;
    }

    /* Requests */

    @PostMapping("/api/createWallet/{id_user}")
    public ResponseEntity<?> createWallet(@PathVariable Long id_user){

        HashMap<String, Object> json_return = new HashMap<>();

        User response = USER_SERVICE.returnUserById(id_user);

        if(response == null){
            json_return.put("error", "user no exist");
            return ResponseEntity.badRequest().body(json_return);
        }

        Wallet wallet = WALLET_SERVICE.createWallet(response);

        json_return.put("wallet", wallet.toString());

        return ResponseEntity.ok().body(json_return);

    }

    @PostMapping("/api/createWalletWithName/{name_wallet}/{id_user}")
    public ResponseEntity<?> createWalletWithName(@PathVariable String name_wallet, @PathVariable Long id_user){

        HashMap<String, Object> json_return = new HashMap<>();

        User response = USER_SERVICE.returnUserById(id_user);

        if(response == null){
            json_return.put("error", "user no exist");
            return ResponseEntity.badRequest().body(json_return);
        }

        Wallet wallet = WALLET_SERVICE.createWallet(name_wallet, response);

        json_return.put("wallet", wallet.toString());

        return ResponseEntity.ok().body(json_return);

    }

}
