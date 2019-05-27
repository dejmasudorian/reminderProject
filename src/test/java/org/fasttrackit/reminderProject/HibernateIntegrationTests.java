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

    @Test
    public void testCreateEvent_whenValidRequest_thenReturnEvent() throws ResourceNotFoundException {
        Reminder reminder = reminderSteps.createReminder();

        CreateEventRequest eventRequest = new CreateEventRequest();
        eventRequest.setReminderId(reminder.getId());
        eventRequest.setDescription("Event Details");

        Event event = eventService.createEvent(eventRequest);

        assertThat(event, notNullValue());
        assertThat(event.getId(), greaterThan(0L));

        assertThat(event.getReminder(), notNullValue());
        assertThat(event.getReminder().getId(), is(reminder.getId()));
        assertThat(event.getDescription(), is(eventRequest.getDescription()));
    }

}
