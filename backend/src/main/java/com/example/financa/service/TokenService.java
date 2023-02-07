package com.example.financa.service;

import com.example.financa.entities.TokenUser;
import com.example.financa.repository.TokenRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TokenService {

    private final TokenRepository TOKEN_REPOSITORY;

    /* Constructor */

    public TokenService(TokenRepository TOKEN_REPOSITORY) {
        this.TOKEN_REPOSITORY = TOKEN_REPOSITORY;
    }

    /* Methods */

    public static String generateToken(LocalDate birth_date){

        int day = birth_date.getDayOfMonth();
        int month = birth_date.getMonthValue();
        int year = birth_date.getYear();

        String token_day = String.valueOf(day * 64);
        String token_month = String.valueOf(month * 128);
        String year_token = String.valueOf(year * 256);

        String token_day_now = String.valueOf(LocalDate.now().getDayOfMonth() * 64);

        return token_day + token_month + year_token + token_day_now;

    }

    public void saveToken(TokenUser tokenUser){
        TOKEN_REPOSITORY.save(tokenUser);
    }

}
