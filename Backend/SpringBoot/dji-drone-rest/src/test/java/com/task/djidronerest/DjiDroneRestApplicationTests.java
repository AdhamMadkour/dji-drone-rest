package com.task.djidronerest;

import com.task.djidronerest.dao.response.BatteryDetailsReponse;
import com.task.djidronerest.entity.Drone;
import com.task.djidronerest.entity.Medication;
import com.task.djidronerest.entity.enums.Model;
import com.task.djidronerest.entity.enums.State;
import com.task.djidronerest.service.DroneService;
import com.task.djidronerest.service.MedicaionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DjiDroneRestApplicationTests {
    @Autowired
    private DroneService droneService;

    @Autowired
    private MedicaionService medicaionService;

    @Test
    void contextLoads() {
    }

    @Test
    void testGetAllDrones() {
        List<Drone> drones = droneService.findAll();
        int nonEmptyDrones = 0;
        assertNotNull(drones, "This list should not be empty");
        for (Drone drone : drones) {
            if (drone.getSerialNumber() != null) {
                nonEmptyDrones++;
            }
        }
        assertEquals(drones.size(), nonEmptyDrones);
    }

    @Test
    public void testSaveDrone() {
        Drone drone = new Drone();
        drone.setSerialNumber("DJI0004");
        drone.setBatteryCapacity(100);
        drone.setWeightLimit(250);
        drone.setState(State.IDLE);
        drone.setModel(Model.Cruiserweight);
        droneService.saveDrone(drone);
        List<Drone> drones = droneService.findAll();
        assertTrue(
                drones.stream().anyMatch(d -> d.getSerialNumber().equals("DJI0004")),
                "Drone with serial number DJI0004 should be in the list"
        );
    }

    @Test
    public void testFindAvailable() {
        List<Drone> drones = droneService.findAvailable();
        assertNotNull(drones, "This list should not be empty");
        for (Drone drone : drones) {
            assertEquals(State.IDLE, drone.getState());
        }
    }

    @Test
    public void testGetDroneBattery() {
        BatteryDetailsReponse batteryDetailsReponse = droneService.getDroneBattery("DJI0004");
        Drone drone = droneService.findById("DJI0004");
        assertNotNull(batteryDetailsReponse, "This list should not be empty");
        assertEquals("DJI0004", batteryDetailsReponse.getSerialNumber());
        assertEquals(batteryDetailsReponse.getBatteryPercentage(), drone.getBatteryCapacity());
    }

    @Test
    public void testGetDroneBatteryNotFound() {
        assertThrows(
                RuntimeException.class,
                () -> droneService.getDroneBattery("IamNotADrone"),
                "Drone with serial number IamNotADrone not found"
        );
    }

    @Test
    public void testSaveDroneLowBattery() {
        Drone drone = new Drone();
        drone.setSerialNumber("DJI0005");
        drone.setBatteryCapacity(20);
        drone.setWeightLimit(250);
        drone.setState(State.LOADING);
        drone.setModel(Model.Cruiserweight);
        assertThrows(
                RuntimeException.class,
                () -> droneService.saveDrone(drone),
                "Drone with serial number DJI0005 has low battery"
        );
    }

    @Test
    public void testSaveDroneLowBatteryNotLoading() {
        Drone drone = new Drone();
        drone.setSerialNumber("DJI0005");
        drone.setBatteryCapacity(20);
        drone.setWeightLimit(250);
        drone.setState(State.IDLE);
        drone.setModel(Model.Cruiserweight);
        droneService.saveDrone(drone);
        List<Drone> drones = droneService.findAll();
        assertTrue(
                drones.stream().anyMatch(d -> d.getSerialNumber().equals("DJI0005")),
                "Drone with serial number DJI0005 should be in the list"
        );
    }

    @Test
    public void testSaveMedicationtoDrone() {
        Medication medication = new Medication();
        medication.setName("Paracetamol");
        medication.setWeight(0);
        medication.setCode("PCT");
        medication.setImage("paracetamol.jpg");
        Drone drone = droneService.findById("DJI0004");
        medication.setDrone(drone);
        Medication medicationService = medicaionService.saveMedication(medication);
        drone.getMedications().add(medicationService);
        List<Drone> drones = droneService.findAll();
        Drone drone1 = drones.stream().filter(d -> d.getSerialNumber().equals("DJI0004")).findFirst().get();
        assert (
                drone1.getMedications().stream().anyMatch(m -> m.getCode().equals("PCT"))
        );
    }

    @Test
    public void testSaveMedicationtoDroneNotFound() {
        Medication medication = new Medication();
        medication.setName("Paracetamol");
        medication.setWeight(10);
        medication.setCode("PCT");
        medication.setImage("paracetamol.jpg");
        Drone drone = new Drone();
        drone.setSerialNumber("IamNotADrone");
        medication.setDrone(drone);
        assertThrows(
                RuntimeException.class,
                () -> medicaionService.saveMedication(medication),
                "Drone with serial number IamNotADrone not found"
        );
    }

    @Test
    public void testSaveMedicationtoDroneLowBattery() {
        Medication medication = new Medication();
        medication.setName("Paracetamol");
        medication.setWeight(10);
        medication.setCode("PCT");
        medication.setImage("paracetamol.jpg");
        Drone drone = droneService.findById("DJI0005");
        medication.setDrone(drone);
        assertThrows(
                RuntimeException.class,
                () -> medicaionService.saveMedication(medication),
                "Drone with serial number DJI0005 has low battery"
        );
    }

    @Test
    public void testOverLoadMedicationToDrone() {
        Medication medication = new Medication();
        medication.setName("Paracetamol");
        medication.setWeight(10000);
        medication.setCode("PCT");
        medication.setImage("paracetamol.jpg");
        Drone drone = droneService.findById("DJI0004");
        medication.setDrone(drone);
        assertThrows(
                RuntimeException.class,
                () -> medicaionService.saveMedication(medication),
                "Drone with serial number DJI0004 is overloaded"
        );
    }
}
