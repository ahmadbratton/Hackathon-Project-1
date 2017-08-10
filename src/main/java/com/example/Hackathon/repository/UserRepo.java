package com.example.Hackathon.repository;

import com.example.Hackathon.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
    User findByEmail(String email);
}
