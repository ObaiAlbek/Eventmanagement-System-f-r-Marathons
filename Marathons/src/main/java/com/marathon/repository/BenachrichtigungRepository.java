package com.marathon.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.marathon.model.Benachrichtigung;

public interface BenachrichtigungRepository extends JpaRepository<Benachrichtigung, Long> {}
