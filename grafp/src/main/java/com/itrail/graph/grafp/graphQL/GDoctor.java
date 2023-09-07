package com.itrail.graph.grafp.graphQL;

import java.util.List;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import com.itrail.graph.grafp.entity.Doctor;

public interface GDoctor {

    @QueryMapping
    public List<Doctor> findAllDoctors();

    @QueryMapping
    public Doctor findByIdDoctor(@Argument Long idDoctor );

    @MutationMapping
    public Doctor addDoctor( @Argument Doctor doctor);

}
