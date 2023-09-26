package com.example.splitwise.Services;

import com.example.splitwise.DTOS.RequestDTO;
import com.example.splitwise.Modals.Users;
import com.example.splitwise.Utils.LoginConstraints;
import com.example.splitwise.Utils.ProfileConstraints;
import com.example.splitwise.Exceptions.*;

import org.springframework.stereotype.Service;

//Questions
// 1) we can have string return type in both signup and login what if we make return type user?


@Service
public class UserServices {

    //private ResponseDTO responseDTO;


    public String signup(RequestDTO requestDTO) {
        ProfileConstraints profileConstraints = new ProfileConstraints();

        String email = requestDTO.getUserEmail();
        String name = requestDTO.getUserName();
        String phone = requestDTO.getUserPhone();
        String password = requestDTO.getUserPassword();

        System.out.println(email);
        System.out.println(name);


        try {
        // Validate email
        String emailValidationResult = profileConstraints.isValidEmail(email);
        if (!"true".equals(emailValidationResult)) {
            throw new UserException.InvalidEmailException(emailValidationResult);
        }

        // Validate name
        String nameValidationResult = profileConstraints.isValidName(name);
        if (!"true".equals(nameValidationResult)) {
            throw new UserException.InvalidNameException(nameValidationResult);
        }

        // Validate phone
        String phoneValidationResult = profileConstraints.isValidIndianPhoneNumber(phone);
        if (!"true".equals(phoneValidationResult)) {
            throw new UserException.InvalidPhoneException(phoneValidationResult);
        }

        // Validate password
        String passwordValidationResult = profileConstraints.isValidPassword(password);
        if (!"true".equals(passwordValidationResult)) {
            throw new UserException.InvalidPasswordException(passwordValidationResult);
        }


            Users user = new Users();
            user.setUserEmail(email);
            user.setUserName(name);
            user.setUserPassword(password);
            user.setUserPhone(phone);

            // Assuming you have some kind of save operation
            // userRepository.save(user);

            return "Signup successful";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error Causing: " + e.getMessage();
            // Log the error for further analysis
        }
    }

    public String login(String email, String password){
        LoginConstraints loginConstraints = new LoginConstraints();


        try {
            if(!loginConstraints.loginEmail(email)){
                throw new UserException.InvalidEmailException("Email not found in our databse");
            }

            if(!loginConstraints.login(email,password)){
                throw new UserException.InvalidPasswordException("Password doesn't match, please reset if required");
            }

            //when user is either doing signup or signin then only we can create user(try to make session as well)
            //we have choice to create user only in login as we can redirect signup person to login or
            //we can create at both time

            Users users = new Users();

            users.setUserEmail(email); // no need to set the password un-necessarily

            return "Login is verified";

        }catch (Exception e){
            e.printStackTrace();
            return "Error Causing: " + e.getMessage();

        }



    }

}
