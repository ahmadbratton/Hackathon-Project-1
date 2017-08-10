package com.example.Hackathon.controller;

import com.example.Hackathon.model.Event;
import com.example.Hackathon.model.User;
import com.example.Hackathon.repository.EventRepo;
import com.example.Hackathon.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("/all")
    public List<Event> viewEvents() {
        Iterable<Event> getAllEvents = eventRepo.findAll();
        ArrayList<Event> allEvents = new ArrayList<>();
        for(Event currentEvent : getAllEvents) {
            allEvents.add(currentEvent);
        }
        return allEvents;
    }

    @RequestMapping("/{eventId}")
    public Event getSingleEvent(@PathVariable int eventId) {
        Event selectedEvent = eventRepo.findOne(eventId);
        return selectedEvent;
    }

    @RequestMapping("/{eventId}/rsvp")
    public String rsvp(@PathVariable int eventId, HttpSession session){
        Event selectedEvent = eventRepo.findOne(eventId);
        List<User> attendingList = selectedEvent.getAttending();
        User currentUser = userRepo.findOne((Integer) session.getAttribute("userID"));
        Boolean userFound = false;

        for (int i = 0; i < attendingList.size(); i++) {
            if (currentUser.equals(attendingList.get(i))) {
                userFound = true;
                attendingList.remove(i);
            }
        }
        if (!userFound) {
            attendingList.add(currentUser);
        }
        selectedEvent.setAttending(attendingList);
        eventRepo.save(selectedEvent);
        if (userFound) {
            return "user revoked rsvp";
        }
        return "user is now attending this event";
    }
}
