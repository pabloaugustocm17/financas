package com.example.financa.factory;

import com.example.financa.actions.Utils;
import com.example.financa.entities.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserFactory implements Factory {


    @Override
    public Object create() {
        return new User();
    }

    public Object createByLine(String line){

        String[] args = line.split(";");

        Long id = Long.valueOf(args[1]);
        String email = args[2];
        String password = args[3];
        String name = args[4];
        LocalDate birth_date = Utils.stringToLocalDate(args[5]);

        return new User(id, email, password, name, birth_date);

    }
}
