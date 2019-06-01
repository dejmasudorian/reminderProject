package org.fasttrackit.reminderProject.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.fasttrackit.reminderProject.domain.Notification;
import org.fasttrackit.reminderProject.domain.Reminder;
import org.fasttrackit.reminderProject.exception.ResourceNotFoundException;
import org.fasttrackit.reminderProject.repository.ReminderRepository;
import org.fasttrackit.reminderProject.transfer.Reminder.CreateReminderRequest;
import org.fasttrackit.reminderProject.transfer.Reminder.UpdateReminderRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(ReminderService.class);

    private final ReminderRepository repository;
    private final NotificationService notificationService;
    private final ObjectMapper objectMapper;


    @Autowired
    public ReminderService(ReminderRepository repository, NotificationService notificationService, ObjectMapper objectMapper) {
        this.repository = repository;
        this.notificationService = notificationService;
        this.objectMapper = objectMapper;
    }

    public Reminder createReminder(CreateReminderRequest request) {
        LOGGER.info("Creating reminder {}", request);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        Reminder reminder = objectMapper.convertValue(request, Reminder.class);
        return repository.save(reminder);
    }


    public Reminder getReminder(long id) throws ResourceNotFoundException {
        LOGGER.info("Retrieving reminder {}", id);
        return repository.findById(id)
                // Optional and lambda expression
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Reminder " + id + " not found"));
    }

    public List<Reminder> getAllReminders()
    {LOGGER.info("Retrieving all reminders:");
        return repository.findAll();
    }


    public Reminder updateReminder(long id, UpdateReminderRequest request) throws ResourceNotFoundException {
        LOGGER.info("Updating reminder {}, {}", id, request);
        Reminder reminder = getReminder(id);

        BeanUtils.copyProperties(request, reminder);

        return repository.save(reminder);
    }

    public void deleteReminder(long id) {
        LOGGER.info("Deleting reminder {}", id);
        repository.deleteById(id);
        LOGGER.info("Deleted reminder {}", id);
    }
}