package com.example.financa.exception;

public class ParseRuntimeException extends RuntimeException{

    public ParseRuntimeException(String var) {
        super("The var: '" + var + "' isn't a number");
    }

}
