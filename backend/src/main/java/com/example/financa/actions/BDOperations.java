package com.example.financa.actions;

import com.example.financa.entities.User;
import com.example.financa.factory.Factorys;
import com.example.financa.service.TokenService;
import com.example.financa.service.UserService;
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

    private final DataSource data_source;

    public BDOperations(DataSource dataSource) {
        this.data_source = dataSource;
    }

    public static void loadBD(UserService user_service, TokenService token_service){

        try {

            Scanner loader = new Scanner(new ClassPathResource("/bd/settings.txt").getFile());

            while (loader.hasNextLine()){

                String line = loader.nextLine();

                User user = (User) Factorys.USER_FACTORY.createByLine(line);

                token_service.saveToken(user.getTokenUser());
                user_service.saveUser(user);

            }
        } catch (IOException e) {
            throw new RuntimeException("File 'settings.txt' dont exist");
        }

    }

    @EventListener(ApplicationStartedEvent.class)
    public void executeSqlFileOnAppLoad(){

        System.out.println("ENTER IN LOAD");

        ClassPathResource sql = new ClassPathResource("/bd/createSchema.sql");

        ResourceDatabasePopulator resource_db_schema = new ResourceDatabasePopulator
                    (false, false, "UTF-8", sql);

        resource_db_schema.execute(data_source);

    }
}
