package com.task.djidronerest.service;

import com.task.djidronerest.dao.BatteryDetailsReponse;
import com.task.djidronerest.dao.DroneDao;
import com.task.djidronerest.entity.Drone;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Primary
public class DroneServiceImpl implements DroneService {
    private DroneDao droneDao;

    public DroneServiceImpl(DroneDao droneDao) {
        this.droneDao = droneDao;
    }


    @Transactional
    @Override
    public Drone saveDrone(Drone drone) {
        return droneDao.saveDrone(drone);
    }

    @Override
    public List<Drone> findAvailable() {
        return droneDao.findAvailable();
    }

    @Override
    public BatteryDetailsReponse getDroneBattery(String serialNumber) {
        return droneDao.getDroneBattery(serialNumber);
    }

    @Override
    public Drone findById(String serialNumber) {
        return droneDao.findById(serialNumber);
    }

    @Override
    public List<Drone> findAll() {
        return droneDao.findAll();
    }

    @Override
    public List<Drone> findAllWithPaginationAndSorting(int pageNumber, int pageSize, String sortBy, String sortDirection) {
        return droneDao.findAllWithPaginationAndSorting(pageNumber, pageSize, sortBy, sortDirection);
    }

}
