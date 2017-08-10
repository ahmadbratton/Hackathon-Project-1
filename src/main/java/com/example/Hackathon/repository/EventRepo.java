package com.example.Hackathon.repository;

import com.example.Hackathon.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepo extends CrudRepository<Event, Integer>{
}
