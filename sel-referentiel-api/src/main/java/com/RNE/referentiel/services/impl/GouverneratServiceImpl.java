package com.RNE.referentiel.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.dto.GouverneratDTO;
import com.RNE.referentiel.dto.mappers.GouverneratMapper;
import com.RNE.referentiel.entities.Gouvernerat;
import com.RNE.referentiel.repositories.GouverneratRepository;
import com.RNE.referentiel.services.GouverneratService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GouverneratServiceImpl implements GouverneratService {

	private GouverneratRepository gouverneratRepository;
	private GouverneratMapper gouverneratMapper;

	// save delegation service
	@Override
	public GouverneratDTO saveGouvernerat(GouverneratDTO gouverneratDTO) {

		Gouvernerat gouvernerat = gouverneratMapper.toEntity(gouverneratDTO);
		return gouverneratMapper.toDto(gouverneratRepository.save(gouvernerat));
	}

	// get delegation by code service
	@Override
	public GouverneratDTO getGouverneratByCode(String code) {
		Optional<Gouvernerat> existDelegation = gouverneratRepository.findById(code);
		return existDelegation.map(gouverneratMapper::toDto).orElse(null);
	}

	// get all delegations services
	@Override
	public List<GouverneratDTO> getAllGouvernerats() {

		return gouverneratRepository.findAll().stream().map(gouverneratMapper::toDto).collect(Collectors.toList());
	}

	// update delegation service
	@Override
	public GouverneratDTO updateGouvernerat(String code, GouverneratDTO gouverneratDTO) {
		Gouvernerat existGouvernerat = gouverneratRepository.findById(code).orElse(null);
		if ( existGouvernerat == null) {
			return null;
		}

		 existGouvernerat.setNomFr(gouverneratDTO.getNomFr());
		 existGouvernerat.setNomAr(gouverneratDTO.getNomAr());
		 existGouvernerat.setActivation(gouverneratDTO.getActivation());

		return gouverneratMapper.toDto(gouverneratRepository.save(existGouvernerat));
	}

	@Override
	public List<GouverneratDTO> getActivatedGouvernerats() {

		return gouverneratRepository.getActivatedGouvernerats().stream().map(gouverneratMapper::toDto)
				.collect(Collectors.toList());
	}

	@Override
	public void deleteGouvernerat(String code) {
		gouverneratRepository.deleteById(code);
	}
}