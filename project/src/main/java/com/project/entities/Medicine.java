package com.project.entities;

import jakarta.persistence.*;
import com.project.entities.Pharmacy;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Entity
@Table(name="medicine_info")
@ApiModel(description = "This table holds medicine information.")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes="This is a Medicine Id. It shall be unique.")
    private Long medicineId;

    @ApiModelProperty(notes="This is the name of the medicine.")
    private String medicineName;

    @ManyToOne
    @JoinColumn(name = "pharmacy_id", nullable = false)
    @ApiModelProperty(notes="This is the pharmacy associated with the medicine.")
    private Pharmacy pharmacy;

    public Medicine() {
    }

    public Medicine(String medicineName, Pharmacy pharmacy) {
        this.medicineName = medicineName;
        this.pharmacy = pharmacy;
    }

    public Long getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Long medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}