package com.example.Hackathon.repository;

import com.example.Hackathon.model.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepo  extends CrudRepository<Note, Integer> {
}
