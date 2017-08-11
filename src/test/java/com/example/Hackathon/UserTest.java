package com.example.Hackathon;


import com.example.Hackathon.model.User;
import com.example.Hackathon.repository.UserRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    UserRepo userRepo;

    @Test
    public void createAUser(){
        User newuser = new User();
        newuser.setEmail("email");
        newuser.setFirstName("joe");
        newuser.setLastName("smith");
        newuser.setPassword("password");

        userRepo.save(newuser);

       Iterable<User> getAllusers = userRepo.findAll();
        ArrayList<User> allusers = new ArrayList<>();

        for (User user: getAllusers) {
            allusers.add(user);
        }

        User exsisting = findInList(allusers, "joe", "smith", "email", "password");

        Assert.assertNotNull(exsisting);

        User user3 = userRepo.findOne(exsisting.getUserId());

        Assert.assertEquals("joe", user3.getFirstName());
        Assert.assertEquals("smith", user3.getLastName());
        Assert.assertEquals("email", user3.getEmail());
        Assert.assertEquals("password", user3.getPassword());

    }
    private static User findInList(List<User> users, String first, String last, String email, String password) {
        // Find the new person in the list
        boolean found = false;
        for (User user : users) {
            System.out.println(user.getEmail() + user.getFirstName() + user.getLastName() + user.getPassword());
            System.out.println(first + last + email + password);
            if (user.getFirstName().equals(first) && user.getLastName().equals(last) && user.getEmail().equals(email) && user.getPassword().equals(password)) {
//            if (user.getFirstname().equals(first) && customer.getLastname().equals(last) && customer.getEmail().equals(email) && customer.getPhone().equals(phone)) {
                System.out.println("+1");
                return user;
            }
        }
        return null;
    }

}

