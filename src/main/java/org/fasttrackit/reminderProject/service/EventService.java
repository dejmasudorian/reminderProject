package org.fasttrackit.reminderProject.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.fasttrackit.reminderProject.domain.Event;
import org.fasttrackit.reminderProject.domain.Reminder;
import org.fasttrackit.reminderProject.exception.ResourceNotFoundException;
import org.fasttrackit.reminderProject.repository.EventRepository;
import org.fasttrackit.reminderProject.transfer.Event.CreateEventRequest;
import org.fasttrackit.reminderProject.transfer.Event.EventRequest;
import org.fasttrackit.reminderProject.transfer.Reminder.CreateReminderRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(ReminderService.class);

    private final EventRepository eventRepository;
    private final ReminderService reminderService;
    private final ObjectMapper objectMapper;

    @Autowired
    public EventService(EventRepository eventRepository, ReminderService reviewRepository, ReminderService reminderService, ObjectMapper objectMapper) {
        this.eventRepository = eventRepository;
        this.reminderService = reminderService;
        this.objectMapper = objectMapper;
    }

    @Transactional
    public Event addEventToReminder(CreateEventRequest request) throws ResourceNotFoundException {
        LOGGER.info("Adding event to reminder{}", request);
        Reminder reminder = reminderService.getReminder(request.getReminderId());

        Event event = new Event();
        event.setName(request.getName());
        event.setLocation(request.getLocation());
        event.setDescription(request.getDescription());
        event.setDateEvent(request.getDateEvent());
        event.setReminder(reminder);

        return eventRepository.save(event);
    }

    public Event createEvent(EventRequest request) {
        LOGGER.info("Creating event {}", request);
        Event event = objectMapper.convertValue(request, Event.class);
        return eventRepository.save(event);
    }

    public Event getEvent(long id) throws ResourceNotFoundException {
        LOGGER.info("Retrieving event {}", id);
        return eventRepository.findById(id)
                // Optional and lambda expression
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Events " + id + " not found"));}

    public void deleteEvent(long id) {
        LOGGER.info("Deleting event {}", id);
        eventRepository.deleteById(id);
        LOGGER.info("Deleted event {}", id);
    }

    public List<Event> getAllEvents()
    {LOGGER.info("Retrieving all events:");
        return eventRepository.findAll();
    }

    public Event updateEvent(long id, EventRequest request) throws ResourceNotFoundException {
        LOGGER.info("Updating event {}, {}", id, request);
        Event event = getEvent(id);

        BeanUtils.copyProperties(request, event);

        return eventRepository.save(event);
    }
}
