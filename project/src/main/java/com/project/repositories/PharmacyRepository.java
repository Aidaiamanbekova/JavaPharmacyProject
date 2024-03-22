package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.entities.Pharmacy;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, String> {
}