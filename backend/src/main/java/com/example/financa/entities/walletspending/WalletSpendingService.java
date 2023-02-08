package com.example.financa.entities.walletspending;

import com.example.financa.entities.dtos.UserSpendingsDTO;
import com.example.financa.entities.dtos.WalletDTO;
import com.example.financa.entities.dtos.WalletSpendingDTO;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class WalletSpendingService {

    private final WalletSpendingRepository WALLET_REPOSITORY;

    /* Constructor */

    public WalletSpendingService(WalletSpendingRepository WALLET_REPOSITORY) {
        this.WALLET_REPOSITORY = WALLET_REPOSITORY;
    }

    /* Methods */

    public void saveWalletSpending(WalletSpending walletSpending){
        WALLET_REPOSITORY.save(walletSpending);
    }

    public LinkedList<WalletSpendingDTO> getWalletSpendingByWallet(Long id_wallet){
        return WALLET_REPOSITORY.getWalletSpendingByWallet(id_wallet);
    }

    public LinkedList<UserSpendingsDTO> getWalletsSpendingByUser(Long id_user){
        return WALLET_REPOSITORY.getWalletsSpendingByUser(id_user);
    }
}
