package com.example.financa.entities.wallet;

import com.example.financa.entities.user.User;
import com.example.financa.factory.Factory;

public class WalletFactory implements Factory {
    @Override
    public Object create() {
        return new Wallet();
    }

    @Override
    public Object createByLine(String line) {

        String[] args = line.split(";");

        String name_wallet = args[1];

        return new Wallet(name_wallet);
    }

    public Wallet create(User user){
        return new Wallet(user);
    }

    public Wallet create(String name_wallet, User user){
        return new Wallet(name_wallet, user);
    }
}
