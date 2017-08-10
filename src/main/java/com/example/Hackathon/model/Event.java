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

    @OneToOne
    private User createdBy;

    @OneToMany
    private List<User> attending;
    public Event() {
    }

    public Event(String description, User about, User createdBy, List<User> attending) {
        this.description = description;
        this.about = about;
        this.createdBy = createdBy;
        this.attending = attending;
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

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public List<User> getAttending() {
        return attending;
    }

    public void setAttending(List<User> attending) {
        this.attending = attending;
    }

//    Event newEvent = new Event();
//    User myUsre = new User();
//
//    newEvent.getAttending().add(myUsre);
//    EventRepo.save(newEvent);
}
