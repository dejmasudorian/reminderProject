package org.fasttrackit.reminderProject.transfer.Notification;

import org.fasttrackit.reminderProject.domain.LevelOfImportance;

import java.util.Date;

public class CreateNotificationRequest {

    private LevelOfImportance levelOfImportance;
    private String details;
    private Date reminderCreatedDate;
    private String createdBy;


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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }


    @Override
    public String toString() {
        return "CreateNotificationRequest{" +
                "levelOfImportance=" + levelOfImportance +
                ", details='" + details + '\'' +
                ", reminderCreatedDate=" + reminderCreatedDate +
                ", createdBy='" + createdBy + '\'' +
                '}';
    }
}
