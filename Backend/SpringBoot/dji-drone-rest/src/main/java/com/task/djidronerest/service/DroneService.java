package com.task.djidronerest.service;

import com.task.djidronerest.entity.Drone;

import java.util.List;

public interface DroneService {

    List<Drone> findAll();
    Drone saveDrone(Drone drone);
    List<Drone> findAvailable();
}
