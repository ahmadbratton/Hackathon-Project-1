package com.example.Hackathon.model;
import javax.persistence.*;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue
    private int noteId;

    @Column
    private String description;

    @OneToOne
    private User about;

    @OneToOne
    private User createdBy;

    public Event() {
    }

    public Event(String description, User about, User createdBy) {
        this.description = description;
        this.about = about;
        this.createdBy = createdBy;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
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
