package com.RNE.referentiel.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.dto.StatutDTO;
import com.RNE.referentiel.dto.mappers.SectionMapper;
import com.RNE.referentiel.dto.mappers.StatutMapper;
import com.RNE.referentiel.entities.Section;
import com.RNE.referentiel.entities.Statut;

import com.RNE.referentiel.repositories.SectionRepository;
import com.RNE.referentiel.repositories.StatutRepository;
import com.RNE.referentiel.services.StatutService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StatutServiceImpl implements StatutService {

	private StatutRepository statutRepository;
	private StatutMapper statutMapper;
	private SectionMapper sectionMapper;
	//private SectionRepository sectionRepository;

	// save status service
	@Override
	public StatutDTO saveStatut(StatutDTO statutDTO) {
	    Statut statut = statutMapper.toEntity(statutDTO);
	   /* if (statutDTO.getSections() != null) {
	        List<Section> sections = statutDTO.getSections().stream()
	            .map(sectionMapper::toEntity)
	            .collect(Collectors.toList());
	        statut.setSections(sections);
	    }*/
	    return statutMapper.toDto(statutRepository.save(statut));
	}


	// get status by code service
	@Override
	public StatutDTO getStatutByCode(String code) {
		Optional<Statut> existStatus = statutRepository.findById(code);
		return existStatus.map(statutMapper::toDto).orElse(null);
	}

	// get all statuses services
	@Override
	public List<StatutDTO> getAllStatuts() {

		return statutRepository.findAll().stream().map(statutMapper::toDto).collect(Collectors.toList());
	}

	// update status service
	@Override
	public StatutDTO updateStatut(String code, StatutDTO statutDTO) {
		Statut existStatus = statutRepository.findById(code).orElse(null);
		if (existStatus == null) {
			return null;
		}

		existStatus.setTitre(statutDTO.getTitre());
		existStatus.setDescription(statutDTO.getDescription());
		existStatus.setCategorie(statutDTO.getCategorie());

		return statutMapper.toDto(statutRepository.save(existStatus));
	}

	@Override
	public void deleteStatut(String code) {
		statutRepository.deleteById(code);
	}

}