package com.RNE.demande.services;

import java.util.List;
import com.RNE.demande.entities.Documents;

public interface DocumentService {
	
	  Documents saveDocument(Documents documents);

	    List<Documents> getAllDocuments();

	    Documents getDocumentsById(Long id);

	    void deleteDocuments(Long id);

}
