package com.example.Hackathon.model;
import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue
    private int eventId;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String date;

    @Column
    private Status status;

    @OneToMany
    private List<User> createdBy;

    @OneToMany
    private List<User> attending;

    public Event() {
    }

    public Event(String name, String description, String date, Status status, List<User> createdBy, List<User> attending) {
        this.name = name;
        this.description = description;
        this.date = date;
        this.status = status;
        this.createdBy = createdBy;
        this.attending = attending;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<User> getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(List<User> createdBy) {
        this.createdBy = createdBy;
    }

    public List<User> getAttending() {
        return attending;
    }

    public void setAttending(List<User> attending) {
        this.attending = attending;
    }
}
