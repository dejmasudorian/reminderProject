package org.fasttrackit.reminderProject.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.fasttrackit.reminderProject.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

    Page<Event> findByReminderId(long reminderId, Pageable pageable);
}
