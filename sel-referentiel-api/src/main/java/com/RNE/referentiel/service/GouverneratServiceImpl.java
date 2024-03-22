package com.RNE.referentiel.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.entities.Gouvernerat;
import com.RNE.referentiel.repositories.GouverneratRepository;
import com.RNE.referentiel.serviceInterface.GouverneratService;

import lombok.AllArgsConstructor;



@Service
@AllArgsConstructor
public class GouverneratServiceImpl implements GouverneratService {
     
	
	private GouverneratRepository gouverneratRepo;
	
	
	//service for creating a new gouv
	@Override
	
	public Gouvernerat saveGouvernerat(Gouvernerat gouv) {
		
		return gouverneratRepo.save(gouv);
		 
	}

   //get list of gouvernerat
	@Override
	public List<Gouvernerat> getAllGouvernerats() {
		
		return gouverneratRepo.findAll();
	}

@Override
public Gouvernerat getGouverneratByCode(String codeGouv) {
	Optional<Gouvernerat> gouvernerat=gouverneratRepo.findById(codeGouv);
	return gouvernerat.get();
}

@Override
public Gouvernerat updateGouvernerat(String codeGouv, Gouvernerat gouv) {

  Optional<Gouvernerat> existing = gouverneratRepo.findById(codeGouv);

  if(existing.isPresent()) {
    Gouvernerat gouvernerat = existing.get();

  
    gouvernerat.setNomGouvFr(gouv.getNomGouvFr());
    gouvernerat.setNomGouvAr(gouv.getNomGouvAr());
    gouvernerat.setActivation(gouv.getActivation());
    return gouverneratRepo.save(gouvernerat);
  } else {
       return null;
  }

}



@Override
public List<Gouvernerat> getActivatedGouvernerat() {
	
	return gouverneratRepo.getActivatedGouv();
}
@Override
public void deleteGouvernerat(String code_gouv) {
  gouverneratRepo.deleteById(code_gouv);
}




	

}
