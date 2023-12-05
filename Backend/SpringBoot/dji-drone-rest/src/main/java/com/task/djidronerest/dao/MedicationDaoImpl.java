package com.task.djidronerest.dao;

import com.task.djidronerest.entity.Drone;
import com.task.djidronerest.entity.Medication;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MedicationDaoImpl implements MedicationDao {

    private EntityManager entityManager;

    @Autowired
    public MedicationDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Medication saveMedication(Medication medication) {
        Drone drone = entityManager.find(Drone.class, medication.getDrone().getSerialNumber());
        int droneWeight = drone.getWeightLimit();
        int medicationWeight = medication.getWeight();
        for (Medication medication1 : drone.getMedications()) {
            medicationWeight += medication1.getWeight();
        }
        if (medicationWeight > droneWeight) {
            throw new RuntimeException("Drone weight limit exceeded");
        }
        drone.add(medication);
        entityManager.persist(medication);
        return medication;
    }

}
