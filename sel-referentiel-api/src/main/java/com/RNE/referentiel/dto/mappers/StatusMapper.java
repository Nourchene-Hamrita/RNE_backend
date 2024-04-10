package com.RNE.referentiel.dto.mappers;

import org.mapstruct.Mapper;

import com.RNE.referentiel.dto.StatusDTO;
import com.RNE.referentiel.entities.Status;

@Mapper(componentModel = "spring")
public interface StatusMapper {

    StatusDTO toDto(Status status);

    Status toEntity(StatusDTO statusDTO);
}