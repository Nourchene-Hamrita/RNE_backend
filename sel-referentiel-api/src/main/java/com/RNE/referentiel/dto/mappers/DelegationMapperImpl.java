package com.RNE.referentiel.dto.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RNE.referentiel.dto.CityDTO;
import com.RNE.referentiel.dto.DelegationDTO;
import com.RNE.referentiel.entities.City;
import com.RNE.referentiel.entities.Delegation;

@Component
public class DelegationMapperImpl implements DelegationMapper {

	private static final DelegationMapper INSTANCE = Mappers.getMapper(DelegationMapper.class);
	@Autowired
	private CityMapper cityMapper;

	@Override
	public DelegationDTO toDto(Delegation delegation) {
		if (delegation == null) {
			return null;
		}

		DelegationDTO delegationDTO = new DelegationDTO();
		delegationDTO.setCode(delegation.getCode());
		delegationDTO.setNameFr(delegation.getNameFr());
		delegationDTO.setNameAr(delegation.getNameAr());
		delegationDTO.setActivation(delegation.getActivation());

		// Populate CityDTO objects
		List<City> cityEntities = delegation.getCities();
		if (cityEntities != null) {
			delegationDTO.setCities(cityEntities.stream().map(cityMapper::toDto).collect(Collectors.toList()));
		}

		return delegationDTO;
	}

	@Override
	public Delegation toEntity(DelegationDTO delegationDTO) {
		if (delegationDTO == null) {
			return null;
		}

		Delegation delegation = new Delegation();
		delegation.setCode(delegationDTO.getCode());
		delegation.setNameFr(delegationDTO.getNameFr());
		delegation.setNameAr(delegationDTO.getNameAr());
		delegation.setActivation(delegationDTO.getActivation());

		// Populate cities objects
		List<CityDTO> cityDTOs = delegationDTO.getCities();
		if (cityDTOs != null) {
			delegation.setCities(cityDTOs.stream().map(cityMapper::toEntity).collect(Collectors.toList()));
		}

		return delegation;
	}

	public static DelegationMapper getInstance() {
		return INSTANCE;
	}
}