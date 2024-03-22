package com.RNE.referentiel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.entities.Statut;
import com.RNE.referentiel.entities.Ville;
import com.RNE.referentiel.repositories.StatutRepository;
import com.RNE.referentiel.repositories.VilleRepository;
import com.RNE.referentiel.serviceInterface.StatutService;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StatusServiceImpl implements StatutService {
   
	private StatutRepository statutRepository;
	
	
	//save statut service
	@Override
	public Statut saveStatut(Statut statut) {
		
		return statutRepository.save(statut) ;
	}

    //get statut by code service
	@Override
	public  Statut getStatutByCode(String codeStatut) {
		Optional<Statut> existStatut =statutRepository.findById(codeStatut);
		return existStatut.get();
	}
    // get all statut services
	@Override
	public List<Statut> getAllStatut() {
		
		return statutRepository.findAll();
	}
   //update statut service
	@Override
	public Statut updateStatut(String codeStatut, Statut statut) {
		Statut existStatut=statutRepository.findById(codeStatut).orElse(null);
		existStatut.setTitreStatut(statut.getTitreStatut());
		existStatut.setDescription(statut.getDescription());
		existStatut.setCategorie(statut.getCategorie());
	
		return statutRepository.save(existStatut);
	}

	
	@Override
	public void deleteStatut(String codeStatut) {
		statutRepository.deleteById(codeStatut);
	}

}
