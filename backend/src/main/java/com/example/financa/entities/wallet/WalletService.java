package com.example.financa.entities.wallet;

import com.example.financa.entities.dtos.WalletDTO;
import com.example.financa.entities.user.User;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class WalletService {

    private final WalletFactory WALLET_FACTORY = new WalletFactory();
    private final WalletRepository wallet_repository;

    /* Constructor */

    public WalletService(WalletRepository wallet_repository) {
        this.wallet_repository = wallet_repository;
    }

    /* Methods */

    public Wallet getWalletById(Long id){
        return wallet_repository.getWalletById(id);
    }

    public Wallet createWallet(User user){

        Wallet wallet = WALLET_FACTORY.create(user);

        return wallet_repository.save(wallet);


    }

    public Wallet createWallet(String name_wallet, User user){

        Wallet wallet = WALLET_FACTORY.create(name_wallet, user);

        return wallet_repository.save(wallet);


    }

    public void saveWallet(Wallet wallet){
        wallet_repository.save(wallet);
    }

    public LinkedList<WalletDTO> getAllWalletsByUser(Long id_user){

        return wallet_repository.getAllWalletByUser(id_user);

    }

    public boolean isWalletExist(Long id){
        return (wallet_repository.isWalletExist(id) != null);
    }
}
