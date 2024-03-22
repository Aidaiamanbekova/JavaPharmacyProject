package com.project.mappers;


import com.project.dto.PharmacyDTO;
import com.project.entities.Pharmacy;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface PharmacyMapper {

    @Mapping(target = "medicines", ignore = true)
    Pharmacy pharmacyDtoToPharmacy(PharmacyDTO dto);

    @InheritInverseConfiguration
    PharmacyDTO pharmacyToPharmacyDto(Pharmacy pharmacy);


}