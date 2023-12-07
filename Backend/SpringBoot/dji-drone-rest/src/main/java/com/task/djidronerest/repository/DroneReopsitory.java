package com.task.djidronerest.repository;

import com.task.djidronerest.entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneReopsitory extends JpaRepository<Drone, String> {
}
