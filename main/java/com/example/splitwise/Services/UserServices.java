package com.example.splitwise.Services;

import com.example.splitwise.DTOS.RequestDTO;
import com.example.splitwise.Modals.Users;
import com.example.splitwise.Utils.ProfileConstraints;
import com.example.splitwise.Exceptions.*;

import org.springframework.stereotype.Service;

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
}
