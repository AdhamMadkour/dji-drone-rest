package com.task.djidronerest.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "drone")
public class Drone {
    @Id
    @Column(name = "serial_number", nullable = false, length = 100)
    @Size(max = 100)
    private String serialNumber;
    @Column(name = "model", nullable = false)
    @Enumerated(EnumType.STRING)
    private Model model;

    @Column(name = "weight_limit", nullable = false)
    @Max(value = 500, message = "Weight limit must be less than 500")
    private Integer weightLimit;
    @Column(name = "battery_capacity", nullable = false)
    @Max(value = 100, message = "Battery capacity must be less than 100")
    private Integer batteryCapacity;
    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private State state;

    @OneToMany(mappedBy = "drone", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    List<Medication> medications;

    public Drone() {
    }

    public Drone(String serialNumber, Model model, Integer weightLimit, Integer batteryCapacity, State state, List<Medication> medications) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.weightLimit = weightLimit;
        this.batteryCapacity = batteryCapacity;
        this.state = state;
        this.medications = medications;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Integer getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(Integer weightLimit) {
        this.weightLimit = weightLimit;
    }

    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(Integer batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

    public void add(Medication medication) {
        if (medications == null)
            medications = new ArrayList<>();
        medications.add(medication);
        medication.setDrone(this);
    }

    @Override
    public String toString() {
        return "Drone{" +
                "serialNumber='" + serialNumber + '\'' +
                ", model=" + model +
                ", weightLimit=" + weightLimit +
                ", batteryCapacity=" + batteryCapacity +
                ", state=" + state +
                ", medications=" + medications +
                '}';
    }
}