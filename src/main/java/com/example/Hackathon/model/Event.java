package com.example.Hackathon.model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue
    private int eventId;

    @Column
    private String description;

    @OneToOne
    private User about;

    @OneToMany
    private List<User> createdBy;

    public Event() {
    }

    public Event(String description, User about, List<User> createdBy) {
        this.description = description;
        this.about = about;
        this.createdBy = createdBy;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
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

    public List<User> getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(List<User> createdBy) {
        this.createdBy = createdBy;
    }
}
