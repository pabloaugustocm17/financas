package com.example.financa.controllers;

import com.example.financa.actions.Utils;
import com.example.financa.entities.dtos.WalletDTO;
import com.example.financa.entities.dtos.WalletSpendingDTO;
import com.example.financa.entities.user.User;
import com.example.financa.entities.wallet.Wallet;
import com.example.financa.entities.user.UserService;
import com.example.financa.entities.wallet.WalletService;
import com.example.financa.entities.walletspending.WalletSpendingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class WalletController {

    private final UserService USER_SERVICE;

    private final WalletService WALLET_SERVICE;

    private final WalletSpendingService WALLET_SPENDING_SERVICE;


    /* Constructor */

    public WalletController(UserService USER_SERVICE, WalletService WALLET_SERVICE,
                            WalletSpendingService WALLET_SPENDING_SERVICE) {
        this.USER_SERVICE = USER_SERVICE;
        this.WALLET_SERVICE = WALLET_SERVICE;
        this.WALLET_SPENDING_SERVICE = WALLET_SPENDING_SERVICE;
    }

    /* Requests */

    @PostMapping("/api/wallet/createWallet/{id_user}")
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

    @PostMapping("/api/wallet/createWalletWithName/{name_wallet}/{id_user}")
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

    @GetMapping("/api/wallet/getAllSpendingsWallet/{id_wallet}")
    public ResponseEntity<?> getAllSpendings(@PathVariable String id_wallet){

        HashMap<String, Object> json = new HashMap<>();

        Long id = Utils.stringToLong(id_wallet);

        if(id_wallet == null){
            json.put("error", "Id is null");
            return ResponseEntity.badRequest().body(json);
        }

        boolean isWalletExist = WALLET_SERVICE.isWalletExist(id);

        if(!isWalletExist){
            json.put("error", "Wallet no exist");
            return ResponseEntity.badRequest().body(json);
        }

        LinkedList<WalletSpendingDTO> spendings = WALLET_SPENDING_SERVICE.getWalletSpendingByWallet(id);

        if(spendings.isEmpty()){
            json.put("spendings", "empty");
        }else{
            json.put("spendings", spendings);
        }

        return ResponseEntity.ok().body(json);

    }

}
