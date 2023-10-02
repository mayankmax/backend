package com.example.splitwise.Services;

import com.example.splitwise.DTOS.RequestDTO;
import com.example.splitwise.Modals.Users;
import com.example.splitwise.Repos.UserRespository;
import com.example.splitwise.Utils.LoginConstraints;
import com.example.splitwise.Utils.ProfileConstraints;
import com.example.splitwise.Exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;



//Questions
// 1) we can have string return type in both signup and login what if we make return type user?


@Service
@Lazy
public class UserServices {

    @Autowired
    private UserRespository userRespository;



    public UserServices(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    public Users signup(RequestDTO requestDTO) {

        if(userRespository.findByuserEmail(requestDTO.getUserEmail()) != null){
            return null;
        }

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


            Users user = new Users(name,email,phone,password); // new user has been created we can start the session here only

            //session should be such that user can use all other class also






            // Assuming you have some kind of save operation
            userRespository.save(user);

            return user;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
            // Log the error for further analysis
        }
    }



    public Users login(String email, String password){
        LoginConstraints loginConstraints = new LoginConstraints();

        try {
            Users user = userRespository.findByuserEmail(email);
           // System.out.println("nj"+user.getUserName());

            if(user == null){
                throw new UserException.InvalidEmailException("Email not found in our database");

            }

            String storedPassword = user.getUserPassword();

            if(!loginConstraints.login(storedPassword, password)){
                throw new UserException.InvalidPasswordException("Password doesn't match, please reset if required");
            }

            return user;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }



}
