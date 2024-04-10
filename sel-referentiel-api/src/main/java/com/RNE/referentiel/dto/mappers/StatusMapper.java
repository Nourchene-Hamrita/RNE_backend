package com.RNE.referentiel.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.RNE.referentiel.dto.StatusDTO;
import com.RNE.referentiel.entities.Status;

@Mapper(componentModel = "spring")
public interface StatusMapper {

	@Mappings({ @Mapping(source = "category", target = "category") })
	StatusDTO toDto(Status status);

	@Mappings({ @Mapping(source = "category", target = "category") })
	Status toEntity(StatusDTO statusDTO);

}