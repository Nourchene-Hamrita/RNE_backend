package com.RNE.referentiel.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.entities.Governorate;
import com.RNE.referentiel.repositories.GovernorateRepository;
import com.RNE.referentiel.serviceInterface.GovernorateService;

import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor
public class GovernorateServiceImpl implements GovernorateService {
     
	
	private GovernorateRepository gouverneratRepo;
	
	
	//service for creating a new Governorate
	@Override
	
	public Governorate saveGovernorate(Governorate gouv) {
		
		return gouverneratRepo.save(gouv);
		 
	}

   //get list of Governorate
	@Override
	public List<Governorate> getAllGovernorates() {
		
		return gouverneratRepo.findAll();
	}

@Override
public Governorate getGovernorateByCode(String govCode) {
	Optional<Governorate> gouvernerat=gouverneratRepo.findById(govCode);
	return gouvernerat.get();
}

@Override
public Governorate updateGovernorate(String govCode, Governorate gouv) {

  Optional<Governorate> existing = gouverneratRepo.findById(govCode);

  if(existing.isPresent()) {
    Governorate gouvernerat = existing.get();
    gouvernerat.setGovNameFr(gouv.getGovNameFr());
    gouvernerat.setGovNamevAr(gouv.getGovNamevAr());
    gouvernerat.setActivation(gouv.getActivation());
    return gouverneratRepo.save(gouv);
  } else {
       return null;
  }

}



@Override
public List<Governorate> getActivatedGovernorate() {
	
	return gouverneratRepo.getActivatedGov();
}
@Override
public void deleteGovernorate(String govCode) {
  gouverneratRepo.deleteById(govCode);
}




	

}
