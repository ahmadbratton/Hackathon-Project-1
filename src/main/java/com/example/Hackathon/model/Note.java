package com.example.Hackathon.model;

import javax.persistence.*;

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

    @OneToOne
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

    @Override
    public String toString() {
        return "Note{" +
            "noteId=" + noteId +
            ", description='" + description + '\'' +
            ", about=" + about +
            ", createdBy=" + createdBy +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        return noteId == note.noteId;
    }

    @Override
    public int hashCode() {
        return noteId;
    }
}
