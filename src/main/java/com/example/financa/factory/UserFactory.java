package com.example.financa.factory;

import com.example.financa.actions.Utils;
import com.example.financa.entities.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserFactory implements Factory {


    @Override
    public Object create() {
        return new User();
    }

    public User createUserByLine(String line){

        String[] args = line.split(";");

        Long id = Long.valueOf(args[0]);
        String email = args[1];
        String password = args[2];
        String name = args[3];
        double value_account = Double.parseDouble(args[4]);
        LocalDateTime birth_date = Utils.stringToLocalDateTime(args[5]);

        return new User(id, email, password, name, value_account, birth_date);

    }
}
