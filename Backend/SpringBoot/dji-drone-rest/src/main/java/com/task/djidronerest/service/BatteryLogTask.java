package com.task.djidronerest.service;

import com.task.djidronerest.entity.Drone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BatteryLogTask implements Runnable {

    private DroneService droneService;

    @Autowired
    public BatteryLogTask(DroneService droneService) {
        this.droneService = droneService;
    }

    @Scheduled(fixedRate = 10000)
    @Override
    public void run() {
        List<Drone> drones = droneService.findAll();
        for (Drone drone : drones) {
            int battery = drone.getBatteryCapacity();
            System.out.println("Battery capacity for drone " + drone.getSerialNumber() + " is " + battery);
        }
    }
}
