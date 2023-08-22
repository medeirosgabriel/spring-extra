package com.ufcg.es.healthtrack.util;

public class Util {

    private static final String EMAIL_REGEX = "^([a-zA-Z0-9\\._]+)@([a-zA-Z0-9])+.([a-z]+)(.[a-z]+)?$";

    private static final String PASSWORD_REGEX = "^.{8,}$";

    public static void verifyNull(Object obj, String objName) {
        if(obj == null) {
            throw new IllegalArgumentException(String.format("The field %s can't be null.", objName));
        }
    }

    public static void verifyEmptyString(String str, String attr) {
        if(str.trim().equals("")) {
            throw new IllegalArgumentException(String.format("%s can't be null.", attr));
        }
    }

    public static void verifyEmailFormat(String email) {
        if(!email.matches(EMAIL_REGEX)) {
            throw new IllegalArgumentException(String.format("%s it is not a valid e-mail.", email));
        }
    }

    public static void verifyPasswordFormat(String password) {
        if(!password.matches(PASSWORD_REGEX)) {
            throw new IllegalArgumentException("The entered password is not valid, enter a password with at least 8 digits.");
        }
    }
}
