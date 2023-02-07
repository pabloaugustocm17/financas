package com.example.financa.factory;

import com.example.financa.entities.User;
import com.example.financa.entities.Wallet;

public class WalletFactory implements Factory{
    @Override
    public Object create() {
        return new Wallet();
    }

    @Override
    public Object createByLine(String line) {

        String[] args = line.split(";");

        Long id = Long.valueOf(args[1]);
        String name_wallet = args[2];

        return new Wallet(id, name_wallet);
    }

    public Wallet create(User user){
        return new Wallet(user);
    }

    public Wallet create(String name_wallet, User user){
        return new Wallet(name_wallet, user);
    }
}
