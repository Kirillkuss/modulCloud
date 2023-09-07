package com.itrail.graph.grafp.controller;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.itrail.graph.grafp.entity.Doctor;
import com.itrail.graph.grafp.graphQL.GDoctor;
import com.itrail.graph.grafp.repository.DoctorRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class DoctorController implements GDoctor {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> findAllDoctors() {
        log.info( "find All Doctors");
        return doctorRepository.findAll();
    }

    @Override
    public Doctor findByIdDoctor( Long idDoctor ) {
        log.info( "fing by ID");
        return doctorRepository.findById( idDoctor )
                               .orElseThrow(() -> new  NoSuchElementException("Доктора с таким ид не существует"));
    }

    @Override
    public Doctor addDoctor( Doctor doctor ) {
        log.info( "Add Doctor");
        if( doctorRepository.findById( doctor.getIdDoctor() ).isPresent() ) throw new IllegalArgumentException( "Доктор с таким ИД Уже существует");
        return doctorRepository.save( doctor );
    }

    

}
