package com.task.djidronerest.services;

import com.task.djidronerest.service.DroneService;
import com.task.djidronerest.service.DroneServiceImpl;
import com.task.djidronerest.service.MedicaionService;
import com.task.djidronerest.service.MedicationServiceImpl;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {

    @Bean
    public DroneService droneService() {
        return Mockito.mock(DroneServiceImpl.class);
    }

    @Bean
    public MedicaionService medicaionService() {
        return Mockito.mock(MedicationServiceImpl.class);
    }

}
