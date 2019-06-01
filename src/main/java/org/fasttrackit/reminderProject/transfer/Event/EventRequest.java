package org.fasttrackit.reminderProject.transfer.Event;

import java.util.Date;

public class EventRequest {

    private String name;
    private String location;
    private String description;
    private Date dateEvent;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(Date dateEvent) {
        this.dateEvent = dateEvent;
    }

    @Override
    public String toString() {
        return "EventRequest{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", dateEvent=" + dateEvent +
                '}';
    }
}
