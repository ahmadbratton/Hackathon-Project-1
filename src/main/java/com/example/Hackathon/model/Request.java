package com.example.Hackathon.model;

import javax.persistence.*;

@Entity
@Table(name = "acquaintance")
public class Request {

    @Id
    @GeneratedValue
    private int requestId;

    @OneToOne
    private User requestFrom;

    @OneToOne
    private User requestTo;

    @Column
    private String message;

    public Request() {
    }

    public Request(User requestFrom, User requestTo, String message) {
        this.requestFrom = requestFrom;
        this.requestTo = requestTo;
        this.message = message;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public User getRequestFrom() {
        return requestFrom;
    }

    public void setRequestFrom(User requestFrom) {
        this.requestFrom = requestFrom;
    }

    public User getRequestTo() {
        return requestTo;
    }

    public void setRequestTo(User requestTo) {
        this.requestTo = requestTo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Request{" +
            "requestId=" + requestId +
            ", requestFrom=" + requestFrom +
            ", requestTo=" + requestTo +
            ", message='" + message + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Request request = (Request) o;

        return requestId == request.requestId;
    }

    @Override
    public int hashCode() {
        return requestId;
    }
}
