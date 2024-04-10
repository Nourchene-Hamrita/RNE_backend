package com.RNE.referentiel.dto.mappers;

import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.RNE.referentiel.dto.CityDTO;
import com.RNE.referentiel.entities.City;
import com.RNE.referentiel.entities.Delegation;

@Component
public class CityMapperImpl implements CityMapper {

	private static final CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);

	@Override
	public CityDTO toDto(City city) {
		if (city == null) {
			return null;
		}

		CityDTO cityDTO = new CityDTO();
		cityDTO.setCode(city.getCode());
		cityDTO.setNameFr(city.getNameFr());
		cityDTO.setNameAr(city.getNameAr());
		cityDTO.setActivation(city.getActivation());

		// Populate delegationDTO object
		Delegation delegation = city.getDelegation();
		if (delegation != null) {
			cityDTO.setDelegationCode(delegation.getCode());
		}

		return cityDTO;
	}

	@Override
	public City toEntity(CityDTO cityDTO) {
		if (cityDTO == null) {
			return null;
		}

		City city = new City();
		city.setCode(cityDTO.getCode());
		city.setNameFr(cityDTO.getNameFr());
		city.setNameAr(cityDTO.getNameAr());
		city.setActivation(cityDTO.getActivation());

		// Populate Delegation object
		String delegationCode = cityDTO.getDelegationCode();
		if (delegationCode != null) {
			Delegation delegation = new Delegation();
			delegation.setCode(delegationCode);
			city.setDelegation(delegation);
		}

		return city;
	}

	public static CityMapper getInstance() {
		return INSTANCE;
	}
}