package com.task.djidronerest.rest;

import com.task.djidronerest.entity.Medication;
import com.task.djidronerest.service.MedicaionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(
        name = "Medication API",
        description = "Provides a list of medications and allows to add new medications"
)
public class MedicationRestController {
    private MedicaionService medicationService;

    @Autowired
    public MedicationRestController(MedicaionService medicationService) {
        this.medicationService = medicationService;
    }

    @PostMapping("/medication")
    @Operation(
            summary = "Add a new medication",
            description = "Add a new medication"
    )
    public Medication saveMedication(@RequestBody Medication medication) {
        System.out.println("MedicationRestController.saveMedication: " + medication);
        return medicationService.saveMedication(medication);
    }
}
