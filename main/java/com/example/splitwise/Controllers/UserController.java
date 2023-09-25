package com.example.splitwise.Controllers;

import com.example.splitwise.DTOS.RequestDTO;
import com.example.splitwise.DTOS.ResponseDTO;
import com.example.splitwise.Services.UserServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.RequestEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class UserController {

    private UserServices userServices;

    @Autowired
    private UserController(UserServices userServices) {
        this.userServices = userServices;
    }


    @PostMapping("/signup")
    public ResponseEntity<ResponseDTO> signup(@RequestBody RequestDTO requestDTO) {
        ResponseDTO responseDTO = new ResponseDTO();
        String msg = userServices.signup(requestDTO);

        if (msg.toLowerCase().contains("successful")) {
            responseDTO.setMessage("Signup is Successful");
            responseDTO.setStatus(msg);
        } else {
            responseDTO.setMessage("Failure in Signup: " + msg);
            responseDTO.setStatus("Failure");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseDTO);
        }

        return ResponseEntity.ok(responseDTO);
    }






    @GetMapping("/login")
    public ResponseDTO login(@Valid @RequestBody RequestDTO requestDTO){
        return null;
    }




}
