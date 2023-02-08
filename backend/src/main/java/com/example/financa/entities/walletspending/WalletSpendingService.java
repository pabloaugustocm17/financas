package com.example.financa.entities.walletspending;

import org.springframework.stereotype.Service;

@Service
public class WalletSpendingService {

    private final WalletSpendingRepository WALLET_REPOSITORY;

    public WalletSpendingService(WalletSpendingRepository WALLET_REPOSITORY) {
        this.WALLET_REPOSITORY = WALLET_REPOSITORY;
    }

    public void saveWalletSpending(WalletSpending walletSpending){
        WALLET_REPOSITORY.save(walletSpending);
    }

}
