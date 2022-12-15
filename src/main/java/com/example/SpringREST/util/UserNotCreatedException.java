package com.example.SpringREST.util;

public class UserNotCreatedException extends RuntimeException{
    public UserNotCreatedException (String msg){
        super(msg);
    }
}
