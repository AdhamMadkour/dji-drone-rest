package com.task.djidronerest.dao;

import com.task.djidronerest.entity.Drone;
import com.task.djidronerest.entity.enums.State;
import com.task.djidronerest.dao.response.BatteryDetailsReponse;
import com.task.djidronerest.exception.DroneBatteryLowException;
import com.task.djidronerest.exception.DroneNotFoundException;
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
    public Drone findById(String serialNumber) {
        Drone drone = entityManager.find(Drone.class, serialNumber);
        if (drone == null) {
            throw new DroneNotFoundException("Drone with serial number " + serialNumber + " not found");
        }
        return drone;
    }

    @Override
    public List<Drone> findAll() {
        List<Drone> drones = entityManager.createQuery("FROM Drone", Drone.class).getResultList();
        return drones;
    }

    @Override
    public List<Drone> findAllWithPaginationAndSorting(int pageNumber, int pageSize, String sortBy, String sortDirection) {
        String queryString = "FROM Drone";
        if (sortBy != null && sortDirection != null) {
            queryString += " ORDER BY " + sortBy + " " + sortDirection;
        }
        List<Drone> drones = entityManager.createQuery(queryString, Drone.class)
                .setFirstResult((pageNumber - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
        return drones;
    }

    @Override
    public Drone saveDrone(Drone drone) {
        if (drone.getBatteryCapacity() < 25 && drone.getState() == State.LOADING) {
            throw new DroneBatteryLowException("Drone battery is low" + drone.getBatteryCapacity() + "% it should be more than 25%");
        }
        entityManager.merge(drone);
        return drone;
    }

    @Override
    public List<Drone> findAvailable() {
        List<Drone> drones = entityManager.createQuery("FROM Drone WHERE state = 'IDLE'", Drone.class).getResultList();
        return drones;
    }

    @Override
    public BatteryDetailsReponse getDroneBattery(String serialNumber) {
        Drone drone = entityManager.find(Drone.class, serialNumber);
        if (drone == null) {
            throw new DroneNotFoundException("Drone with serial number " + serialNumber + " not found");
        }
        BatteryDetailsReponse batteryDetailsReponse = new BatteryDetailsReponse();
        batteryDetailsReponse.setSerialNumber(drone.getSerialNumber());
        batteryDetailsReponse.setBatteryPercentage(drone.getBatteryCapacity());
        return batteryDetailsReponse;
    }
}
