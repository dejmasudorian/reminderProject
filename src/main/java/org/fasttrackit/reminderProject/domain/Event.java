package org.fasttrackit.reminderProject.domain;

import javax.persistence.*;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reminder_id")
    private Reminder reminder;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", reminder=" + reminder +
                '}';
    }


}
