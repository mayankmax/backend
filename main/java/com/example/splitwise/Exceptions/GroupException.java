package com.example.splitwise.Exceptions;

public class GroupException extends Exception{

    public GroupException(String error){
        super(error);
    }

    public static class InvalidGroupNameException extends GroupException {
        public InvalidGroupNameException(String error){
            super(error);
        }

    }
}
