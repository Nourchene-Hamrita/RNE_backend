package com.RNE.referentiel.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.RNE.referentiel.dto.DelegationDTO;
import com.RNE.referentiel.dto.mappers.DelegationMapper;
import com.RNE.referentiel.entities.Delegation;
import com.RNE.referentiel.repositories.DelegationRepository;
import com.RNE.referentiel.services.DelegationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DelegationServiceImpl implements DelegationService {

	private DelegationRepository delegationRepository;
	private DelegationMapper delegationMapper;

	// save delegation service
	@Override
	public DelegationDTO saveDelegation(DelegationDTO delegationDTO) {

		Delegation delegation = delegationMapper.toEntity(delegationDTO);
		return delegationMapper.toDto(delegationRepository.save(delegation));
	}

	// get delegation by code service
	@Override
	public DelegationDTO getDelegationByCode(String code) {
		Optional<Delegation> existDelegation = delegationRepository.findById(code);
		return existDelegation.map(delegationMapper::toDto).orElse(null);
	}

	// get all delegations services
	@Override
	public List<DelegationDTO> getAllDelegations() {

		return delegationRepository.findAll().stream().map(delegationMapper::toDto).collect(Collectors.toList());
	}

	// update delegation service
	@Override
	public DelegationDTO updateDelegation(String code, DelegationDTO delegationDTO) {
		Delegation existDelegation = delegationRepository.findById(code).orElse(null);
		if (existDelegation == null) {
			return null;
		}

		existDelegation.setNameFr(delegationDTO.getNameFr());
		existDelegation.setNameAr(delegationDTO.getNameAr());
		existDelegation.setActivation(delegationDTO.getActivation());

		return delegationMapper.toDto(delegationRepository.save(existDelegation));
	}

	@Override
	public List<DelegationDTO> getActivatedDelegations() {

		return delegationRepository.getActivatedDelegations().stream().map(delegationMapper::toDto)
				.collect(Collectors.toList());
	}

	@Override
	public void deleteDelegation(String code) {
		delegationRepository.deleteById(code);
	}
}