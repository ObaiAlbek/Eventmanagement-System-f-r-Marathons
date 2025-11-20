package com.marathon.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.marathon.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {}
