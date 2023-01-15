package com.example.financa.actions;

import java.time.LocalDateTime;

public class Utils {

    private static final String PATTERN_DATE = "yyyy-MM-dd";

    public static LocalDateTime stringToLocalDateTime(String date){

        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_DATE);

        //return LocalDateTime.parse(date, formatter);

        return LocalDateTime.now();
    }


}
