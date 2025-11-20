package com.marathon.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.marathon.model.Material;

public interface MaterialRepository extends JpaRepository<Material, Long> {}
