package com.example.financa.actions;

import com.example.financa.entities.TokenUser;
import com.example.financa.entities.User;
import com.example.financa.factory.Factories;
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

            Scanner loader = new Scanner(new ClassPathResource("/db/db.txt").getFile());

            while (loader.hasNextLine()){

                String line = loader.nextLine();
                String[] split = line.split(";");
                String type = split[0];

                Object object = Factories.createObject(line, type);

                switch (type){

                    case "user" -> user_service.saveUser((User) object);
                    case "token" -> token_service.saveToken((TokenUser) object);

                }

            }
        } catch (IOException e) {
            throw new RuntimeException("File 'settings.txt' dont exist");
        }

    }

    public static void saveDB(){




    }

    @EventListener(ApplicationStartedEvent.class)
    public void executeSqlFileOnAppLoad(){

        System.out.println("ENTER IN LOAD");

        ClassPathResource sql = new ClassPathResource("/db/createSchema.sql");

        ResourceDatabasePopulator resource_db_schema = new ResourceDatabasePopulator
                    (false, false, "UTF-8", sql);

        resource_db_schema.execute(data_source);

    }
}
