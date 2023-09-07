package com.itrail.graph.grafp.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import com.itrail.graph.grafp.entity.Patient;
import com.itrail.graph.grafp.repository.PatientRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final DocumentService documentService;

    public List<Patient> findAllPatient(){
        return patientRepository.findAll();
    }

    public Patient findByIdPatient( Long idPatient ){
        return patientRepository.findById( idPatient ).orElseThrow(() -> new NoSuchElementException( "Пациента с таким ИД не существует" )); 
    }

    public Patient addDocument( Patient patient ){
        if ( patientRepository.findById( patient.getIdPatient() ).isPresent() ) throw new IllegalArgumentException( "Пациент с такми ИД существует");
        if ( patientRepository.findByPhone( patient.getPhone() ).isPresent() ) throw new IllegalArgumentException( "Пациент с таким номером телефона существует");
        patient.setDocument( documentService.addDocument( patient.getDocument() ));
        return patientRepository.save( patient );
    }


    
}
