package com.example.financa.actions;

import com.example.financa.entities.User;
import com.example.financa.factory.Factorys;
import com.example.financa.repository.TokenRepository;
import com.example.financa.repository.UserRepository;
import com.example.financa.service.TokenService;
import com.example.financa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Scanner;

@Component
public class BDOperations {

    @Autowired
    private DataSource dataSource;

    public static void loadBD(UserRepository userRepository, TokenRepository tokenRepository){

        try {

            Scanner loader = new Scanner(new ClassPathResource("/bd/settings.txt").getFile());

            while (loader.hasNextLine()){

                String line = loader.nextLine();

                User user = (User) Factorys.USER_FACTORY.createByLine(line);

                tokenRepository.save(user.getTokenUser());
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
    public static void saveNewUser(UserService userRepository, TokenService tokenService , User newUser){

        tokenService.saveToken(newUser.getTokenUser());
        userRepository.saveUser(newUser);

    }
    public static boolean isUserExist(UserService userRepository, User user){

        return userRepository.isUserExist(user.getEmail());

    }

    @EventListener(ApplicationStartedEvent.class)
    public void executeSqlFileOnAppLoad(){

        System.out.println("ENTER IN LOAD");

        ClassPathResource sql = new ClassPathResource("/bd/createSchema.sql");

        ResourceDatabasePopulator resource_db_schema = new ResourceDatabasePopulator
                    (false, false, "UTF-8", sql);

        resource_db_schema.execute(dataSource);

    }
}
