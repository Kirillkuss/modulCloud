package com.itrail.graph.grafp.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;
import com.itrail.graph.grafp.entity.Doctor;

@Disabled
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureGraphQlTester
@DisplayName("Этот класс преднахначен для тестирования контролера DoctorController")
public class DoctorControllerTest {

    @Autowired
    private GraphQlTester tester;

    @Test
    @DisplayName("Поиск доктора по ИД")
    public void testFindByIdDocument(){
        String query = "{ findByIdDoctor( idDoctor:1){ idDoctor surname name fullName }}";
        Doctor doctor = tester.document( query )
                              .execute()
                              .path("data.findByIdDoctor")
                              .entity( Doctor.class)
                              .get();
        assertNotNull( doctor.toString() );
    }

    @Test
    @DisplayName("Поиск всех документов")
    public void testFindAllDoctor(){
        String query = "{ findAllDoctors{ idDoctor surname name fullName }}";
        List<Doctor> listDoctor = tester.document( query )
                                        .execute()
                                        .path("data.findAllDoctors[*]")
                                        .entityList( Doctor.class)
                                        .get();
        assertFalse( listDoctor.isEmpty());
    }

    @Test
    @DisplayName("Добавить пользователя")
    public void testAddDoctor(){
        String query = "mutation { addDoctor( doctor:{ idDoctor: 14, surname: \"Graph\", name: \"Graph\", fullName: \"Graph\" } ) { idDoctor, surname, name, fullName}}";
        Doctor doctor = tester.document( query )
                              .execute()
                              .path("data.addDoctor")
                              .entity( Doctor.class)
                              .get();
        assertNotNull( doctor );
    }
    
}
