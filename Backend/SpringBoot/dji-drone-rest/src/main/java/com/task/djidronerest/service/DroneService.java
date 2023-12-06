package com.task.djidronerest.service;

import com.task.djidronerest.dao.BatteryDetailsReponse;
import com.task.djidronerest.entity.Drone;

import java.util.List;

public interface DroneService {
    Drone findById(String serialNumber);
    List<Drone> findAll();

    Drone saveDrone(Drone drone);
    List<Drone> findAvailable();

    BatteryDetailsReponse getDroneBattery(String serialNumber);

}
