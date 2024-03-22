package com.project.mappers;


import com.project.dto.MedicineDTO;
import com.project.entities.Medicine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MedicineMapper {

    Medicine medicineDtoToMedicine(MedicineDTO dto);

    @Mapping(target = "pharmacy", ignore = true)
    MedicineDTO medicineToMedicineDto(Medicine medicine);


}