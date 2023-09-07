package com.itrail.graph.grafp.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;
import com.itrail.graph.grafp.entity.Document;
import com.itrail.graph.grafp.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DocumentService {
    
    private final DocumentRepository documentRepository;

    public List<Document> findAllDocument() {
        return documentRepository.findAll();
    }

    public Document findByIdDocument(Long idDocument ) {
        return documentRepository.findById( idDocument )
                                 .orElseThrow(() -> new NoSuchElementException( "Документа с таким ИД не существует"));
    }

    public Document addDocument( Document document ) {
        if( documentRepository.findByNumar( document.getNumar() ).isPresent() ) throw new IllegalArgumentException( "Не уникальный numar документа" );
        if( documentRepository.findByPolis( document.getSnils()).isPresent() ) throw new IllegalArgumentException( "Не уникальный snils документа" );
        if( documentRepository.findByPolis( document.getPolis() ).isPresent() ) throw new IllegalArgumentException( "Не уникальный polis документа" );
        if( documentRepository.findById( document.getIdDocument() ).isPresent() ) throw new IllegalArgumentException( "Не уникальный idDocument документа" );
        return documentRepository.save( document );
    }

}
