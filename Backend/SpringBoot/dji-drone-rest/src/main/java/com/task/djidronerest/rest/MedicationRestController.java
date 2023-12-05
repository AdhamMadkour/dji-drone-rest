package com.task.djidronerest.rest;

import com.task.djidronerest.entity.Medication;
import com.task.djidronerest.service.MedicaionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MedicationRestController {
    private MedicaionService medicationService;

    @Autowired
    public MedicationRestController(MedicaionService medicationService) {
        this.medicationService = medicationService;
    }

    @PostMapping("/medication")
    public Medication saveMedication(@RequestBody Medication medication) {
        System.out.println("MedicationRestController.saveMedication: " + medication);
        return medicationService.saveMedication(medication);
    }
}
