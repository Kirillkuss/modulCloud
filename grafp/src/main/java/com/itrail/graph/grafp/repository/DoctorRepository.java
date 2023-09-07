package com.itrail.graph.grafp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.itrail.graph.grafp.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long>{
    
}
