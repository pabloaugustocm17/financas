package com.example.financa.entities;

import com.example.financa.service.TokenService;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Entity
@Component
@NoArgsConstructor
@Getter
@Table(name = "tb_token")
public class TokenUser {

    @Id
    private String token;
    private LocalDate last_acess;

    public TokenUser(LocalDate birth_date){
        this.token = TokenService.generateToken(birth_date);
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
