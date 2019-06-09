package org.fasttrackit.reminderProject.controller;
import org.fasttrackit.reminderProject.domain.Event;
import org.fasttrackit.reminderProject.exception.ResourceNotFoundException;
import org.fasttrackit.reminderProject.service.EventService;
import org.fasttrackit.reminderProject.transfer.Event.CreateEventRequest;
import org.fasttrackit.reminderProject.transfer.Event.EventRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

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
    public ResponseEntity<Event> createEvent(@RequestBody @Valid EventRequest request) {
        Event response = service.createEvent(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    public ResponseEntity<Event> addEventToReminder(@RequestBody @Valid CreateEventRequest request) throws ResourceNotFoundException {
        Event response = service.addEventToReminder(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEvent(@PathVariable("id") long id) throws ResourceNotFoundException {
        Event response = service.getEvent(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Event>> getAllEvents(){
        List<Event> response = service.getAllEvents();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteReminder(@PathVariable("id") long id) {
        service.deleteEvent(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity options(HttpServletResponse response) {
        response.setHeader("Allow", "HEAD,GET,PUT,OPTIONS,POST,DELETE");
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateReminder(
            @PathVariable("id") long id,
            @RequestBody @Valid EventRequest request) throws ResourceNotFoundException {
        service.updateEvent(id, request);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
