package com.RNE.request.dto.mappers;

import org.mapstruct.Mapper;

import com.RNE.request.dto.AssociationDTO;
import com.RNE.request.entities.Association;

@Mapper(componentModel = "spring")
public interface AssociationMapper {
	
	AssociationDTO toDto(Association association);

	Association toEntity(AssociationDTO associationDTO);
}