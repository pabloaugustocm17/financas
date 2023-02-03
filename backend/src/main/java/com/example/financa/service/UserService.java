package com.example.financa.service;

import com.example.financa.actions.Utils;
import com.example.financa.entities.User;
import com.example.financa.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
        userRepository.save(user);
    }

    public boolean isUserExist(String email){

        String response = userRepository.isUserExist(email);

        return (response != null);

    }

    public boolean loginUser(String email, String password){

        Long id = userRepository.loginUser(email, password);

        return id != null;

    }
}
