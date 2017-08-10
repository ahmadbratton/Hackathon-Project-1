package com.example.Hackathon.controller;

import com.example.Hackathon.model.Event;
import com.example.Hackathon.model.Status;
import com.example.Hackathon.model.User;
import com.example.Hackathon.repository.EventRepo;
import com.example.Hackathon.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by duhlig on 8/10/17.
 */
@RestController
@RequestMapping("api/event")
public class EventController {
    @Autowired
    EventRepo eventRepo;

    @Autowired
    UserRepo userRepo;

    @PostConstruct
    public void init() {
        if (userRepo.count() == 0){
        User myUser = new User("newEmail", "firstName", "lastName", "password", null);
        userRepo.save(myUser);

        myUser = userRepo.findByEmail("email");
        List<User> created = new ArrayList<>();
        created.add(myUser);

        Event newEvent = new Event("name", "description", "Some date", Status.NEW, "location", created, created);
        eventRepo.save(newEvent);
        }
    }

    @RequestMapping("/all")
    public List<Event> viewEvents() {
        ArrayList<Event> allEvents = new ArrayList<>();
        eventRepo.findAll().forEach(allEvents::add);

        return allEvents;
    }

    @RequestMapping("/{eventId}")
    public Event getSingleEvent(@PathVariable int eventId) {
        Event selectedEvent = eventRepo.findOne(eventId);

        if (selectedEvent == null){throw new IllegalArgumentException();}

        return selectedEvent;
    }

    @RequestMapping("/{eventId}/rsvp")
    public String rsvp(@PathVariable int eventId, HttpSession session) {
        Event selectedEvent = eventRepo.findOne(eventId);
        if (selectedEvent == null){throw new IllegalArgumentException();}

        List<User> attendingList = selectedEvent.getAttending();
        User currentUser = userRepo.findOne((Integer) session.getAttribute("userId"));

        if (attendingList.contains(currentUser)){
            attendingList.remove(currentUser);
            eventRepo.save(selectedEvent);
            return "User no longer going to event";
        } else {
            attendingList.add(currentUser);
            eventRepo.save(selectedEvent);
            return "user is now attending this event";
        }
    }
}
