package com.example.financa.dtos;

import com.example.financa.actions.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class LoginDTO {

    private String email;
    private String password;

    public String validateEmail(){

        return Utils.validateEmail(email);

    }

}
