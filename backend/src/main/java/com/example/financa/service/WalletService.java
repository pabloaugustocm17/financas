package com.example.financa.service;

import com.example.financa.entities.User;
import com.example.financa.entities.Wallet;
import com.example.financa.factory.Factorys;
import com.example.financa.repository.WalletRepository;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private final WalletRepository wallet_repository;

    public WalletService(WalletRepository wallet_repository) {
        this.wallet_repository = wallet_repository;
    }

    public Wallet createWallet(User user){

        Wallet wallet = Factorys.WALLET_FACTORY.create(user);

        return wallet_repository.save(wallet);


    }
    public Wallet createWallet(String name_wallet, User user){

        Wallet wallet = Factorys.WALLET_FACTORY.create(name_wallet, user);

        return wallet_repository.save(wallet);


    }
}
