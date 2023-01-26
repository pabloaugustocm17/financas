package com.example.financa.entities;

import com.example.financa.actions.Utils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table(name = "tb_user")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String name;

    private double value_account;

    private LocalDate birth_date;

    @OneToOne
    private TokenUser tokenUser;


    /* Init */

    public void init(String email, String password, String name, double value_account ,LocalDate birth_date){
        this.email = email;
        this.password = password;
        this.name = name;
        this.value_account = value_account;
        this.birth_date = birth_date;
        createToken();
    }

    /* Constructors */

    public User(String email, String password, String name, String birth_date){
        init(email, password, name, 0, Utils.stringToLocalDate(birth_date));
    }

    public User(String email, String password, String name, LocalDate birth_date){
        init(email, password, name,0, birth_date);
    }

    public User(Long id, String email, String password, String name, double value_account, LocalDate birth_date){
        this.id = id;
        init(email, password, name, value_account, birth_date);
    }

    /* Validates */

    public void createToken(){
        this.tokenUser = new TokenUser(this.birth_date);
    }
    public String validateUser(){

        if(this.name == null || this.name.isBlank() || this.name.isEmpty()){
            return "Name blank";
        }

        String response_validate_email = Utils.validateEmail(this.email);

        if(!response_validate_email.equals(Utils.SUCESS_REQUEST)){
            return response_validate_email;
        }

        String response_validate_password = Utils.validatePassword(this.password);

        if(!response_validate_password.equals(Utils.SUCESS_REQUEST)){
            return response_validate_password;
        }

        if(this.birth_date == null){
            return "Birth date is null";
        }else{
            if(LocalDate.now().getYear() - this.birth_date.getYear() < 18 ){
                return "You need 18 years to register";
            }
        }

        return Utils.SUCESS_REQUEST;

    }
}
