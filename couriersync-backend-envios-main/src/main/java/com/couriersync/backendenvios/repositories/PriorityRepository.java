package com.couriersync.backendenvios.repositories;

import com.couriersync.backendenvios.entities.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PriorityRepository extends JpaRepository<Priority, Integer> {
    Optional<Priority> findByName(String name);
}
