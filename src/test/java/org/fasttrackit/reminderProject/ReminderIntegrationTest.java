package org.fasttrackit.reminderProject;

import org.fasttrackit.reminderProject.Steps.ReminderSteps;
import org.fasttrackit.reminderProject.domain.Reminder;
import org.fasttrackit.reminderProject.exception.ResourceNotFoundException;
import org.fasttrackit.reminderProject.service.ReminderService;
import org.fasttrackit.reminderProject.transfer.Reminder.UpdateReminderRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReminderIntegrationTest {


    @Autowired
    private ReminderService service;

    @Autowired
    private ReminderSteps reminderSteps;

    @Test
    public void testCreateReminder_whenValidRequest_thenReturnReminderWithId() throws ParseException {
        Reminder reminder = reminderSteps.createReminder();

        assertThat(reminder, notNullValue());
        assertThat(reminder.getId(), greaterThan(0L));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testGetReminder_whenReminderNotFound_thenThrowResourceNotFoundException() throws ResourceNotFoundException {
        service.getReminder(0);
    }


    @Test
    public void testUpdateReminder_whenValidRequestWithAllFields_thenReturnUpdatedReminder() throws ResourceNotFoundException, ParseException {
        Reminder createdReminder = reminderSteps.createReminder();

        UpdateReminderRequest request = new UpdateReminderRequest();
        request.setTitle(createdReminder.getTitle() + "_Edited");
        request.setRemindDate(createdReminder.getRemindDate());

        Reminder updatedReminder =
                service.updateReminder(createdReminder.getId(), request);

        assertThat(updatedReminder.getTitle(), is(request.getTitle()));
        assertThat(updatedReminder.getTitle(), not(is(createdReminder.getTitle())));

        assertThat(updatedReminder.getRemindDate(), is(request.getRemindDate()));

        assertThat(updatedReminder.getId(), is(createdReminder.getId()));
    }

    // todo: Implement negative tests for update and tests for update with some fields only

    @Test(expected = ResourceNotFoundException.class)
    public void testDeleteProduct_whenExistingId_thenProductIsDeleted() throws ResourceNotFoundException, ParseException {
        Reminder createdReminder = reminderSteps.createReminder();


        service.deleteReminder(createdReminder.getId());
        service.getReminder(createdReminder.getId());
    }


}
