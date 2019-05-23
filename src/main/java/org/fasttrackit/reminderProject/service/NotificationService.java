package org.fasttrackit.reminderProject.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.reminderProject.domain.Notification;
import org.fasttrackit.reminderProject.exception.ResourceNotFoundException;
import org.fasttrackit.reminderProject.repository.NotificationRepository;
import org.fasttrackit.reminderProject.transfer.Notification.CreateNotificationRequest;
import org.fasttrackit.reminderProject.transfer.Notification.UpdateNotificationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NotificationService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(ReminderService.class);

    private final NotificationRepository repository;
    private final ObjectMapper objectMapper;

    @Autowired
    public NotificationService(NotificationRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    public Notification createNotification(CreateNotificationRequest request) {
        LOGGER.info("Creating notification {}", request);
        Notification notification = objectMapper.convertValue(request, Notification.class);
        return repository.save(notification);
    }

    public Notification getNotification(long id) throws ResourceNotFoundException {
        LOGGER.info("Retrieving notification {}", id);
        return repository.findById(id)
                // Optional and lambda expression
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Reminder " + id + " not found"));
    }

    public List<Notification> getAllReminders()
    {LOGGER.info("Retrieving all notifications:");
        return repository.findAll();
    }


    public Notification updateNotification(long id, UpdateNotificationRequest request) throws ResourceNotFoundException {
        LOGGER.info("Updating notification {}, {}", id, request);
        Notification notification = getNotification(id);

        BeanUtils.copyProperties(request, notification);

        return repository.save(notification);
    }

    public void deleteNotification(long id) {
        LOGGER.info("Deleting notification {}", id);
        repository.deleteById(id);
        LOGGER.info("Deleted notification {}", id);
    }
}
