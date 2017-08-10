package com.example.Hackathon.controller;


import com.example.Hackathon.model.User;
import com.example.Hackathon.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("api/user")
public class userController {
    @Autowired
    UserRepo userRepo;

    @PostMapping("/login")
    public String login(String email, String password, HttpSession session) {
        User foundUser = userRepo.findByEmail(email);
        System.out.println(email);
        System.out.println(password);

        if (foundUser == null) {
            return "user not found";
        }

        if (foundUser.getPassword().equals(password)) {
            session.setAttribute("userId", foundUser.getUserId());
            return "user login successful";
        } else {
            return "No user/password combination";
        }
    }

    @PostMapping("/register")
    public String register(String email, String password, String firstName, String lastName) {
        if (email == null || password == null || firstName == null || lastName == null){
            throw new IllegalArgumentException("Please supply all required values");
        }
        
        boolean alreadyExists = userRepo.findByEmail(email) != null;
        if (alreadyExists){throw new IllegalArgumentException("User already exists");}

        User newUser = new User();

        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);

        userRepo.save(newUser);

        return "created new user";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "Logged out successfully";
    }

}
