package org.fasttrackit.reminderProject.Steps;

import org.fasttrackit.reminderProject.domain.LevelOfImportance;
import org.fasttrackit.reminderProject.domain.Notification;
import org.fasttrackit.reminderProject.exception.ResourceNotFoundException;
import org.fasttrackit.reminderProject.service.NotificationService;
import org.fasttrackit.reminderProject.transfer.Notification.CreateNotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Component
public class NotificationSteps {

    @Autowired
    private NotificationService service;

    public Notification createNotofication() throws ParseException, ResourceNotFoundException {
        CreateNotificationRequest request = new CreateNotificationRequest();
        Calendar calendar = new GregorianCalendar(2019, 1 , 25);
        Date date = calendar.getTime();

        request.setDetails("Multe");
        request.setLevelOfImportance(LevelOfImportance.LOW);
        request.setReminderCreatedDate(date);

        return service.createNotification(request);
    }
}
