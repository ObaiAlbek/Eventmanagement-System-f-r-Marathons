package com.marathon.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.marathon.model.Nutzer;

public interface NutzerRepository extends JpaRepository<Nutzer, Long> {}
