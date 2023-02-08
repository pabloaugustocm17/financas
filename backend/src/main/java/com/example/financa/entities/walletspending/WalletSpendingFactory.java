package com.example.financa.entities.walletspending;

import com.example.financa.factory.Factory;

public class WalletSpendingFactory implements Factory {

    @Override
    public Object create() {
        return new WalletSpending();
    }

    @Override
    public Object createByLine(String line) {

        String[] args = line.split(";");

        String spending = args[1];
        String date = args[2];

        return new WalletSpending(spending, date);
    }
}
