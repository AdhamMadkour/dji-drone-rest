package com.task.djidronerest.dao;

import com.task.djidronerest.entity.Drone;
import com.task.djidronerest.dao.response.BatteryDetailsReponse;

import java.util.List;

public interface DroneDao {
    Drone findById(String serialNumber);
    List<Drone> findAll();

    List<Drone> findAllWithPaginationAndSorting(int pageNumber, int pageSize, String sortBy, String sortDirection);
    Drone saveDrone(Drone drone);
    List<Drone> findAvailable();

    BatteryDetailsReponse getDroneBattery(String serialNumber);
}
