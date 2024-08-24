package com.RNE.referentiel.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.RNE.referentiel.dto.CodePostalDTO;
import com.RNE.referentiel.dto.mappers.VilleMapper;
import com.RNE.referentiel.dto.mappers.CodePostalMapper;
import com.RNE.referentiel.entities.CodePostal;
import com.RNE.referentiel.entities.Ville;
import com.RNE.referentiel.repositories.CodePostalRepository;
import com.RNE.referentiel.repositories.VilleRepository;
import com.RNE.referentiel.services.CodePostalService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CodePostalImpl implements CodePostalService {

	private CodePostalRepository codePostalRepo;
	private VilleRepository villeRepository;
	private CodePostalMapper codePostalMapper;
	private VilleMapper villeMapper;

	@Override
	public CodePostalDTO saveCodePostal(CodePostalDTO codePostalDTO) {

		return codePostalMapper.toDto(codePostalRepo.save(codePostalMapper.toEntity(codePostalDTO)));
	}

	@Override
	public CodePostalDTO getCodePostalById(Long id) {

		CodePostal existPostalCode = codePostalRepo.findById(id).orElse(null);
		return codePostalMapper.toDto(existPostalCode);
	}

	@Override
	public List<CodePostalDTO> getAllCodePostal() {

		return codePostalRepo.findAll().stream().map(codePostalMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public CodePostalDTO updateCodePostal(Long id, CodePostalDTO codePostalDTO) {

	    // Fetch the existing CodePostal entity
	    CodePostal existCodePostal = codePostalRepo.findById(id).orElse(null);
	    if (existCodePostal == null) {
	        return null;  // Handle the case where the CodePostal is not found
	    }

	    // Update the codePostal field if provided
	    if (codePostalDTO.getCodePostal() != null) {
	        existCodePostal.setCodePostal(codePostalDTO.getCodePostal());
	        existCodePostal.setActivation(codePostalDTO.getActivation());
	    }

	    // Update the Ville association if codeVille is provided
	    if (codePostalDTO.getCodeVille() != null) {
	        Ville ville = villeRepository.findById(codePostalDTO.getCodeVille()).orElse(null);
	        if (ville != null) {
	            existCodePostal.setVille(ville);  // Update the Ville association
	        } else {
	            // Handle the case where the Ville with the given codeVille is not found
	            // Depending on your requirements, you could throw an exception here
	            throw new RuntimeException("Ville not found with code: " + codePostalDTO.getCodeVille());
	        }
	    }

	    // Save the updated CodePostal entity and return the corresponding DTO
	    return codePostalMapper.toDto(codePostalRepo.save(existCodePostal));
	}

	@Override
	public void deleteCodePostal(Long id) {

		codePostalRepo.deleteById(id);

	}

	@Override
	public Page<CodePostalDTO> getPostalPagination(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
	    Page<CodePostal> codePostalPage = codePostalRepo.findAll(pageable);
	    
	    return  codePostalPage.map(codePostalMapper::toDto);
	}

}