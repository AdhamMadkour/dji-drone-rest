package com.task.djidronerest.dao;

import com.task.djidronerest.entity.Drone;

import java.util.List;

public interface DroneDao {
    List<Drone> findAll();
    Drone saveDrone(Drone drone);
}
