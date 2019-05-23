package org.fasttrackit.reminderProject.repository;

import org.fasttrackit.reminderProject.domain.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
