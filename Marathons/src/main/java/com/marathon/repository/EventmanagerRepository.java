package com.marathon.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.marathon.model.Eventmanager;

public interface EventmanagerRepository extends JpaRepository<Eventmanager, Long> {}
