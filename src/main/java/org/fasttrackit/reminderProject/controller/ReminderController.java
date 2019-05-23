package org.fasttrackit.reminderProject.controller;

import org.fasttrackit.reminderProject.domain.Reminder;
import org.fasttrackit.reminderProject.exception.ResourceNotFoundException;
import org.fasttrackit.reminderProject.service.ReminderService;
import org.fasttrackit.reminderProject.transfer.Reminder.CreateReminderRequest;
import org.fasttrackit.reminderProject.transfer.Reminder.UpdateReminderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/reminder")
@CrossOrigin
public class ReminderController {

    private final ReminderService service;

    @Autowired
    public ReminderController(ReminderService service) {
        this.service = service;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Reminder> getReminder(@PathVariable("id") long id) throws ResourceNotFoundException {
        Reminder response = service.getReminder(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Reminder> createReminder(@RequestBody @Valid CreateReminderRequest request) {
        Reminder response = service.createProduct(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateReminder(
            @PathVariable("id") long id,
            @RequestBody @Valid UpdateReminderRequest request) throws ResourceNotFoundException {
        service.updateReminder(id, request);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteReminder(@PathVariable("id") long id) {
        service.deleteReminder(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}