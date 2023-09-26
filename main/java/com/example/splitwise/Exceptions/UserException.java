package com.example.splitwise.Exceptions;

public class UserException extends Exception {

    public UserException(String errorMessage) {
        super(errorMessage);
    }

    public static class InvalidEmailException extends UserException {
        public InvalidEmailException(String errorMessage) {
            super(errorMessage);
        }
    }

    public static class InvalidNameException extends UserException {
        public InvalidNameException(String errorMessage) {
            super(errorMessage);
        }
    }

    public static class InvalidPhoneException extends UserException{
        public InvalidPhoneException(String errorMessage) {
            super(errorMessage);
        }
    }
    public static class InvalidPasswordException extends UserException{

        public InvalidPasswordException(String errorMessage) {
            super(errorMessage);
        }
    }
}
