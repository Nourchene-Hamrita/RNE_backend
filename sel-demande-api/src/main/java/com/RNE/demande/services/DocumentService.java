package com.RNE.demande.services;

import java.util.List;
import com.RNE.demande.entities.Documents;

public interface DocumentService {

	public Documents saveDocument(Documents documents);

	public List<Documents> getAllDocuments();

	public Documents getDocumentsById(Long id);

	public void deleteDocuments(Long id);

}
