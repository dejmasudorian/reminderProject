package org.fasttrackit.reminderProject.domain;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Reminder {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String title;

    private Date remindDate;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "notificationId")
    private Notification notification;


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

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Date getRemindDate() {
        return remindDate;
    }

    public void setRemindDate(Date remind_Date) {
        this.remindDate = remind_Date; }

    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", remindDate=" + remindDate +
                ", notification=" + notification +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reminder reminder = (Reminder) o;
        return id == reminder.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}