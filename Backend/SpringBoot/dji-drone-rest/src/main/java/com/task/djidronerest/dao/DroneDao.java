package com.task.djidronerest.dao;

import com.task.djidronerest.entity.Drone;
import org.apache.tomcat.util.json.JSONParser;

import java.util.List;

public interface DroneDao {
    Drone findById(String serialNumber);
    List<Drone> findAll();
    Drone saveDrone(Drone drone);
    List<Drone> findAvailable();

    BatteryDetailsReponse getDroneBattery(String serialNumber);
}
