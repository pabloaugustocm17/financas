package com.example.financa.entities.user;

import com.example.financa.factory.Factory;
import org.springframework.stereotype.Component;

@Component
public class UserFactory implements Factory {


    @Override
    public Object create() {
        return new User();
    }

    public Object createByLine(String line){

        String[] args = line.split(";");

        String email = args[1];
        String password = args[2];
        String name = args[3];
        String birth_date = args[4];

        return new User(email, password, name, birth_date);

    }
}
