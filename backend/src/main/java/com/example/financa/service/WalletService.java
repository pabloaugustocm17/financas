package com.example.financa.service;

import com.example.financa.entities.User;
import com.example.financa.entities.Wallet;
import com.example.financa.factory.Factorys;
import com.example.financa.repository.WalletRepository;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(User user){

        Wallet wallet = Factorys.WALLET_FACTORY.create(user);

        return walletRepository.save(wallet);


    }
    public Wallet createWallet(String name_wallet, User user){

        Wallet wallet = Factorys.WALLET_FACTORY.create(name_wallet, user);

        return walletRepository.save(wallet);


    }
}
