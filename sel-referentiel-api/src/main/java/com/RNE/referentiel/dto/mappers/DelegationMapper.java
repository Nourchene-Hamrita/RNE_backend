package com.RNE.referentiel.dto.mappers;

import org.mapstruct.Mapper;

import com.RNE.referentiel.dto.DelegationDTO;
import com.RNE.referentiel.entities.Delegation;

@Mapper(componentModel = "spring")
public interface DelegationMapper {

	DelegationDTO toDto(Delegation delegation);

	Delegation toEntity(DelegationDTO delegationDTO);
}