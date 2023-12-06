package com.task.djidronerest.rest;

import com.task.djidronerest.dao.BatteryDetailsReponse;
import com.task.djidronerest.entity.Drone;
import com.task.djidronerest.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DroneRestController {
    private DroneService droneService;

    @Autowired
    public DroneRestController(DroneService droneService) {
        this.droneService = droneService;
    }

    @GetMapping("/drone")
    public java.util.List<Drone> findAll() {
        return droneService.findAll();
    }

    @PostMapping("/drone")
    public Drone saveDrone(@RequestBody Drone drone) {
        return droneService.saveDrone(drone);
    }

    @GetMapping("/available")
    public java.util.List<Drone> findAvailable() {
        return droneService.findAvailable();
    }

    @GetMapping("/dronebattery/{serialNumber}")
    public BatteryDetailsReponse getDroneBattery(@PathVariable String serialNumber) {
        return droneService.getDroneBattery(serialNumber);
    }

    @GetMapping("/drone/{serialNumber}")
    public Drone getDroneMedication(@PathVariable String serialNumber) {
        return droneService.findById(serialNumber);
    }
}
