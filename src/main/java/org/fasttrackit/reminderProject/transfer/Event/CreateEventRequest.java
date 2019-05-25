package org.fasttrackit.reminderProject.transfer.Event;

public class CreateEventRequest {

    private long reminderId;
    private String description;

    public long getReminderId() {
        return reminderId;
    }

    public void setReminderId(long reminderId) {
        this.reminderId = reminderId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CreateEventRequest{" +
                "reminderId=" + reminderId +
                ", description='" + description + '\'' +
                '}';
    }
}
