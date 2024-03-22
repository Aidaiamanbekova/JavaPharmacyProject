package com.project.services.Impl;

import com.project.exception.PharmacyNotFoundException;
import com.project.entities.Pharmacy;
import com.project.repositories.PharmacyRepository;
import com.project.services.PharmacyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyServiceImpl implements PharmacyService {

    private final PharmacyRepository pharmacyRepository;

    public PharmacyServiceImpl(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    @Override
    public String createPharmacy(Pharmacy pharmacy) {
        // More Business Logic
        pharmacyRepository.save(pharmacy);
        return "Success";
    }

    @Override
    public String updatePharmacy(Pharmacy pharmacy) {
        // More Business Logic
        pharmacyRepository.save(pharmacy);
        return "Success";
    }

    @Override
    public String deletePharmacy(String pharmacyId) {
        // More Business Logic
        pharmacyRepository.deleteById(pharmacyId);
        return "Success";
    }

    @Override
    public Pharmacy getPharmacy(String pharmacyId) {
        // More Business Logic
        return pharmacyRepository.findById(pharmacyId)
                .orElseThrow(() -> new PharmacyNotFoundException("Requested Pharmacy does not exist"));
    }

    @Override
    public List<Pharmacy> getAllPharmacies() {
        // More Business Logic
        return pharmacyRepository.findAll();
    }
}