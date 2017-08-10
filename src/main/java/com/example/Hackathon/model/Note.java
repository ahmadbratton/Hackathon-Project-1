package com.example.Hackathon.model;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue
    private int eventId;

    @Column
    private String event;

    @Column
    private String description;

    @Column
    private Date date;

    @Column
    private Status status;

    @OneToMany
    private List<User> createdBy;

    public Note() {
    }

    public Note(String event, String description, Date date, Status status, List<User> createdBy) {
        this.event = event;
        this.description = description;
        this.date = date;
        this.status = status;
        this.createdBy = createdBy;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
}
