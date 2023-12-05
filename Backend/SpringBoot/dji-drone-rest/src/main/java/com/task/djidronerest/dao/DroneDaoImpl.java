package com.task.djidronerest.dao;

import com.task.djidronerest.entity.Drone;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class DroneDaoImpl implements DroneDao {
    private EntityManager entityManager;

    @Autowired
    public DroneDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Drone> findAll() {
        List<Drone> drones = entityManager.createQuery("FROM Drone", Drone.class).getResultList();
        return drones;
    }

    @Override
    public Drone saveDrone(Drone drone) {
        Drone droneDb = entityManager.merge(drone);
        return drone;
    }

    @Override
    public List<Drone> findAvailable() {
        List<Drone> drones = entityManager.createQuery("FROM Drone WHERE state = 0", Drone.class).getResultList();
        return drones;
    }
}
