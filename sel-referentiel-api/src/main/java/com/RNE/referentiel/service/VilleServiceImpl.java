package com.RNE.referentiel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.entities.Ville;
import com.RNE.referentiel.repositories.VilleRepository;
import com.RNE.referentiel.serviceInterface.VilleService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class VilleServiceImpl implements VilleService {
   
	private VilleRepository villeRepository;
	
	
	//save ville service
	@Override
	public Ville saveVille(Ville ville) {
		
		return villeRepository.save(ville) ;
	}

    //get ville by code service
	@Override
	public Ville getVilleByCode(String codeVille) {
		Optional<Ville> existVille =villeRepository.findById(codeVille);
		return existVille.get();
	}
    // get all villes services
	@Override
	public List<Ville> getAllVille() {
		
		return villeRepository.findAll();
	}
   //update ville service
	@Override
	public Ville updateVille(String codeVille, Ville ville) {
		Ville existVille=villeRepository.findById(codeVille).orElse(null);
		existVille.setNomVilleFr(ville.getNomVilleFr());
		existVille.setNomVilleAr(ville.getNomVilleAr());
		existVille.setActivation(ville.getActivation());
		existVille.setGouvernerat(ville.getGouvernerat());
		return villeRepository.save(existVille);
	}

	@Override
	public List<Ville> getActivatedVille() {
		
		return villeRepository.getActivatedVille();
	}
	@Override
	public void deleteVille(String codeVille) {
		villeRepository.deleteById(codeVille);
	}

}
