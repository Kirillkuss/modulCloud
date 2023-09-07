package com.itrail.graph.grafp.graphQL;

import java.util.List;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import com.itrail.graph.grafp.entity.Patient;

public interface GPatient {
    
    @QueryMapping
    public List<Patient> findAllPatient();

    @QueryMapping
    public Patient findByIdPatient( @Argument Long idPatient );

    @MutationMapping
    public Patient addPatient( @Argument Patient patient );
}
