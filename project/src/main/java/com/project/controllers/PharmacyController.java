package com.project.controllers;


import com.project.services.PharmacyService;
import com.project.response.ResponseHandler;
import com.project.entities.Pharmacy;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pharmacy")
public class PharmacyController {

    private final PharmacyService pharmacyService;

    public PharmacyController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    // Read Specific Pharmacy Details from DB
    @GetMapping("/{pharmacyId}")
    @ApiOperation(value ="Pharmacy id", notes="Provide pharmacy details",
            response = ResponseEntity.class)
    public ResponseEntity<Object> getPharmacyDetails(@PathVariable("pharmacyId") String pharmacyId) {
        return ResponseHandler.responseBuilder("Requested Pharmacy Details are given here",
                HttpStatus.OK, pharmacyService.getPharmacy(pharmacyId));
    }

    // Read All Pharmacy Details from DB
    @GetMapping("/")
    public List<Pharmacy> getAllPharmacyDetails() {
        return pharmacyService.getAllPharmacies();
    }

    @PostMapping("/")
    public String createPharmacyDetails(@RequestBody Pharmacy pharmacy) {
        pharmacyService.createPharmacy(pharmacy);
        return "Pharmacy Created Successfully";
    }

    @PutMapping("/")
    public String updatePharmacyDetails(@RequestBody Pharmacy pharmacy) {
        pharmacyService.updatePharmacy(pharmacy);
        return "Pharmacy Updated Successfully";
    }

    @DeleteMapping("/{pharmacyId}")
    public String deletePharmacyDetails(@PathVariable("pharmacyId") String pharmacyId) {
        pharmacyService.deletePharmacy(pharmacyId);
        return "Pharmacy Deleted Successfully";
    }
}
