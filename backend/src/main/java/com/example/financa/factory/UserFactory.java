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

        Long id = Long.valueOf(args[0]);
        String email = args[1];
        String password = args[2];
        String name = args[3];
        LocalDate birth_date = Utils.stringToLocalDate(args[4]);

        return new User(id, email, password, name, birth_date);

    }
}
