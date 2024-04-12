package com.RNE.request.dto.mappers;

import org.mapstruct.Mapper;
import com.RNE.request.dto.OrganizationDTO;
import com.RNE.request.entities.Organization;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {
	
	OrganizationDTO toDto(Organization organization);

	Organization toEntity(OrganizationDTO organizationDTO);
}