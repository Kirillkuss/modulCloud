package com.itrail.graph.grafp.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import com.itrail.graph.grafp.entity.Document;
import com.itrail.graph.grafp.graphQL.GDocument;
import com.itrail.graph.grafp.service.DocumentService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DocumentController implements GDocument{

    private final DocumentService documentService;
    
    @Override
    public List<Document> findAllDocument() {
        return documentService.findAllDocument();
    }

    @Override
    public Document findByIdDocument(Long idDocument ) {
        return documentService.findByIdDocument( idDocument );
    }

    @Override
    public Document addDocument( Document document ) {
        return documentService.addDocument( document );
    }
}
