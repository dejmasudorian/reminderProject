package org.fasttrackit.reminderProject.transfer.Reminder;

import java.util.Date;

public class UpdateReminderRequest {

    private String title;

    private Date remindDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getRemindDate() {
        return remindDate;
    }

    public void setRemindDate(Date remindDate) {
        this.remindDate = remindDate;
    }


    @Override
    public String toString() {
        return "CreateReminderRequest{" +
                "title='" + title + '\'' +
                ", remindDate=" + remindDate +
                '}';
    }
}
