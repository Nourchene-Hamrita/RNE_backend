package com.RNE.demande.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.RNE.demande.entities.Documents;
import com.RNE.demande.repositories.DocumentRepository;
import com.RNE.demande.services.DocumentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DocumentServiceImpl implements DocumentService{

	private DocumentRepository documentRepository;
	
	@Override
	public Documents saveDocument(Documents documents) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Documents> getAllDocuments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Documents getDocumentsById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteDocuments(Long id) {
		// TODO Auto-generated method stub
		
	}

}
