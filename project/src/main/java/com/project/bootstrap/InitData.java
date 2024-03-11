package com.project.bootstrap;


import com.project.entities.Pharmacy;
import com.project.entities.Medicine;
import com.project.repositories.PharmacyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class InitData implements CommandLineRunner {

    private final PharmacyRepository pharmacyRepository;

    public InitData(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    @Override
    public void run(String... args) {
        // Load initial data for pharmacies
        loadInitialData();
    }

    private void loadInitialData() {
        List<Pharmacy> pharmacies = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 3; i++) { // Create 3 publishers
            Pharmacy pharmacy = Pharmacy.builder()
                    .name("Pharmacy " + (i + 1))
                    .address("Address " + (i + 1))
                    .phoneNumber(generatePhoneNumber())
                    .build();

            List<Medicine> medicines = new ArrayList<>();
            for (int j = 0; j < random.nextInt(3) + 2; j++) { // Create at least 2 books for each publisher
                Medicine medicine = Medicine.builder()
                        .name("Medicine " + (j + 1))
                        .pharmacy(pharmacy)
                        .build();
                medicines.add(medicine);
            }
            pharmacy.setMedicines(medicines);
            pharmacies.add(pharmacy);
        }

        pharmacyRepository.saveAll(pharmacies);
    }

    private String generatePhoneNumber() {
        Random random = new Random();
        StringBuilder phoneNumber = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            phoneNumber.append(random.nextInt(10));
        }
        return phoneNumber.toString();
    }
}