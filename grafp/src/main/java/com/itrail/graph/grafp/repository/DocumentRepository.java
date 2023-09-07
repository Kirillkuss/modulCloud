package com.itrail.graph.grafp.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.itrail.graph.grafp.entity.Document;


public interface DocumentRepository extends JpaRepository<Document, Long>{

    @Query( "SELECT d FROM Document d WHERE d.numar = :numar")
    Optional<Document> findByNumar( String numar );

    @Query( "SELECT d FROM Document d WHERE d.snils = :snils")
    Optional<Document> findBySnils( String snils );

    @Query( "SELECT d FROM Document d WHERE d.polis = :polis")
    Optional<Document> findByPolis( String polis );
    
}
