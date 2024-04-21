package com.RNE.referentiel.dto.mappers;

import org.mapstruct.Mapper;

import com.RNE.referentiel.dto.GouverneratDTO;
import com.RNE.referentiel.entities.Gouvernerat;

@Mapper(componentModel = "spring")
public interface GouverneratMapper {

	GouverneratDTO toDto(Gouvernerat gouvernerat);

	Gouvernerat toEntity(GouverneratDTO gouverneratDTO);
}