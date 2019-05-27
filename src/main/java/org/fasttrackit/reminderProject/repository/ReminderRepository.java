package org.fasttrackit.reminderProject.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.fasttrackit.reminderProject.domain.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {

    Page<Reminder> findByNotificationId(long notificationId, Pageable pageable);

}