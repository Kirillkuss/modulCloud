package com.itrail.graph.grafp.graphQL;

import java.util.List;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import com.itrail.graph.grafp.entity.Document;

public interface GDocument {
    
    @QueryMapping
    public List<Document> findAllDocument();

    @QueryMapping
    public Document findByIdDocument( @Argument Long idDocument);

    @MutationMapping
    public Document addDocument( @Argument Document document );
}
