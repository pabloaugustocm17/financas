package com.example.financa.actions;

import com.example.financa.entities.TokenUser;
import com.example.financa.entities.User;
import com.example.financa.entities.Wallet;
import com.example.financa.factory.Factories;
import com.example.financa.service.TokenService;
import com.example.financa.service.UserService;
import com.example.financa.service.WalletService;
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

    private final DataSource DATA_SOURCE;

    /* Constructor */

    public BDOperations(DataSource dataSource) {
        this.DATA_SOURCE = dataSource;
    }

    /* Methods */

    public static void loadBD(UserService user_service, TokenService token_service, WalletService walletService){

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
                    case "wallet" -> walletService.saveWallet((Wallet) object);

                }

            }
        } catch (IOException e) {
            throw new RuntimeException("File 'settings.txt' dont exist");
        }

    }

    public static void saveDB(){

        //GET ALL data and save in a txt


    }

    /* Not used */

    @EventListener(ApplicationStartedEvent.class)
    public void executeSqlFileOnAppLoad(){

        System.out.println("ENTER IN LOAD");

        ClassPathResource sql = new ClassPathResource("/db/createSchema.sql");

        ResourceDatabasePopulator resource_db_schema = new ResourceDatabasePopulator
                    (false, false, "UTF-8", sql);

        resource_db_schema.execute(DATA_SOURCE);

    }
}
