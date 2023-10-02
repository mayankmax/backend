package com.example.splitwise.Controllers;

import com.example.splitwise.DTOS.RequestDTO;
import com.example.splitwise.DTOS.ResponseDTO;
import com.example.splitwise.Modals.Users;
import com.example.splitwise.Services.UserServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserServices userServices;

    @Autowired
    private HttpSession httpSession;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @PostMapping("/signup")
    public ResponseEntity<ResponseDTO> signup(@RequestBody @Valid RequestDTO requestDTO) throws IOException {
        ResponseDTO responseDTO = new ResponseDTO();

        // Check if the user already exists

        // Create the new user
        Users user = userServices.signup(requestDTO);
        if (user != null) {
            ObjectMapper mapper = new ObjectMapper();
            byte[] bytes = mapper.writeValueAsBytes(user);
            httpSession.setAttribute("users", bytes);
            responseDTO.setMessage("Signup is Successful");
            responseDTO.setStatus("Success");
        } else {
            responseDTO.setMessage("Failure in Signup: ");
            responseDTO.setStatus("Failure");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
        }

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestParam("userEmail") String userEmail, @RequestParam("userPassword") String userPassword, HttpServletRequest request) throws IOException {
        ResponseDTO responseDTO = new ResponseDTO();

        // Check if the user is already logged in

        // Login the user
        Users user;
        ObjectMapper mapper = new ObjectMapper();
        byte[] bytes = (byte[]) request.getSession().getAttribute("users");
        if (bytes != null) {
            user = mapper.readValue(bytes, Users.class);
        } else {
            user = userServices.login(userEmail, userPassword);
            if (user != null) {
                bytes = mapper.writeValueAsBytes(user);
                request.getSession().setAttribute("users", bytes);
            }
        }

        if (user != null) {
            responseDTO.setMessage(user.getUserName()+"is logged in");
            responseDTO.setStatus("Success");
        } else {
            responseDTO.setMessage("Failure in Login: ");
            responseDTO.setStatus("Failure");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
        }

        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/logout")
    public ResponseEntity<ResponseDTO> logout(HttpServletRequest request) {
        ResponseDTO responseDTO = new ResponseDTO();

        // Clear the users session attribute
        HttpSession httpSession = request.getSession(false);
        if (httpSession != null) {
            httpSession.removeAttribute("users");
        }

        responseDTO.setMessage("Session cleared successfully");
        responseDTO.setStatus("Success");

        return ResponseEntity.ok(responseDTO);
    }

}
