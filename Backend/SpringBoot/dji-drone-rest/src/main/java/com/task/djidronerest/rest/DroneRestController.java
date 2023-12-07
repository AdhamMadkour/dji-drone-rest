package com.task.djidronerest.rest;

import com.task.djidronerest.dao.BatteryDetailsReponse;
import com.task.djidronerest.entity.Drone;
import com.task.djidronerest.service.DroneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(
        name = "Drone API",
        description = "Provides a list of drones and their battery details and allows to add new drones"
)
public class DroneRestController {
    private DroneService droneService;

    @Autowired
    public DroneRestController(DroneService droneService) {
        this.droneService = droneService;
    }

//    @GetMapping("/drone")
//    @Operation(
//            summary = "Get all drones and the medication they are carrying",
//            description = "Get all drones and the medication they are carrying"
//    )
//    public java.util.List<Drone> findAll() {
//        return droneService.findAll();
//    }

    @GetMapping("/drone")
    @Operation(
            summary = "Get all drones and the medication they are carrying with pagination and sorting",
            description = "Get all drones and the medication they are carrying with pagination and sorting"
    )
    public java.util.List<Drone> findAllWithPaginationAndSorting(
            @RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "serialNumber") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection
    ) {
        return droneService.findAllWithPaginationAndSorting(pageNumber, pageSize, sortBy, sortDirection);
    }

    @PostMapping("/drone")
    @Operation(
            summary = "Add a new drone",
            description = "Add a new drone"
    )
    public Drone saveDrone(@RequestBody Drone drone) {
        return droneService.saveDrone(drone);
    }

    @GetMapping("/available")
    @Operation(
            summary = "Get all available drones",
            description = "Get all available drones"
    )
    public java.util.List<Drone> findAvailable() {
        return droneService.findAvailable();
    }

    @GetMapping("/dronebattery/{serialNumber}")
    @Operation(
            summary = "Get the battery details of a drone",
            description = "Get the battery details of a drone"
    )
    public BatteryDetailsReponse getDroneBattery(@PathVariable String serialNumber) {
        return droneService.getDroneBattery(serialNumber);
    }

    @GetMapping("/drone/{serialNumber}")
    @Operation(
            summary = "Get a drone and the medication it is carrying",
            description = "Get a drone and the medication it is carrying"
    )
    public Drone getDroneMedication(@PathVariable String serialNumber) {
        return droneService.findById(serialNumber);
    }
}
