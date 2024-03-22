package com.project.entities;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name="pharmacy_info")
@ApiModel(description = "This table holds pharmacy information.")
public class Pharmacy {
    @Id
    @ApiModelProperty(notes="This is a Pharmacy Id. It shall be unique.")
    private String pharmacyId;

    @ApiModelProperty(notes="This is the name of the pharmacy.")
    private String pharmacyName;

    @ApiModelProperty(notes="This is the address of the pharmacy.")
    private String pharmacyAddress;

    @ApiModelProperty(notes="This is the phone number of the pharmacy.")
    private String pharmacyPhoneNumber;

    public Pharmacy() {
    }

    public Pharmacy(String pharmacyId, String pharmacyName, String pharmacyAddress, String pharmacyPhoneNumber) {
        this.pharmacyId = pharmacyId;
        this.pharmacyName = pharmacyName;
        this.pharmacyAddress = pharmacyAddress;
        this.pharmacyPhoneNumber = pharmacyPhoneNumber;
    }

    public String getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(String pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getPharmacyAddress() {
        return pharmacyAddress;
    }

    public void setPharmacyAddress(String pharmacyAddress) {
        this.pharmacyAddress = pharmacyAddress;
    }

    public String getPharmacyPhoneNumber() {
        return pharmacyPhoneNumber;
    }

    public void setPharmacyPhoneNumber(String pharmacyPhoneNumber) {
        this.pharmacyPhoneNumber = pharmacyPhoneNumber;
    }

    @OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL)
    private List<Medicine> medicines;
}