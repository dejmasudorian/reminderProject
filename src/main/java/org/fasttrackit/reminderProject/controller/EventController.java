package org.fasttrackit.reminderProject.controller;
import org.fasttrackit.reminderProject.domain.Event;
import org.fasttrackit.reminderProject.exception.ResourceNotFoundException;
import org.fasttrackit.reminderProject.service.EventService;
import org.fasttrackit.reminderProject.transfer.Event.CreateEventRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/events")
@CrossOrigin
public class EventController {

    private final EventService service;

    @Autowired
    public EventController(EventService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody @Valid CreateEventRequest request) throws ResourceNotFoundException {
        Event response = service.createEvent(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEvent(@PathVariable("id") long id) throws ResourceNotFoundException {
        Event response = service.getEvent(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteReminder(@PathVariable("id") long id) {
        service.deleteEvent(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
