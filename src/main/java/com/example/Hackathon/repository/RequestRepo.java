package com.example.Hackathon.repository;

import com.example.Hackathon.model.Request;
import org.springframework.data.repository.CrudRepository;

public interface RequestRepo extends CrudRepository<Request, Integer> {
}
