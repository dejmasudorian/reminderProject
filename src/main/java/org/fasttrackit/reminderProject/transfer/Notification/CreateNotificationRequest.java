package org.fasttrackit.reminderProject.transfer.Notification;

import org.fasttrackit.reminderProject.domain.LevelOfImportance;

import java.util.Date;

public class CreateNotificationRequest {

    private long reminderId;
    private LevelOfImportance levelOfImportance;
    private String details;
    private Date reminderCreatedDate;

    public long getReminderId() {
        return reminderId;
    }

    public void setReminderId(long reminderId) {
        this.reminderId = reminderId;
    }

    public LevelOfImportance getLevelOfImportance() {
        return levelOfImportance;
    }

    public void setLevelOfImportance(LevelOfImportance levelOfImportance) {
        this.levelOfImportance = levelOfImportance;
    }

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




    @Override
    public String toString() {
        return "CreateNotificationRequest{" +
                "reminderId=" + reminderId +
                ", levelOfImportance=" + levelOfImportance +
                ", details='" + details + '\'' +
                ", reminderCreatedDate=" + reminderCreatedDate +
                '}';
    }
}
