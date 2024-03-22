package com.RNE.referentiel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.entities.CodePostal;
import com.RNE.referentiel.repositories.CodePostalRepository;
import com.RNE.referentiel.serviceInterface.codePostalService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class codePostalImpl implements codePostalService {
	
	private CodePostalRepository codePostalRepo;

	@Override
	public CodePostal saveCodePostal(CodePostal codePostal) {
		
		return codePostalRepo.save(codePostal);
	}

	@Override
	public CodePostal getCodePostalById(Long id) {
	 CodePostal	existCodePostal=codePostalRepo.findById(id).orElse(null);
		return existCodePostal;
	}

	@Override
	public List<CodePostal> getAllCodesPostal() {
		
		return codePostalRepo.findAll();
	}

	@Override
	public CodePostal updateCodePostal(Long id, CodePostal codePostal) {
		 CodePostal	existCodePostal=codePostalRepo.findById(id).orElse(null);
		 existCodePostal.setCodePostal(codePostal.getCodePostal());
		 existCodePostal.setVille(codePostal.getVille());
		return codePostalRepo.save(existCodePostal);
	}

	@Override
	public void deleteCodePostal(Long id) {
		codePostalRepo.deleteById(id);
		
	}

}
