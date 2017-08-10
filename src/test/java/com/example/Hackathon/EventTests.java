package com.example.Hackathon;

import com.example.Hackathon.model.Event;
import com.example.Hackathon.model.Status;
import com.example.Hackathon.model.User;
import com.example.Hackathon.repository.EventRepo;
import com.example.Hackathon.repository.UserRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by duhlig on 8/10/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EventTests {
    @Autowired
    EventRepo eventRepo;
    @Autowired
    UserRepo userRepo;

    @Test
    public void testGetAllEvents() {
        User userOne = new User();
        userOne.setEmail("email");
        userOne.setFirstName("First");
        userOne.setLastName("Last");
        userOne.setPassword("password");

        List<User> userList = new ArrayList<>();
        userList.add(userOne);

        userRepo.save(userOne);
        Event event = new Event();
        event.setName("event1");
        event.setDate("2017-12-09");
        event.setDescription("this is the description");
        event.setStatus(Status.NEW);
        event.setAttending(userList);
        event.setCreatedBy(userList);
        eventRepo.save(event);

        Iterable<Event> getAllEvents = eventRepo.findAll();
        ArrayList<Event> allEvents = new ArrayList<>();
        for(Event currentEvent : getAllEvents) {
            allEvents.add(currentEvent);
        }
        Event event1 = findInList(allEvents, "event1", "this is the description", "2017-12-09");
        Assert.assertNotNull(event1);
    }
    public static Event findInList(List<Event> events, String name, String description, String date) {
        boolean found = false;
        for (Event event : events) {
            if (event.getName().equals(name) && event.getDescription().equals(description) && event.getDate().equals(date)) {
                return event;
            }
        }
        return null;
    }
}
