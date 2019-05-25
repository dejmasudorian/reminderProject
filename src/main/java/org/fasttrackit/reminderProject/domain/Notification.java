package org.fasttrackit.reminderProject.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String details;
    private Date reminderCreatedDate;
    private LevelOfImportance importance;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LevelOfImportance getImportance() {
        return importance;
    }

    public void setImportance(LevelOfImportance importance) {
        this.importance = importance;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", details='" + details + '\'' +
                ", reminderCreatedDate=" + reminderCreatedDate +
                ", importance=" + importance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
