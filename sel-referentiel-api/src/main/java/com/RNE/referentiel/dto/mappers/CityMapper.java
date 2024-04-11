package com.RNE.referentiel.dto.mappers;

import org.mapstruct.Mapper;

import com.RNE.referentiel.dto.CityDTO;
import com.RNE.referentiel.entities.City;

@Mapper(componentModel = "spring")
public interface CityMapper {

	CityDTO toDto(City city);

	City toEntity(CityDTO cityDTO);
}