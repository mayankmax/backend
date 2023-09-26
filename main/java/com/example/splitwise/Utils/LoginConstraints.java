package com.example.splitwise.Utils;

import java.util.HashMap;
import java.util.Map;

public class LoginConstraints {

    // Map of email and password
    private Map<String, String> mp = new HashMap<>();
    //just for now taking map for testing login
    //further we will add database as well

    // Constructor to initialize the map
    public LoginConstraints() {
        // Insert 10 email-password pairs
        mp.put("email1@example.com", "Password1@");
        mp.put("email2@example.com", "Password2@");
        mp.put("email3@example.com", "Password3@");
        mp.put("email4@example.com", "Password4@");
        mp.put("email5@example.com", "Password5@");
        mp.put("email6@example.com", "Password6@");
        mp.put("email7@example.com", "Password7@");
        mp.put("email8@example.com", "Password8@");
        mp.put("email9@example.com", "Password9@");
        mp.put("email10@example.com", "Password10@");
    }

    //why to take login email() because to use customeException

    public boolean loginEmail(String email){
        if(mp.containsKey(email))
            return true;
        return false;
    }


    public boolean login(String email, String password) {
        if (mp.containsKey(email) && mp.get(email).equals(password)) {
            return true;
        }
        return false;
    }



}
