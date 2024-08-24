package com.RNE.referentiel.services.impl;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.RNE.referentiel.dto.FormeJuridiqueDto;
import com.RNE.referentiel.dto.mappers.FormeJuridiqueMapper;
import com.RNE.referentiel.entities.FormeJuridique;
import com.RNE.referentiel.entities.Gouvernorat;
import com.RNE.referentiel.repositories.FormeJuridiqueRepository;
import com.RNE.referentiel.services.FormeJuridiqueService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FormeJuridiqueServiceImpl implements FormeJuridiqueService {

	private FormeJuridiqueRepository formeJuridiqueRepo;
	private FormeJuridiqueMapper formeJuridiqueMapper;

	@Override
	public FormeJuridiqueDto saveFormeJuridique(FormeJuridiqueDto formejuridiqueDto) {

		FormeJuridique formeJuridique = formeJuridiqueMapper.toEntity(formejuridiqueDto);
		return formeJuridiqueMapper.toDto(formeJuridiqueRepo.save(formeJuridique));

	}

	@Override
	public List<FormeJuridiqueDto> getAllFormeJuridique() {

		return formeJuridiqueRepo.findAll().stream().map(formeJuridiqueMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public FormeJuridiqueDto updateFormeJuridique(Long id, FormeJuridiqueDto formeJuridiqueDto) {
		FormeJuridique existFormeJuridique = formeJuridiqueRepo.findById(id).orElse(null);
		if (existFormeJuridique == null) {
			return null;
		}

		existFormeJuridique.setNom(formeJuridiqueDto.getNom());
		existFormeJuridique.setActivation(formeJuridiqueDto.getActivation());
		existFormeJuridique.setCategorie(formeJuridiqueDto.getCategorie());

		return formeJuridiqueMapper.toDto(formeJuridiqueRepo.save(existFormeJuridique));
	}

	@Override
	public Page<FormeJuridiqueDto> getFormeJuridiquePagination(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
	    Page<FormeJuridique> formejuridiquePage = formeJuridiqueRepo.findAll(pageable);
	    
	    return formejuridiquePage.map(formeJuridiqueMapper::toDto);
	}

}
