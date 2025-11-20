package com.marathon.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.marathon.model.Anmeldung;

public interface AnmeldungRepository extends JpaRepository<Anmeldung, Long> {}
