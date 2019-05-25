package org.fasttrackit.reminderProject.repository;

import org.fasttrackit.reminderProject.domain.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
}
