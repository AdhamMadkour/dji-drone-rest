package com.task.djidronerest.service;

import com.task.djidronerest.dao.DroneDao;
import com.task.djidronerest.entity.Drone;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
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
    public List<Drone> findAll() {
        return droneDao.findAll();
    }
}
