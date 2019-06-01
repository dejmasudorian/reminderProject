package org.fasttrackit.reminderProject;

import org.fasttrackit.reminderProject.Steps.ReminderSteps;
import org.fasttrackit.reminderProject.domain.Event;
import org.fasttrackit.reminderProject.domain.Reminder;
import org.fasttrackit.reminderProject.exception.ResourceNotFoundException;
import org.fasttrackit.reminderProject.service.EventService;
import org.fasttrackit.reminderProject.transfer.Event.CreateEventRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HibernateIntegrationTests {

    @Autowired
    private EventService eventService;

    @Autowired
    private ReminderSteps reminderSteps;
/*
    @Test
    public void testCreateEvent_whenValidRequest_thenReturnEvent() throws ResourceNotFoundException {
        Reminder reminder = reminderSteps.createReminder();

        CreateEventRequest eventRequest = new CreateEventRequest();
        eventRequest.setReminderId(reminder.getId());
        eventRequest.setName("Meeting at 12:00");
        eventRequest.setLocation("Restaurant Walker");
        eventRequest.setDescription("Talk with co-workers about business plans.");

        Calendar calendar = new GregorianCalendar(2019, 9 , 19);
        Date date = calendar.getTime();
        eventRequest.setDateEvent(date);

        Event event = eventService.addEventToReminder(eventRequest);

        assertThat(event, notNullValue());
        assertThat(event.getId(), greaterThan(0L));

        assertThat(event.getReminder(), notNullValue());
        assertThat(event.getReminder().getId(), is(reminder.getId()));
        assertThat(event.getDescription(), is(eventRequest.getDescription()));
    }
*/
}
