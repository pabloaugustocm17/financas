package com.example.financa.actions;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;

public class Utils {

    public static final String SUCESS_REQUEST = "200";

    public static LocalDate stringToLocalDate(String date){

        return LocalDate.parse(date);

    }

    public static String validateEmail(String email){

        if(email.isBlank()){
            return "Email blank";
        }
        
        if(!email.contains("@")){
            return "Email dont contains '@'";
        }

        String[] div_email = email.split("@");

        if(!div_email[1].contains(".")){
            return "Email dont containis sufix";
        }

        return SUCESS_REQUEST;

    }

    public static String validatePassword(String password){

        if(password.length() < 8){
            return "Password dont have 8 characters";
        }

        char[] password_char = password.toCharArray();

        boolean contain_special_char = false;
        boolean contain_number = false;
        boolean contain_char_lower = false;
        boolean contain_char_upper = false;

        for (char c : password_char) {

            if(((int) c >= 33 && (int) c <= 47)
            || ((int) c >= 58 && (int) c <= 64)
            || ((int) c >= 91 && (int) c <= 96)
            || ((int) c >= 123 && (int) c <= 126)){
                contain_special_char = true;
            }

            if((int) c >= 48 && (int) c <= 57){
                contain_number = true;
            }

            if((int) c >= 65 && (int) c <= 90){
                contain_char_upper = true;
            }

            if((int) c >= 97 && (int) c <= 122){
                contain_char_lower = true;
            }
        }

        if(!contain_special_char){
            return "No contain special character";
        }

        if(!contain_number){
            return "No contain number";
        }

        if(!contain_char_lower){
            return "No contain lower case character";
        }

        if(!contain_char_upper){
            return "No contain upper case character";
        }

        return SUCESS_REQUEST;
    }

    /* Metadata and Reflection */

    public static Class<?> getClassByName(String name_class){

        try {
            return Class.forName(name_class);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Class '" + name_class + "' no exist");
        }

    }

    public static Method getMethodByName(String name, Class<?> clas){

        for(Method method : clas.getMethods()){

            if(method.getName().equals(name)){

                return method;
            }
        }

        return null;

    }

    public static Object invokeMethodFactory(Object instance, Method method, Object... args){

        try {
            return method.invoke(instance, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Error in invoke method: " + method.getName());
        }


    }

    public static Object initializeClass(Class<?> clas){

        Constructor<?>[] constructors = clas.getConstructors();
        Constructor<?> constructor_empty = null;

        for(Constructor<?> constructor : constructors){
            if(constructor.getParameterCount() == 0){
                constructor_empty = constructor;
            }
        }

        if(constructor_empty == null){
            throw new RuntimeException("Class: " + clas.getSimpleName() + " dont have a constructor with no parameters");
        }

        try {

            return constructor_empty.newInstance();

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Error in instance a object of class: " + clas.getSimpleName());
        }


    }
}
