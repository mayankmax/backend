package com.example.splitwise.Controllers;

import com.example.splitwise.DTOS.RequestDTO;
import com.example.splitwise.DTOS.ResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class UserController {

    @PostMapping("/signup")
    public ResponseDTO signup(RequestDTO requestDTO)
    {
        return null;
    }

    @GetMapping("/login")
    public ResponseDTO login(@Valid @RequestBody RequestDTO requestDTO){
        return null;
    }




}
