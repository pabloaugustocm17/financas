package com.example.financa.service;

import com.example.financa.actions.Utils;
import com.example.financa.entities.User;
import com.example.financa.repository.TokenRepository;
import com.example.financa.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {

    private final UserRepository user_repository;

    private final TokenRepository token_repository;

    public UserService(UserRepository user_repository, TokenRepository token_repository) {
        this.user_repository = user_repository;
        this.token_repository = token_repository;
    }

    public static String validateUser(User user){

        String user_name = user.getName();
        String user_email = user.getEmail();
        String user_password = user.getPassword();
        LocalDate user_birth = user.getBirth_date();

        if(user_name == null || user_name.isBlank() || user_name.isEmpty()){
            return "Name blank";
        }

        String response_validate_email = Utils.validateEmail(user_email);

        if(!response_validate_email.equals(Utils.SUCESS_REQUEST)){
            return response_validate_email;
        }

        String response_validate_password = Utils.validatePassword(user_password);

        if(!response_validate_password.equals(Utils.SUCESS_REQUEST)){
            return response_validate_password;
        }

        if(user_birth == null){
            return "Birth date is null";
        }else{
            if(LocalDate.now().getYear() - user_birth.getYear() < 18 ){
                return "You need 18 years to register";
            }
        }

        return Utils.SUCESS_REQUEST;

    }

    public void saveUser(User user){
        token_repository.save(user.getTokne_user());
        user_repository.save(user);
    }

    public boolean isUserExist(String email){

        String response = user_repository.isUserExist(email);

        return (response != null);

    }

    public boolean loginUser(String email, String password){

        Long id = user_repository.loginUser(email, password);

        return id != null;

    }

    public User returnUserById(Long id_user){
        return user_repository.findUserById(id_user);
    }

    public List<User> listAllUser(){
        return user_repository.findAll();
    }
}
