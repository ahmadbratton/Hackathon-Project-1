package com.example.Hackathon.model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue
    private int noteId;

    @Column
    private String description;

    @OneToOne
    private User about;

    @OneToMany
    private User createdBy;


    public Note() {
    }

    public Note(String description, User about, User createdBy) {
        this.description = description;
        this.about = about;
        this.createdBy = createdBy;
    }

    public int getNoteIdd() {
        return noteId;
    }

    public void setNventId(int noteId) {
        this.noteId = noteId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAbout() {
        return about;
    }

    public void setAbout(User about) {
        this.about = about;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

}
