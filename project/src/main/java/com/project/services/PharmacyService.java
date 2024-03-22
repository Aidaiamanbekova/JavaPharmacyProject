package com.project.services;

import com.project.entities.Pharmacy;

import java.util.List;

public interface PharmacyService {
    String createPharmacy(Pharmacy pharmacy);
    String updatePharmacy(Pharmacy pharmacy);
    String deletePharmacy(String pharmacyId);
    Pharmacy getPharmacy(String pharmacyId);
    List<Pharmacy> getAllPharmacies();
}