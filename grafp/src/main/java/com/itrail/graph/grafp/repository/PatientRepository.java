package com.itrail.graph.grafp.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.itrail.graph.grafp.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

    @Query( "SELECT p FROM Patient p WHERE p.phone = :phone")
    Optional<Patient> findByPhone( String phone );
    
}
