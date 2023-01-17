package com.example.financa.actions;

import com.example.financa.entities.User;
import com.example.financa.factory.Factorys;
import com.example.financa.repository.UserRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class BDOperations {

    public static void loadBD(UserRepository userRepository){

        try {

            Scanner loader = new Scanner(new ClassPathResource("/bd/settings.txt").getFile());

            while (loader.hasNextLine()){

                String line = loader.nextLine();

                User user = (User) Factorys.userFactory.createByLine(line);

                userRepository.save(user);

            }
        } catch (IOException e) {
            throw new RuntimeException("File 'settings.txt' dont exist");
        }

    }
    public static void saveUser(UserRepository userRepository, User userChanged){

        User userActual = userRepository.findUserById(userChanged.getId());

        if(userActual == userChanged){
            userRepository.saveAndFlush(userChanged);
        }

    }
    public static void saveNewUser(UserRepository userRepository, User newUser){

        userRepository.save(newUser);

    }
    public static boolean isUserExist(UserRepository userRepository, User user){

        return userRepository.isUserExist(user.getEmail()) == null;

    }
}
