package com.example.financa.actions;

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
            return "Password have 8 characters";
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

}
