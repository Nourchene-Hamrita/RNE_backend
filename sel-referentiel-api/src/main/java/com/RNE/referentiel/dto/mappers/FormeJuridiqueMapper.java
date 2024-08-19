package com.RNE.referentiel.dto.mappers;

import org.mapstruct.Mapper;

import com.RNE.referentiel.dto.FormeJuridiqueDto;
import com.RNE.referentiel.entities.FormeJuridique;

@Mapper(componentModel = "spring")
public interface FormeJuridiqueMapper {
 
	FormeJuridiqueDto toDto(FormeJuridique formeJuridique);
	
	FormeJuridique toEntity(FormeJuridiqueDto formeJuridiqueDto);
}
