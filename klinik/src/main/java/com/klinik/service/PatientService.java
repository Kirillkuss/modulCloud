package com.klinik.service;

import com.klinik.aspect.GlobalOperation;
import com.klinik.entity.Document;
import com.klinik.entity.Patient;
import com.klinik.excep.MyException;
import com.klinik.repositories.DocumentRepository;
import com.klinik.repositories.PatientRepository;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository  patientRepository;
    private final DocumentRepository documentRepository;
    private final EntityManager      entityManager;

    @GlobalOperation(operation = "All Patients")
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    @GlobalOperation(operation = "add Patient")
    public Patient addPatient( Patient patient, Long id ) throws Exception{
        if( patientRepository.findByPhone( patient.getPhone() ) != null )  throw new MyException( 409, "Пользователь с таким номером телефона уже существует, укажите другой");
        if( patientRepository.findPatientByIdDocument( id ) != null )      throw new MyException( 400, "Неверное значение ИД документа, попробуйте другой");
        if( patientRepository.findById( patient.getIdPatient()).isPresent()) throw new MyException( 409, "Пользователь с таким ИД уже существует");
        Optional<Document> document = documentRepository.findById( id );
        if( document.isEmpty()) throw new MyException( 400, "Документ с таким ИД не существует");
        patient.setDocument( document.get() );
        return patientRepository.save( patient );
    }

    @GlobalOperation(operation = "findByWord Patient")
    public List<Patient> findByWord( String word ) throws Exception{
        List<Patient> response = patientRepository.findPatientByWord( word );
        if ( response.isEmpty() == true ) throw new MyException( 404, "По данному запросу ничего не найдено");
        return response;
    }

    @GlobalOperation(operation = "getLazyLoad Patients")
    @SuppressWarnings("unchecked")
    public List<Patient> getLazyLoad( int page, int size){
        List<Patient> response =  entityManager.createNativeQuery( "select * from Patient", Patient.class)
                                               .setFirstResult((page - 1) * size)
                                               .setMaxResults(size)
                                               .getResultList();
        return response;                       
    }

}
