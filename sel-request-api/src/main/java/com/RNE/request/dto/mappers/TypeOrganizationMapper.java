package com.RNE.request.dto.mappers;

import org.mapstruct.Mapper;
import com.RNE.request.dto.TypeOrganizationDTO;
import com.RNE.request.entities.TypeOrganization;

@Mapper(componentModel = "spring")

public interface TypeOrganizationMapper {
	TypeOrganizationDTO toDto(TypeOrganization typeOrganization);

	TypeOrganization toEntity(TypeOrganizationDTO typeOrganizationDTO);
}