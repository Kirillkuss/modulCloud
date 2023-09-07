package com.itrail.graph.grafp.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import com.itrail.graph.grafp.entity.Patient;
import com.itrail.graph.grafp.graphQL.GPatient;
import com.itrail.graph.grafp.service.PatientService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PatientController implements GPatient{

    private final PatientService patientService;
    
    @Override
    public List<Patient> findAllPatient() {
        return patientService.findAllPatient();
    }

    @Override
    public Patient findByIdPatient( Long idPatient ) {
        return patientService.findByIdPatient( idPatient );
    }

    @Override
    public Patient addPatient( Patient patient) {
        return patientService.addDocument(patient);
    }

}
