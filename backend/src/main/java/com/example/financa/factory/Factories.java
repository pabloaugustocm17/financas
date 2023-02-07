package com.example.financa.factory;

import com.example.financa.actions.Utils;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Scanner;

@Component
public class Factories {

    public static HashMap<String, Method> HASH_METHODS = new HashMap<>();
    public static HashMap<String, Class<?>> HASH_FACTORIES_CLASS = new HashMap<>();


    /* Methods */

    public static Object createObject(String line, String type){

        Method method = HASH_METHODS.get(type);

        Class<?> clas = HASH_FACTORIES_CLASS.get(type);

        Object instance = Utils.initializeClass(clas);

        return Utils.invokeMethodFactory(instance, method, line);
    }

    /* Start hashs */

    @EventListener(ApplicationStartedEvent.class)
    public void returnHashOfMethods(){

        try {

            Scanner sc = new Scanner(new ClassPathResource("/settings/types.txt").getInputStream());

            while(sc.hasNextLine()){

                String line = sc.nextLine();
                String[] split = line.split(";");

                String name_class_primary = split[0];
                String path_factory = split[1];

                Class<?> clas = Utils.getClassByName(path_factory);
                Method method_class_primary = Utils.getMethodByName("createByLine", clas);

                HASH_METHODS.put(name_class_primary, method_class_primary);

            }
        } catch (IOException e) {
            throw new RuntimeException("File 'types.txt' no exist");
        }

    }

    @EventListener(ApplicationStartedEvent.class)
    public void returnHashOfFactories(){

        try {

            Scanner sc = new Scanner(new ClassPathResource("/settings/types.txt").getInputStream());

            while(sc.hasNextLine()){

                String line = sc.nextLine();
                String[] split = line.split(";");

                String name_class_primary = split[0];
                String path_factory = split[1];

                Class<?> clas = Utils.getClassByName(path_factory);

                HASH_FACTORIES_CLASS.put(name_class_primary, clas);

            }
        } catch (IOException e) {
            throw new RuntimeException("File 'types.txt' no exist");
        }

    }



}
