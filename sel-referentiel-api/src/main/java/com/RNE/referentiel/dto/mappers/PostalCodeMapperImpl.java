package com.RNE.referentiel.dto.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.RNE.referentiel.dto.CityDTO;
import com.RNE.referentiel.dto.PostalCodeDTO;
import com.RNE.referentiel.entities.City;
import com.RNE.referentiel.entities.PostalCode;
import com.RNE.referentiel.repositories.CityRepository;

@Component
public class PostalCodeMapperImpl implements PostalCodeMapper {

	@Autowired
	private CityRepository cityRepository;

	@Override
	public PostalCodeDTO toDto(PostalCode postalCode) {

		if (postalCode == null) {
			return null;
		}

		PostalCodeDTO postalCodeDTO = new PostalCodeDTO();
		postalCodeDTO.setId(postalCode.getId());
		postalCodeDTO.setPostalCode(postalCode.getPostalCode());

		City city = postalCode.getCity();
		if (city != null) {
			postalCodeDTO.setCity(new CityDTO(city.getCode(), city.getNameFr(), city.getNameAr(), city.getActivation(),
					city.getDelegation().getCode()));
		}

		return postalCodeDTO;
	}

	@Override
	public PostalCode toEntity(PostalCodeDTO postalCodeDTO) {

		if (postalCodeDTO == null) {
			return null;
		}

		PostalCode postalCode = new PostalCode();
		postalCode.setId(postalCodeDTO.getId());
		postalCode.setPostalCode(postalCodeDTO.getPostalCode());

		String cityCode = postalCodeDTO.getCity().getCode();
		if (cityCode != null) {
			City city = cityRepository.findById(cityCode).orElse(null);
			postalCode.setCity(city);
		}

		return postalCode;
	}

}