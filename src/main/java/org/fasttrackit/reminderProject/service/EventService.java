package org.fasttrackit.reminderProject.service;

import org.fasttrackit.reminderProject.domain.Event;
import org.fasttrackit.reminderProject.domain.Reminder;
import org.fasttrackit.reminderProject.exception.ResourceNotFoundException;
import org.fasttrackit.reminderProject.repository.EventRepository;
import org.fasttrackit.reminderProject.transfer.Event.CreateEventRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(ReminderService.class);

    private final EventRepository eventRepository;
    private final ReminderService reminderService;

    @Autowired
    public EventService(EventRepository eventRepository, ReminderService reviewRepository, ReminderService reminderService) {
        this.eventRepository = eventRepository;
        this.reminderService = reminderService;
    }

    public Event createEvent(CreateEventRequest request) throws ResourceNotFoundException {
        LOGGER.info("Creating event {}", request);
        Reminder reminder = reminderService.getReminder(request.getReminderId());

        Event event = new Event();
        event.setDescription(request.getDescription());
        event.setReminder(reminder);

        return eventRepository.save(event);
    }

    public Event getEvent(long id) throws ResourceNotFoundException {
        LOGGER.info("Retrieving event {}", id);
        return eventRepository.findById(id)
                // Optional and lambda expression
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Reminder " + id + " not found"));}

    public void deleteEvent(long id) {
        LOGGER.info("Deleting event {}", id);
        eventRepository.deleteById(id);
        LOGGER.info("Deleted event {}", id);
    }
}
