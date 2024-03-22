package com.RNE.referentiel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.entities.Status;

import com.RNE.referentiel.repositories.StatusRepository;

import com.RNE.referentiel.serviceInterface.StatusService;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StatusServiceImpl implements StatusService {
   
	private StatusRepository statutRepository;
	
	
	//save statut service
	@Override
	public Status saveStatut(Status statut) {
		
		return statutRepository.save(statut) ;
	}

    //get statut by code service
	@Override
	public  Status getStatutByCode(String statusCode) {
		Optional<Status> existStatut =statutRepository.findById(statusCode);
		return existStatut.get();
	}
    // get all statut services
	@Override
	public List<Status> getAllStatut() {
		
		return statutRepository.findAll();
	}
   //update statut service
	@Override
	public Status updateStatut(String statusCode, Status statut) {
		Status existStatut=statutRepository.findById(statusCode).orElse(null);
		existStatut.setStatutTtitle(statut.getStatutTtitle());
		existStatut.setDescription(statut.getDescription());
		existStatut.setCategory(statut.getCategory());
	
		return statutRepository.save(existStatut);
	}

	
	@Override
	public void deleteStatut(String codeStatut) {
		statutRepository.deleteById(codeStatut);
	}

}
