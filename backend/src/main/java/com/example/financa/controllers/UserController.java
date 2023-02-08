package com.example.financa.controllers;

import com.example.financa.actions.BDOperations;
import com.example.financa.actions.Utils;
import com.example.financa.entities.dtos.WalletDTO;
import com.example.financa.entities.user.User;
import com.example.financa.entities.tokenuser.TokenService;
import com.example.financa.entities.user.UserService;
import com.example.financa.entities.wallet.WalletService;
import com.example.financa.entities.walletspending.WalletSpendingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

    private final UserService USER_SERVICE;

    private final TokenService TOKEN_SERVICE;

    private final WalletService WALLET_SERVICE;

    private final WalletSpendingService WALLET_SPENDING_SERVICE;


    /* Constructor */

    public UserController(UserService USER_SERVICE, TokenService TOKEN_SERVICE, WalletService WALLET_SERVICE,
                          WalletSpendingService WALLET_SPENDING_SERVICE) {
        this.USER_SERVICE = USER_SERVICE;
        this.TOKEN_SERVICE = TOKEN_SERVICE;
        this.WALLET_SERVICE = WALLET_SERVICE;
        this.WALLET_SPENDING_SERVICE = WALLET_SPENDING_SERVICE;
    }

    /* Requests */

    @RequestMapping("/loadBD")
    private void loadDBByRequest(){
        BDOperations.loadBD(this.USER_SERVICE, this.TOKEN_SERVICE, this.WALLET_SERVICE, this.WALLET_SPENDING_SERVICE);
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

    @GetMapping("/api/getWalletsUser/{id_user}")
    private ResponseEntity<?> getWalletsUser(@PathVariable String id_user){

        HashMap<String, Object> json = new HashMap<>();

        if(id_user == null){
            json.put("error", "Id is null");
            return ResponseEntity.badRequest().body(json);
        }

        Long id = Utils.stringToLong(id_user);

        boolean isUserExist = USER_SERVICE.isUserExist(id);

        if(!isUserExist){
            json.put("error", "User no exist");
            return ResponseEntity.badRequest().body(json);
        }

        LinkedList<WalletDTO> wallets = WALLET_SERVICE.getAllWalletsByUser(id);

        if(wallets.isEmpty()){
            json.put("wallets", "empty");
        }else{
            json.put("wallets", wallets);
        }

        return ResponseEntity.ok().body(json);

    }
}
