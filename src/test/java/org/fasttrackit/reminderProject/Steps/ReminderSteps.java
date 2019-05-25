package org.fasttrackit.reminderProject.Steps;

import org.fasttrackit.reminderProject.domain.Reminder;
import org.fasttrackit.reminderProject.service.ReminderService;
import org.fasttrackit.reminderProject.transfer.Reminder.CreateReminderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Component
public class ReminderSteps {

    @Autowired
    private ReminderService service;


    public Reminder createReminder() {
        CreateReminderRequest request = new CreateReminderRequest();
        Calendar calendar = new GregorianCalendar(2019, 1 , 25);
        Date date = calendar.getTime();
        request.setTitle("Family Gathering");
        request.setRemindDate(date);
        return service.createReminder(request);
    }
}
