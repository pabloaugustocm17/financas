package com.example.financa.actions;

import java.time.LocalDate;

public class Utils {

    public static LocalDate stringToLocalDate(String date){

        return LocalDate.parse(date);

    }


}
