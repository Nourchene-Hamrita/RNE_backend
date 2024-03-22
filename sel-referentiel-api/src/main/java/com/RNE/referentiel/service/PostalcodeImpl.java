package com.RNE.referentiel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.entities.PostalCode;
import com.RNE.referentiel.repositories.PostalCodeRepository;
import com.RNE.referentiel.serviceInterface.PostalCodeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostalcodeImpl implements PostalCodeService {
	
	private PostalCodeRepository codePostalRepo;

	@Override
	public PostalCode savePostalCode(PostalCode codePostal) {
		
		return codePostalRepo.save(codePostal);
	}

	@Override
	public PostalCode getPostalCodeById(Long id) {
	 PostalCode	existPostalCode=codePostalRepo.findById(id).orElse(null);
		return existPostalCode;
	}

	@Override
	public List<PostalCode> getAllPostalCode() {
		
		return codePostalRepo.findAll();
	}

	@Override
	public PostalCode updatePostalCode(Long id, PostalCode codePostal) {
		 PostalCode	existPostalCode=codePostalRepo.findById(id).orElse(null);
		 existPostalCode.setPostalCode(codePostal.getPostalCode());
		 existPostalCode.setCity(codePostal.getCity());
		return codePostalRepo.save(existPostalCode);
	}

	@Override
	public void deletePostalCode(Long id) {
		codePostalRepo.deleteById(id);
		
	}

}
