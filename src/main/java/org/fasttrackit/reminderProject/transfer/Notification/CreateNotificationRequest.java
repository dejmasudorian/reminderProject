package org.fasttrackit.reminderProject.transfer.Notification;

import java.util.Arrays;
import java.util.Date;

public class CreateNotificationRequest {


    private String details;
    private Date reminderCreatedDate;
    private boolean importance;


    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getReminderCreatedDate() {
        return reminderCreatedDate;
    }

    public void setReminderCreatedDate(Date reminderCreatedDate) {
        this.reminderCreatedDate = reminderCreatedDate;
    }

    public boolean isImportance() {
        return importance;
    }

    public void setImportance(boolean importance) {
        this.importance = importance;
    }

    @Override
    public String toString() {
        return "CreateNotificationRequest{" +
                "details='" + details + '\'' +
                ", reminderCreatedDate=" + reminderCreatedDate +
                ", importance=" + importance +
                '}';
    }
}
