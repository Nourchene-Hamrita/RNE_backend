package com.RNE.referentiel.dto.mappers;

import org.mapstruct.Mapper;
import com.RNE.referentiel.dto.PostalCodeDTO;
import com.RNE.referentiel.entities.PostalCode;

@Mapper(componentModel = "spring")
public interface PostalCodeMapper {

	PostalCodeDTO toDto(PostalCode postalCode);

	PostalCode toEntity(PostalCodeDTO postalCodeDTO);

}