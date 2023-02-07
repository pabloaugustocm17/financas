package com.example.financa.factory;

import org.springframework.stereotype.Component;

@Component
public class Factorys {

    public static UserFactory USER_FACTORY = new UserFactory();
    public static WalletFactory WALLET_FACTORY = new WalletFactory();
}
