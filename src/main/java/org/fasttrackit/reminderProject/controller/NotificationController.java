package org.fasttrackit.reminderProject.controller;

import org.fasttrackit.reminderProject.domain.Notification;
import org.fasttrackit.reminderProject.exception.ResourceNotFoundException;
import org.fasttrackit.reminderProject.service.NotificationService;
import org.fasttrackit.reminderProject.transfer.Notification.CreateNotificationRequest;
import org.fasttrackit.reminderProject.transfer.Notification.UpdateNotificationRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/notification")
@CrossOrigin
public class NotificationController {

    private final NotificationService service;

    @Autowired
    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotification(@PathVariable("id") long id) throws ResourceNotFoundException {
        Notification response = service.getNotification(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody @Valid CreateNotificationRequest request) {
        Notification response = service.createNotification(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateNotification(
            @PathVariable("id") long id,
            @RequestBody @Valid UpdateNotificationRequest request) throws ResourceNotFoundException {
        service.updateNotification(id, request);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteNotification(@PathVariable("id") long id) {
        service.deleteNotification(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
