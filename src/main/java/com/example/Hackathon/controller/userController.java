package com.example.Hackathon.controller;


import com.example.Hackathon.model.User;
import com.example.Hackathon.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequestMapping("api/user")
public class userController {
    @Autowired
    UserRepo userRepo;

    @RequestMapping("/login")
    public String login(HttpSession session , @RequestBody String email , @RequestBody String password){
       User foundUser = userRepo.findByEmail(email);
       if (foundUser == null){
           return "user not found";
       }
       if(foundUser.getPassword() == password){
           session.setAttribute("userId", foundUser.getUserId());
           return "user login successful";
       }
       else{
           return "No user password combination";
       }
    }



    @RequestMapping("/register")
    public String register(@RequestBody String email ,@RequestBody String password , @RequestBody String firstName , @RequestBody String lastName ){
        User newUser = new User();

        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);

        userRepo.save(newUser);

        return "created new user";

    }




}
