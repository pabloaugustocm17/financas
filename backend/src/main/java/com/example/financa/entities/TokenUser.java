package com.example.financa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Entity
@Component
@Table(name = "tb_token")
public class TokenUser {

    @Id
    private String token;
    private LocalDate last_acess;

    public TokenUser(){

    }
    public TokenUser(LocalDate birth_date){
        generateToken(birth_date);
        System.out.println("TOKEN -> " + this.token);
    }

    public void generateToken(LocalDate birth_date){

        int day = birth_date.getDayOfMonth();
        int month = birth_date.getMonthValue();
        int year = birth_date.getYear();

        String token_day = String.valueOf(day * 64);
        String token_month = String.valueOf(month * 128);
        String year_token = String.valueOf(year * 256);

        String token_day_now = String.valueOf(LocalDate.now().getDayOfMonth() * 64);

        this.token = token_day + token_month + year_token + token_day_now;

    }
    public void updateLastAcess(LocalDate new_acess){
        if(new_acess.getDayOfYear() != LocalDate.now().getDayOfYear()){
            this.last_acess = new_acess;
        }
    }
    public boolean validadeToken(String token_acess){

        if(this.token.equals(token_acess)){
            updateLastAcess(LocalDate.now());
            return true;
        }else{
            return false;
        }

    }
}
