package com.task.djidronerest.service;

import com.task.djidronerest.dao.MedicationDao;
import com.task.djidronerest.entity.Medication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.PrivateKey;

@Service
public class MedicationServiceImpl implements MedicaionService {
    private MedicationDao medicationDao;

    public MedicationServiceImpl(MedicationDao medicationDao) {
        this.medicationDao = medicationDao;
    }

    @Transactional
    @Override
    public Medication saveMedication(Medication medication) {
        System.out.println("MedicationServiceImpl.saveMedication: " + medication);
        return medicationDao.saveMedication(medication);
    }
}
