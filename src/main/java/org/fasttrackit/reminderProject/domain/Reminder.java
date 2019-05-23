package org.fasttrackit.reminderProject.domain;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private Date remindDate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getRemindDate() {
        return remindDate;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", remindDate=" + remindDate +
                '}';
    }

    public void setRemindDate(Date remind_Date) {
        this.remindDate = remind_Date;


    }
}
